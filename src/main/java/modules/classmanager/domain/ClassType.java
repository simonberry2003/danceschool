package modules.classmanager.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.skyve.CORE;
import org.skyve.domain.messages.DomainException;
import org.skyve.domain.types.Decimal2;
import org.skyve.impl.domain.AbstractPersistentBean;
import org.skyve.impl.domain.types.jaxb.Decimal2Mapper;

/**
 * Class
 * <br/>
 * Class Details
 * 
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class ClassType extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "classmanager";
	/** @hidden */
	public static final String DOCUMENT_NAME = "ClassType";

	/** @hidden */
	public static final String namePropertyName = "name";
	/** @hidden */
	public static final String costPropertyName = "cost";
	/** @hidden */
	public static final String sizePropertyName = "size";

	/**
	 * Name
	 **/
	private String name;
	/**
	 * Cost
	 **/
	private Decimal2 cost;
	/**
	 * Size
	 **/
	private Integer size;

	@Override
	@XmlTransient
	public String getBizModule() {
		return ClassType.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return ClassType.DOCUMENT_NAME;
	}

	public static ClassType newInstance() {
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
		return ((o instanceof ClassType) && 
					this.getBizId().equals(((ClassType) o).getBizId()));
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
	 * {@link #cost} accessor.
	 * @return	The value.
	 **/
	public Decimal2 getCost() {
		return cost;
	}

	/**
	 * {@link #cost} mutator.
	 * @param cost	The new value.
	 **/
	@XmlJavaTypeAdapter(Decimal2Mapper.class)
	@XmlElement
	public void setCost(Decimal2 cost) {
		preset(costPropertyName, cost);
		this.cost = cost;
	}

	/**
	 * {@link #size} accessor.
	 * @return	The value.
	 **/
	public Integer getSize() {
		return size;
	}

	/**
	 * {@link #size} mutator.
	 * @param size	The new value.
	 **/
	@XmlElement
	public void setSize(Integer size) {
		preset(sizePropertyName, size);
		this.size = size;
	}
}
