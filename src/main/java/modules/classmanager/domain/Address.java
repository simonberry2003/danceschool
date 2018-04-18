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
 * Address
 * <br/>
 * Address
 * 
 * @depend - - - AddressType
 * @depend - - - State
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class Address extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "classmanager";
	/** @hidden */
	public static final String DOCUMENT_NAME = "Address";

	/** @hidden */
	public static final String typePropertyName = "type";
	/** @hidden */
	public static final String streetAddressPropertyName = "streetAddress";
	/** @hidden */
	public static final String suburbPropertyName = "suburb";
	/** @hidden */
	public static final String statePropertyName = "state";
	/** @hidden */
	public static final String postcodePropertyName = "postcode";

	/**
	 * Type
	 **/
	@XmlEnum
	public static enum AddressType implements Enumeration {
		STREET("STREET", "STREET"),
		POBOX("POBOX", "POBOX");

		private String code;
		private String description;

		/** @hidden */
		private DomainValue domainValue;

		/** @hidden */
		private static List<DomainValue> domainValues;

		private AddressType(String code, String description) {
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

		public static AddressType fromCode(String code) {
			AddressType result = null;

			for (AddressType value : values()) {
				if (value.code.equals(code)) {
					result = value;
					break;
				}
			}

			return result;
		}

		public static AddressType fromDescription(String description) {
			AddressType result = null;

			for (AddressType value : values()) {
				if (value.description.equals(description)) {
					result = value;
					break;
				}
			}

			return result;
		}

		public static List<DomainValue> toDomainValues() {
			if (domainValues == null) {
				AddressType[] values = values();
				domainValues = new ArrayList<>(values.length);
				for (AddressType value : values) {
					domainValues.add(value.domainValue);
				}
			}

			return domainValues;
		}
	}

	/**
	 * State
	 **/
	@XmlEnum
	public static enum State implements Enumeration {
		ACT("ACT", "ACT"),
		NSW("NSW", "NSW"),
		NT("NT", "NT"),
		QLD("QLD", "QLD"),
		SA("SA", "SA"),
		TAS("TAS", "TAS"),
		VIC("VIC", "VIC"),
		WA("WA", "WA");

		private String code;
		private String description;

		/** @hidden */
		private DomainValue domainValue;

		/** @hidden */
		private static List<DomainValue> domainValues;

		private State(String code, String description) {
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

		public static State fromCode(String code) {
			State result = null;

			for (State value : values()) {
				if (value.code.equals(code)) {
					result = value;
					break;
				}
			}

			return result;
		}

		public static State fromDescription(String description) {
			State result = null;

			for (State value : values()) {
				if (value.description.equals(description)) {
					result = value;
					break;
				}
			}

			return result;
		}

		public static List<DomainValue> toDomainValues() {
			if (domainValues == null) {
				State[] values = values();
				domainValues = new ArrayList<>(values.length);
				for (State value : values) {
					domainValues.add(value.domainValue);
				}
			}

			return domainValues;
		}
	}

	/**
	 * Type
	 **/
	private AddressType type;
	/**
	 * Street Address
	 **/
	private String streetAddress;
	/**
	 * Suburb
	 **/
	private String suburb;
	/**
	 * State
	 **/
	private State state;
	/**
	 * Postcode
	 **/
	private String postcode;

	@Override
	@XmlTransient
	public String getBizModule() {
		return Address.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return Address.DOCUMENT_NAME;
	}

	public static Address newInstance() {
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
		return ((o instanceof Address) && 
					this.getBizId().equals(((Address) o).getBizId()));
	}

	/**
	 * {@link #type} accessor.
	 * @return	The value.
	 **/
	public AddressType getType() {
		return type;
	}

	/**
	 * {@link #type} mutator.
	 * @param type	The new value.
	 **/
	@XmlElement
	public void setType(AddressType type) {
		preset(typePropertyName, type);
		this.type = type;
	}

	/**
	 * {@link #streetAddress} accessor.
	 * @return	The value.
	 **/
	public String getStreetAddress() {
		return streetAddress;
	}

	/**
	 * {@link #streetAddress} mutator.
	 * @param streetAddress	The new value.
	 **/
	@XmlElement
	public void setStreetAddress(String streetAddress) {
		preset(streetAddressPropertyName, streetAddress);
		this.streetAddress = streetAddress;
	}

	/**
	 * {@link #suburb} accessor.
	 * @return	The value.
	 **/
	public String getSuburb() {
		return suburb;
	}

	/**
	 * {@link #suburb} mutator.
	 * @param suburb	The new value.
	 **/
	@XmlElement
	public void setSuburb(String suburb) {
		preset(suburbPropertyName, suburb);
		this.suburb = suburb;
	}

	/**
	 * {@link #state} accessor.
	 * @return	The value.
	 **/
	public State getState() {
		return state;
	}

	/**
	 * {@link #state} mutator.
	 * @param state	The new value.
	 **/
	@XmlElement
	public void setState(State state) {
		preset(statePropertyName, state);
		this.state = state;
	}

	/**
	 * {@link #postcode} accessor.
	 * @return	The value.
	 **/
	public String getPostcode() {
		return postcode;
	}

	/**
	 * {@link #postcode} mutator.
	 * @param postcode	The new value.
	 **/
	@XmlElement
	public void setPostcode(String postcode) {
		preset(postcodePropertyName, postcode);
		this.postcode = postcode;
	}
}
