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
 * Client Details
 * 
 * @navcomposed n contact 1 Contact
 * @navcomposed n students 0..n Student
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class Client extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "classmanager";
	/** @hidden */
	public static final String DOCUMENT_NAME = "Client";

	/** @hidden */
	public static final String clientIdPropertyName = "clientId";
	/** @hidden */
	public static final String contactPropertyName = "contact";
	/** @hidden */
	public static final String studentsPropertyName = "students";

	/**
	 * Id
	 **/
	private Integer clientId;
	/**
	 * Contact
	 **/
	private Contact contact = null;
	/**
	 * Students
	 **/
	private List<Student> students = new ArrayList<>();

	@Override
	@XmlTransient
	public String getBizModule() {
		return Client.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return Client.DOCUMENT_NAME;
	}

	public static Client newInstance() {
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
		return ((o instanceof Client) && 
					this.getBizId().equals(((Client) o).getBizId()));
	}

	/**
	 * {@link #clientId} accessor.
	 * @return	The value.
	 **/
	public Integer getClientId() {
		return clientId;
	}

	/**
	 * {@link #clientId} mutator.
	 * @param clientId	The new value.
	 **/
	@XmlElement
	public void setClientId(Integer clientId) {
		preset(clientIdPropertyName, clientId);
		this.clientId = clientId;
	}

	/**
	 * {@link #contact} accessor.
	 * @return	The value.
	 **/
	public Contact getContact() {
		return contact;
	}

	/**
	 * {@link #contact} mutator.
	 * @param contact	The new value.
	 **/
	@XmlElement
	public void setContact(Contact contact) {
		preset(contactPropertyName, contact);
		this.contact = contact;
	}

	/**
	 * {@link #students} accessor.
	 * @return	The value.
	 **/
	@XmlElement
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * {@link #students} accessor.
	 * @param bizId	The bizId of the element in the list.
	 * @return	The value of the element in the list.
	 **/
	public Student getStudentsElementById(String bizId) {
		return getElementById(students, bizId);
	}

	/**
	 * {@link #students} mutator.
	 * @param bizId	The bizId of the element in the list.
	 * @param element	The new value of the element in the list.
	 **/
	public void setStudentsElementById(String bizId, Student element) {
		 setElementById(students, element);
	}
}
