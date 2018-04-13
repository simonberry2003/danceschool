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
 * Time Table
 * <br/>
 * Time Table
 * 
 * @navcomposed n period 0..1 Period
 * @navcomposed n classes 0..n ClassDefinition
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class TimeTable extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "classmanager";
	/** @hidden */
	public static final String DOCUMENT_NAME = "TimeTable";

	/** @hidden */
	public static final String namePropertyName = "name";
	/** @hidden */
	public static final String classesPropertyName = "classes";
	/** @hidden */
	public static final String periodPropertyName = "period";

	/**
	 * Name
	 **/
	private String name;
	/**
	 * Classes
	 **/
	private List<ClassDefinition> classes = new ArrayList<>();
	/**
	 * Period
	 **/
	private Period period = null;

	@Override
	@XmlTransient
	public String getBizModule() {
		return TimeTable.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return TimeTable.DOCUMENT_NAME;
	}

	public static TimeTable newInstance() {
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
		return ((o instanceof TimeTable) && 
					this.getBizId().equals(((TimeTable) o).getBizId()));
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
	 * {@link #classes} accessor.
	 * @return	The value.
	 **/
	@XmlElement
	public List<ClassDefinition> getClasses() {
		return classes;
	}

	/**
	 * {@link #classes} accessor.
	 * @param bizId	The bizId of the element in the list.
	 * @return	The value of the element in the list.
	 **/
	public ClassDefinition getClassesElementById(String bizId) {
		return getElementById(classes, bizId);
	}

	/**
	 * {@link #classes} mutator.
	 * @param bizId	The bizId of the element in the list.
	 * @param element	The new value of the element in the list.
	 **/
	public void setClassesElementById(String bizId, ClassDefinition element) {
		 setElementById(classes, element);
	}

	/**
	 * {@link #period} accessor.
	 * @return	The value.
	 **/
	public Period getPeriod() {
		return period;
	}

	/**
	 * {@link #period} mutator.
	 * @param period	The new value.
	 **/
	@XmlElement
	public void setPeriod(Period period) {
		this.period = period;
	}
}
