package modules.classmanager.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import modules.classmanager.ClassBase.ClassBaseExtension;
import org.skyve.CORE;
import org.skyve.domain.messages.DomainException;
import org.skyve.domain.types.DateOnly;
import org.skyve.impl.domain.types.jaxb.DateOnlyMapper;

/**
 * Class
 * <br/>
 * Class details used for class definition and actual classes
 * 
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class Class extends ClassBaseExtension {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "classmanager";
	/** @hidden */
	public static final String DOCUMENT_NAME = "Class";

	/** @hidden */
	public static final String datePropertyName = "date";

	/**
	 * Date
	 **/
	private DateOnly date;

	@Override
	@XmlTransient
	public String getBizModule() {
		return Class.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return Class.DOCUMENT_NAME;
	}

	public static Class newInstance() {
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
return super.getBizKey();
	}

	@Override
	public boolean equals(Object o) {
		return ((o instanceof Class) && 
					this.getBizId().equals(((Class) o).getBizId()));
	}

	/**
	 * {@link #date} accessor.
	 * @return	The value.
	 **/
	public DateOnly getDate() {
		return date;
	}

	/**
	 * {@link #date} mutator.
	 * @param date	The new value.
	 **/
	@XmlSchemaType(name = "date")
	@XmlJavaTypeAdapter(DateOnlyMapper.class)
	@XmlElement
	public void setDate(DateOnly date) {
		preset(datePropertyName, date);
		this.date = date;
	}
}
