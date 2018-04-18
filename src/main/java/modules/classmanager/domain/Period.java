package modules.classmanager.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.skyve.CORE;
import org.skyve.domain.messages.DomainException;
import org.skyve.domain.types.DateOnly;
import org.skyve.impl.domain.AbstractPersistentBean;
import org.skyve.impl.domain.types.jaxb.DateOnlyMapper;

/**
 * Period
 * <br/>
 * Period
 * 
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class Period extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "classmanager";
	/** @hidden */
	public static final String DOCUMENT_NAME = "Period";

	/** @hidden */
	public static final String namePropertyName = "name";
	/** @hidden */
	public static final String startPropertyName = "start";
	/** @hidden */
	public static final String endPropertyName = "end";
	/** @hidden */
	public static final String activePropertyName = "active";

	/**
	 * Name
	 **/
	private String name;
	/**
	 * Start
	 **/
	private DateOnly start;
	/**
	 * End
	 **/
	private DateOnly end;
	/**
	 * Active
	 **/
	private Boolean active;

	@Override
	@XmlTransient
	public String getBizModule() {
		return Period.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return Period.DOCUMENT_NAME;
	}

	public static Period newInstance() {
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
		return ((o instanceof Period) && 
					this.getBizId().equals(((Period) o).getBizId()));
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
	 * {@link #start} accessor.
	 * @return	The value.
	 **/
	public DateOnly getStart() {
		return start;
	}

	/**
	 * {@link #start} mutator.
	 * @param start	The new value.
	 **/
	@XmlSchemaType(name = "date")
	@XmlJavaTypeAdapter(DateOnlyMapper.class)
	@XmlElement
	public void setStart(DateOnly start) {
		preset(startPropertyName, start);
		this.start = start;
	}

	/**
	 * {@link #end} accessor.
	 * @return	The value.
	 **/
	public DateOnly getEnd() {
		return end;
	}

	/**
	 * {@link #end} mutator.
	 * @param end	The new value.
	 **/
	@XmlSchemaType(name = "date")
	@XmlJavaTypeAdapter(DateOnlyMapper.class)
	@XmlElement
	public void setEnd(DateOnly end) {
		preset(endPropertyName, end);
		this.end = end;
	}

	/**
	 * {@link #active} accessor.
	 * @return	The value.
	 **/
	public Boolean getActive() {
		return active;
	}

	/**
	 * {@link #active} mutator.
	 * @param active	The new value.
	 **/
	@XmlElement
	public void setActive(Boolean active) {
		preset(activePropertyName, active);
		this.active = active;
	}
}
