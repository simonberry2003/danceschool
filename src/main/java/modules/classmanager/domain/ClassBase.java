package modules.classmanager.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.skyve.CORE;
import org.skyve.domain.messages.DomainException;
import org.skyve.domain.types.Enumeration;
import org.skyve.domain.types.TimeOnly;
import org.skyve.impl.domain.AbstractPersistentBean;
import org.skyve.impl.domain.types.jaxb.TimeOnlyMapper;
import org.skyve.metadata.model.document.Bizlet.DomainValue;

/**
 * Class Base
 * <br/>
 * Defines a attributes shared between class definition and class.
 * 
 * @depend - - - Day
 * @navhas n venue 1 Venue
 * @navhas n type 1 ClassType
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class ClassBase extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "classmanager";
	/** @hidden */
	public static final String DOCUMENT_NAME = "ClassBase";

	/** @hidden */
	public static final String typePropertyName = "type";
	/** @hidden */
	public static final String venuePropertyName = "venue";
	/** @hidden */
	public static final String dayPropertyName = "day";
	/** @hidden */
	public static final String startTimePropertyName = "startTime";
	/** @hidden */
	public static final String endTimePropertyName = "endTime";

	/**
	 * Day
	 **/
	@XmlEnum
	public static enum Day implements Enumeration {
		sunday("Sunday", "Sunday"),
		monday("Monday", "Monday"),
		tuesday("Tuesday", "Tuesday"),
		wednesday("Wednesday", "Wednesday"),
		thursday("Thursday", "Thursday"),
		friday("Friday", "Friday"),
		saturday("Saturday", "Saturday");

		private String code;
		private String description;

		/** @hidden */
		private DomainValue domainValue;

		/** @hidden */
		private static List<DomainValue> domainValues;

		private Day(String code, String description) {
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

		public static Day fromCode(String code) {
			Day result = null;

			for (Day value : values()) {
				if (value.code.equals(code)) {
					result = value;
					break;
				}
			}

			return result;
		}

		public static Day fromDescription(String description) {
			Day result = null;

			for (Day value : values()) {
				if (value.description.equals(description)) {
					result = value;
					break;
				}
			}

			return result;
		}

		public static List<DomainValue> toDomainValues() {
			if (domainValues == null) {
				Day[] values = values();
				domainValues = new ArrayList<>(values.length);
				for (Day value : values) {
					domainValues.add(value.domainValue);
				}
			}

			return domainValues;
		}
	}

	/**
	 * Type
	 **/
	private ClassType type = null;
	/**
	 * Venue
	 **/
	private Venue venue = null;
	/**
	 * Day
	 **/
	private Day day;
	/**
	 * Start Time
	 **/
	private TimeOnly startTime;
	/**
	 * End Time
	 **/
	private TimeOnly endTime;

	@Override
	@XmlTransient
	public String getBizModule() {
		return ClassBase.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return ClassBase.DOCUMENT_NAME;
	}

	public static ClassBase newInstance() {
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
		return ((o instanceof ClassBase) && 
					this.getBizId().equals(((ClassBase) o).getBizId()));
	}

	/**
	 * {@link #type} accessor.
	 * @return	The value.
	 **/
	public ClassType getType() {
		return type;
	}

	/**
	 * {@link #type} mutator.
	 * @param type	The new value.
	 **/
	@XmlElement
	public void setType(ClassType type) {
		preset(typePropertyName, type);
		this.type = type;
	}

	/**
	 * {@link #venue} accessor.
	 * @return	The value.
	 **/
	public Venue getVenue() {
		return venue;
	}

	/**
	 * {@link #venue} mutator.
	 * @param venue	The new value.
	 **/
	@XmlElement
	public void setVenue(Venue venue) {
		preset(venuePropertyName, venue);
		this.venue = venue;
	}

	/**
	 * {@link #day} accessor.
	 * @return	The value.
	 **/
	public Day getDay() {
		return day;
	}

	/**
	 * {@link #day} mutator.
	 * @param day	The new value.
	 **/
	@XmlElement
	public void setDay(Day day) {
		preset(dayPropertyName, day);
		this.day = day;
	}

	/**
	 * {@link #startTime} accessor.
	 * @return	The value.
	 **/
	public TimeOnly getStartTime() {
		return startTime;
	}

	/**
	 * {@link #startTime} mutator.
	 * @param startTime	The new value.
	 **/
	@XmlSchemaType(name = "time")
	@XmlJavaTypeAdapter(TimeOnlyMapper.class)
	@XmlElement
	public void setStartTime(TimeOnly startTime) {
		preset(startTimePropertyName, startTime);
		this.startTime = startTime;
	}

	/**
	 * {@link #endTime} accessor.
	 * @return	The value.
	 **/
	public TimeOnly getEndTime() {
		return endTime;
	}

	/**
	 * {@link #endTime} mutator.
	 * @param endTime	The new value.
	 **/
	@XmlSchemaType(name = "time")
	@XmlJavaTypeAdapter(TimeOnlyMapper.class)
	@XmlElement
	public void setEndTime(TimeOnly endTime) {
		preset(endTimePropertyName, endTime);
		this.endTime = endTime;
	}
}
