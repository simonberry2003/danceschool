package modules.classmanager.Client.actions;

import javax.inject.Inject;

import org.skyve.metadata.controller.ServerSideAction;
import org.skyve.metadata.controller.ServerSideActionResult;
import org.skyve.persistence.Persistence;
import org.skyve.web.WebContext;

import com.hbs.xero.XeroClientProvider;

import lombok.val;
import modules.classmanager.Client.ClientExtension;
import modules.classmanager.Client.ClientProvider;
import modules.classmanager.Contact.ContactExtension;
import modules.classmanager.domain.Address;
import modules.classmanager.domain.Address.AddressType;
import modules.classmanager.domain.Address.State;
import modules.classmanager.domain.Client;
import modules.classmanager.domain.Contact;
import modules.classmanager.domain.PhoneNumber;
import modules.classmanager.domain.PhoneNumber.PhoneNumberType;

@SuppressWarnings("serial")
public class ImportFromXero implements ServerSideAction<ClientExtension> {

	private @Inject Persistence persistence;
	private @Inject XeroClientProvider xeroClientProvider;
	private @Inject ClientProvider clientProvider;

	@Override
	public ServerSideActionResult<ClientExtension> execute(ClientExtension client, WebContext webContext) throws Exception {
		val xeroClient = xeroClientProvider.getClient();
		val xeroContacts = xeroClient.getContacts();
		for (val xeroContact : xeroContacts) {
			// Only import real people with an email address
			if (xeroContact.getEmailAddress() != null && xeroContact.getFirstName() != null && xeroContact.getLastName() != null) {

				// Ignore if we have already imported
				ClientExtension newClient = clientProvider.getByExternalId(xeroContact.getContactID());
				if (newClient != null) {
					continue;
				}

				// Create a new contact
				val contact = (ContactExtension) Contact.newInstance();
				contact.setFirstName(xeroContact.getFirstName());
				contact.setLastName(xeroContact.getLastName());
				contact.setEmailAddress(xeroContact.getEmailAddress());

				// Phone numbers
				for (val xeroPhone : xeroContact.getPhones().getPhone()) {

					// Skip if no phone number. Xero returns place holders.
					val xeroPhoneNumber = xeroPhone.getPhoneNumber();
					if (xeroPhoneNumber == null) {
						continue;
					}
					val phoneNumber = PhoneNumber.newInstance();
					phoneNumber.setType(PhoneNumberType.valueOf(xeroPhone.getPhoneType().name()));
					phoneNumber.setCountryCode(xeroPhone.getPhoneCountryCode());
					phoneNumber.setAreaCode(xeroPhone.getPhoneAreaCode());
					phoneNumber.setNumber(xeroPhone.getPhoneNumber());
					contact.addPhoneNumber(phoneNumber);
				}

				// Address
				for (val xeroAddress : xeroContact.getAddresses().getAddress()) {
					// Ignore if no street address, Xero returns place holders.
					if (xeroAddress.getAddressLine1() == null) {
						continue;
					}
					val address = Address.newInstance();
					address.setType(AddressType.valueOf(xeroAddress.getAddressType().name()));
					address.setStreetAddress(xeroAddress.getAddressLine1());
					address.setSuburb(xeroAddress.getCity());
					address.setPostcode(xeroAddress.getPostalCode() == null ? "" : xeroAddress.getPostalCode());
					address.setState(State.SA);
					contact.addAddress(address);
				}

				newClient = (ClientExtension) Client.newInstance();
				newClient.setExternalId(xeroContact.getContactID());
				newClient.setContact(contact);
				try {
					persistence.save(newClient);
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return new ServerSideActionResult<>(client);
	}
}
