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
 * Teacher
 * <br/>
 * Teacher
 * 
 * @navcomposed n documents 0..n Attachment
 * @navcomposed n contact 1 Contact
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class Teacher extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "classmanager";
	/** @hidden */
	public static final String DOCUMENT_NAME = "Teacher";

	/** @hidden */
	public static final String contactPropertyName = "contact";
	/** @hidden */
	public static final String documentsPropertyName = "documents";

	/**
	 * Contact
	 **/
	private Contact contact = null;
	/**
	 * Documents
	 **/
	private List<Attachment> documents = new ArrayList<>();

	@Override
	@XmlTransient
	public String getBizModule() {
		return Teacher.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return Teacher.DOCUMENT_NAME;
	}

	public static Teacher newInstance() {
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
		return ((o instanceof Teacher) && 
					this.getBizId().equals(((Teacher) o).getBizId()));
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
	 * {@link #documents} accessor.
	 * @return	The value.
	 **/
	@XmlElement
	public List<Attachment> getDocuments() {
		return documents;
	}

	/**
	 * {@link #documents} accessor.
	 * @param bizId	The bizId of the element in the list.
	 * @return	The value of the element in the list.
	 **/
	public Attachment getDocumentsElementById(String bizId) {
		return getElementById(documents, bizId);
	}

	/**
	 * {@link #documents} mutator.
	 * @param bizId	The bizId of the element in the list.
	 * @param element	The new value of the element in the list.
	 **/
	public void setDocumentsElementById(String bizId, Attachment element) {
		 setElementById(documents, element);
	}
}
