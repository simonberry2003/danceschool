package modules.classmanager.Contact;

import com.google.common.base.Preconditions;

import modules.classmanager.domain.Address;
import modules.classmanager.domain.Contact;
import modules.classmanager.domain.PhoneNumber;

@SuppressWarnings("serial")
public class ContactExtension extends Contact {
	@Override
	public String getBizKey() {
		return String.format("%s %s", getFirstName(), getLastName());
	}

	@Override
	public String toString() {
		return getBizKey();
	}

	public void addPhoneNumber(PhoneNumber phoneNumber) {
		Preconditions.checkNotNull(phoneNumber);
		getPhoneNumbers().add(phoneNumber);
	}

	public void addAddress(Address address) {
		Preconditions.checkNotNull(address);
		getAddresses().add(address);
	}
}
