package modules.classmanager.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.skyve.CORE;
import org.skyve.domain.messages.DomainException;
import org.skyve.impl.domain.AbstractPersistentBean;

/**
 * Client
 * <br/>
 * Contact
 * 
 * @navcomposed n addresses 0..n Address
 * @navcomposed n phoneNumbers 0..n PhoneNumber
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class Contact extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "classmanager";
	/** @hidden */
	public static final String DOCUMENT_NAME = "Contact";

	/** @hidden */
	public static final String firstNamePropertyName = "firstName";
	/** @hidden */
	public static final String lastNamePropertyName = "lastName";
	/** @hidden */
	public static final String emailAddressPropertyName = "emailAddress";
	/** @hidden */
	public static final String phoneNumbersPropertyName = "phoneNumbers";
	/** @hidden */
	public static final String addressesPropertyName = "addresses";
	/** @hidden */
	public static final String imagePropertyName = "image";

	/**
	 * First Name
	 **/
	private String firstName;
	/**
	 * Last Name
	 **/
	private String lastName;
	/**
	 * Email Address
	 **/
	private String emailAddress;
	/**
	 * Phone Numbers
	 **/
	private List<PhoneNumber> phoneNumbers = new ArrayList<>();
	/**
	 * Addresses
	 **/
	private List<Address> addresses = new ArrayList<>();
	/**
	 * Image
	 **/
	private String image;

	@Override
	@XmlTransient
	public String getBizModule() {
		return Contact.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return Contact.DOCUMENT_NAME;
	}

	public static Contact newInstance() {
		try {
			return CORE.getUser().getCustomer().getModule(MODULE_NAME).getDocument(CORE.getUser().getCustomer(), DOCUMENT_NAME).newInstance(CORE.getUser());
		}
		catch (RuntimeException e) {
			throw e;
		}
		catch (Exception e) {
			throw new DomainException(e);
		}
	}

	@Override
	@XmlTransient
	public String getBizKey() {
throw new java.lang.IllegalArgumentException("Overidden in extension class");
	}

	@Override
	public boolean equals(Object o) {
		return ((o instanceof Contact) && 
					this.getBizId().equals(((Contact) o).getBizId()));
	}

	/**
	 * {@link #firstName} accessor.
	 * @return	The value.
	 **/
	public String getFirstName() {
		return firstName;
	}

	/**
	 * {@link #firstName} mutator.
	 * @param firstName	The new value.
	 **/
	@XmlElement
	public void setFirstName(String firstName) {
		preset(firstNamePropertyName, firstName);
		this.firstName = firstName;
	}

	/**
	 * {@link #lastName} accessor.
	 * @return	The value.
	 **/
	public String getLastName() {
		return lastName;
	}

	/**
	 * {@link #lastName} mutator.
	 * @param lastName	The new value.
	 **/
	@XmlElement
	public void setLastName(String lastName) {
		preset(lastNamePropertyName, lastName);
		this.lastName = lastName;
	}

	/**
	 * {@link #emailAddress} accessor.
	 * @return	The value.
	 **/
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * {@link #emailAddress} mutator.
	 * @param emailAddress	The new value.
	 **/
	@XmlElement
	public void setEmailAddress(String emailAddress) {
		preset(emailAddressPropertyName, emailAddress);
		this.emailAddress = emailAddress;
	}

	/**
	 * {@link #phoneNumbers} accessor.
	 * @return	The value.
	 **/
	@XmlElement
	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	/**
	 * {@link #phoneNumbers} accessor.
	 * @param bizId	The bizId of the element in the list.
	 * @return	The value of the element in the list.
	 **/
	public PhoneNumber getPhoneNumbersElementById(String bizId) {
		return getElementById(phoneNumbers, bizId);
	}

	/**
	 * {@link #phoneNumbers} mutator.
	 * @param bizId	The bizId of the element in the list.
	 * @param element	The new value of the element in the list.
	 **/
	public void setPhoneNumbersElementById(String bizId, PhoneNumber element) {
		 setElementById(phoneNumbers, element);
	}

	/**
	 * {@link #addresses} accessor.
	 * @return	The value.
	 **/
	@XmlElement
	public List<Address> getAddresses() {
		return addresses;
	}

	/**
	 * {@link #addresses} accessor.
	 * @param bizId	The bizId of the element in the list.
	 * @return	The value of the element in the list.
	 **/
	public Address getAddressesElementById(String bizId) {
		return getElementById(addresses, bizId);
	}

	/**
	 * {@link #addresses} mutator.
	 * @param bizId	The bizId of the element in the list.
	 * @param element	The new value of the element in the list.
	 **/
	public void setAddressesElementById(String bizId, Address element) {
		 setElementById(addresses, element);
	}

	/**
	 * {@link #image} accessor.
	 * @return	The value.
	 **/
	public String getImage() {
		return image;
	}

	/**
	 * {@link #image} mutator.
	 * @param image	The new value.
	 **/
	@XmlElement
	public void setImage(String image) {
		preset(imagePropertyName, image);
		this.image = image;
	}
}
