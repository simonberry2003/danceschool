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
 * Venue
 * <br/>
 * Venue
 * 
 * @navcomposed n address 1 Address
 * @navcomposed n contacts 0..n Contact
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class Venue extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "classmanager";
	/** @hidden */
	public static final String DOCUMENT_NAME = "Venue";

	/** @hidden */
	public static final String namePropertyName = "name";
	/** @hidden */
	public static final String addressPropertyName = "address";
	/** @hidden */
	public static final String contactsPropertyName = "contacts";

	/**
	 * Name
	 **/
	private String name;
	/**
	 * Address
	 **/
	private Address address = null;
	/**
	 * Contacts
	 **/
	private List<Contact> contacts = new ArrayList<>();

	@Override
	@XmlTransient
	public String getBizModule() {
		return Venue.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return Venue.DOCUMENT_NAME;
	}

	public static Venue newInstance() {
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
		return ((o instanceof Venue) && 
					this.getBizId().equals(((Venue) o).getBizId()));
	}

	/**
	 * {@link #name} accessor.
	 * @return	The value.
	 **/
	public String getName() {
		return name;
	}

	/**
	 * {@link #name} mutator.
	 * @param name	The new value.
	 **/
	@XmlElement
	public void setName(String name) {
		preset(namePropertyName, name);
		this.name = name;
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
	 * {@link #contacts} accessor.
	 * @return	The value.
	 **/
	@XmlElement
	public List<Contact> getContacts() {
		return contacts;
	}

	/**
	 * {@link #contacts} accessor.
	 * @param bizId	The bizId of the element in the list.
	 * @return	The value of the element in the list.
	 **/
	public Contact getContactsElementById(String bizId) {
		return getElementById(contacts, bizId);
	}

	/**
	 * {@link #contacts} mutator.
	 * @param bizId	The bizId of the element in the list.
	 * @param element	The new value of the element in the list.
	 **/
	public void setContactsElementById(String bizId, Contact element) {
		 setElementById(contacts, element);
	}
}
