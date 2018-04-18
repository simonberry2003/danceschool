package modules.classmanager.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.skyve.CORE;
import org.skyve.domain.messages.DomainException;
import org.skyve.domain.types.Enumeration;
import org.skyve.impl.domain.AbstractPersistentBean;
import org.skyve.metadata.model.document.Bizlet.DomainValue;

/**
 * Phone Number
 * <br/>
 * Phone Number
 * 
 * @depend - - - PhoneNumberType
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class PhoneNumber extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "classmanager";
	/** @hidden */
	public static final String DOCUMENT_NAME = "PhoneNumber";

	/** @hidden */
	public static final String typePropertyName = "type";
	/** @hidden */
	public static final String countryCodePropertyName = "countryCode";
	/** @hidden */
	public static final String areaCodePropertyName = "areaCode";
	/** @hidden */
	public static final String numberPropertyName = "number";

	/**
	 * Type
	 **/
	@XmlEnum
	public static enum PhoneNumberType implements Enumeration {
		DDI("DDI", "DDI"),
		DEFAULT("DEFAULT", "DEFAULT"),
		FAX("FAX", "FAX"),
		MOBILE("MOBILE", "MOBILE");

		private String code;
		private String description;

		/** @hidden */
		private DomainValue domainValue;

		/** @hidden */
		private static List<DomainValue> domainValues;

		private PhoneNumberType(String code, String description) {
			this.code = code;
			this.description = description;
			this.domainValue = new DomainValue(code, description);
		}

		@Override
		public String toCode() {
			return code;
		}

		@Override
		public String toDescription() {
			return description;
		}

		@Override
		public DomainValue toDomainValue() {
			return domainValue;
		}

		public static PhoneNumberType fromCode(String code) {
			PhoneNumberType result = null;

			for (PhoneNumberType value : values()) {
				if (value.code.equals(code)) {
					result = value;
					break;
				}
			}

			return result;
		}

		public static PhoneNumberType fromDescription(String description) {
			PhoneNumberType result = null;

			for (PhoneNumberType value : values()) {
				if (value.description.equals(description)) {
					result = value;
					break;
				}
			}

			return result;
		}

		public static List<DomainValue> toDomainValues() {
			if (domainValues == null) {
				PhoneNumberType[] values = values();
				domainValues = new ArrayList<>(values.length);
				for (PhoneNumberType value : values) {
					domainValues.add(value.domainValue);
				}
			}

			return domainValues;
		}
	}

	/**
	 * Type
	 **/
	private PhoneNumberType type;
	/**
	 * Country Code
	 **/
	private String countryCode;
	/**
	 * Area Code
	 **/
	private String areaCode;
	/**
	 * Number
	 **/
	private String number;

	@Override
	@XmlTransient
	public String getBizModule() {
		return PhoneNumber.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return PhoneNumber.DOCUMENT_NAME;
	}

	public static PhoneNumber newInstance() {
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
		return ((o instanceof PhoneNumber) && 
					this.getBizId().equals(((PhoneNumber) o).getBizId()));
	}

	/**
	 * {@link #type} accessor.
	 * @return	The value.
	 **/
	public PhoneNumberType getType() {
		return type;
	}

	/**
	 * {@link #type} mutator.
	 * @param type	The new value.
	 **/
	@XmlElement
	public void setType(PhoneNumberType type) {
		preset(typePropertyName, type);
		this.type = type;
	}

	/**
	 * {@link #countryCode} accessor.
	 * @return	The value.
	 **/
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * {@link #countryCode} mutator.
	 * @param countryCode	The new value.
	 **/
	@XmlElement
	public void setCountryCode(String countryCode) {
		preset(countryCodePropertyName, countryCode);
		this.countryCode = countryCode;
	}

	/**
	 * {@link #areaCode} accessor.
	 * @return	The value.
	 **/
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * {@link #areaCode} mutator.
	 * @param areaCode	The new value.
	 **/
	@XmlElement
	public void setAreaCode(String areaCode) {
		preset(areaCodePropertyName, areaCode);
		this.areaCode = areaCode;
	}

	/**
	 * {@link #number} accessor.
	 * @return	The value.
	 **/
	public String getNumber() {
		return number;
	}

	/**
	 * {@link #number} mutator.
	 * @param number	The new value.
	 **/
	@XmlElement
	public void setNumber(String number) {
		preset(numberPropertyName, number);
		this.number = number;
	}
}
