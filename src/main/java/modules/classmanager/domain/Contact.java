package modules.classmanager.domain;

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
 * @navcomposed n address 0..1 Address
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
	public static final String emailPropertyName = "email";
	/** @hidden */
	public static final String phoneNumberPropertyName = "phoneNumber";
	/** @hidden */
	public static final String addressPropertyName = "address";
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
	 * Email
	 **/
	private String email;
	/**
	 * Phone Number
	 **/
	private String phoneNumber;
	/**
	 * Address
	 **/
	private Address address = null;
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
	 * {@link #email} accessor.
	 * @return	The value.
	 **/
	public String getEmail() {
		return email;
	}

	/**
	 * {@link #email} mutator.
	 * @param email	The new value.
	 **/
	@XmlElement
	public void setEmail(String email) {
		preset(emailPropertyName, email);
		this.email = email;
	}

	/**
	 * {@link #phoneNumber} accessor.
	 * @return	The value.
	 **/
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * {@link #phoneNumber} mutator.
	 * @param phoneNumber	The new value.
	 **/
	@XmlElement
	public void setPhoneNumber(String phoneNumber) {
		preset(phoneNumberPropertyName, phoneNumber);
		this.phoneNumber = phoneNumber;
	}

	/**
	 * {@link #address} accessor.
	 * @return	The value.
	 **/
	public Address getAddress() {
		return address;
	}

	/**
	 * {@link #address} mutator.
	 * @param address	The new value.
	 **/
	@XmlElement
	public void setAddress(Address address) {
		preset(addressPropertyName, address);
		this.address = address;
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
