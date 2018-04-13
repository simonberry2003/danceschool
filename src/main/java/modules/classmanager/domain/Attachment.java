package modules.classmanager.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.skyve.CORE;
import org.skyve.domain.messages.DomainException;
import org.skyve.impl.domain.AbstractPersistentBean;

/**
 * Attachment
 * <br/>
 * Attachment
 * 
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class Attachment extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "classmanager";
	/** @hidden */
	public static final String DOCUMENT_NAME = "Attachment";

	/** @hidden */
	public static final String namePropertyName = "name";
	/** @hidden */
	public static final String contentPropertyName = "content";

	/**
	 * Name
	 **/
	private String name;
	/**
	 * Content
	 **/
	private String content;

	@Override
	@XmlTransient
	public String getBizModule() {
		return Attachment.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return Attachment.DOCUMENT_NAME;
	}

	public static Attachment newInstance() {
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
		return ((o instanceof Attachment) && 
					this.getBizId().equals(((Attachment) o).getBizId()));
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
	 * {@link #content} accessor.
	 * @return	The value.
	 **/
	public String getContent() {
		return content;
	}

	/**
	 * {@link #content} mutator.
	 * @param content	The new value.
	 **/
	@XmlElement
	public void setContent(String content) {
		preset(contentPropertyName, content);
		this.content = content;
	}
}
