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
 * Student
 * <br/>
 * Student Details
 * 
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class Student extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "classmanager";
	/** @hidden */
	public static final String DOCUMENT_NAME = "Student";

	/** @hidden */
	public static final String studentIdPropertyName = "studentId";
	/** @hidden */
	public static final String firstNamePropertyName = "firstName";
	/** @hidden */
	public static final String lastNamePropertyName = "lastName";
	/** @hidden */
	public static final String dateOfBirthPropertyName = "dateOfBirth";
	/** @hidden */
	public static final String medicalPropertyName = "medical";
	/** @hidden */
	public static final String imagePropertyName = "image";

	/**
	 * Id
	 **/
	private Integer studentId;
	/**
	 * First Name
	 **/
	private String firstName;
	/**
	 * Last Name
	 **/
	private String lastName;
	/**
	 * Date of Birth
	 **/
	private DateOnly dateOfBirth;
	/**
	 * Medical
	 **/
	private String medical;
	/**
	 * Image
	 **/
	private String image;

	@Override
	@XmlTransient
	public String getBizModule() {
		return Student.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return Student.DOCUMENT_NAME;
	}

	public static Student newInstance() {
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
		return ((o instanceof Student) && 
					this.getBizId().equals(((Student) o).getBizId()));
	}

	/**
	 * {@link #studentId} accessor.
	 * @return	The value.
	 **/
	public Integer getStudentId() {
		return studentId;
	}

	/**
	 * {@link #studentId} mutator.
	 * @param studentId	The new value.
	 **/
	@XmlElement
	public void setStudentId(Integer studentId) {
		preset(studentIdPropertyName, studentId);
		this.studentId = studentId;
	}

	/**
	 * {@link #firstName} accessor.
	 * @return	The value.
	 **/
	public String getFirstName() {
		return firstName;
	}

	/**
	 * {@link #firstName} mutator.
	 * @param firstName	The new value.
	 **/
	@XmlElement
	public void setFirstName(String firstName) {
		preset(firstNamePropertyName, firstName);
		this.firstName = firstName;
	}

	/**
	 * {@link #lastName} accessor.
	 * @return	The value.
	 **/
	public String getLastName() {
		return lastName;
	}

	/**
	 * {@link #lastName} mutator.
	 * @param lastName	The new value.
	 **/
	@XmlElement
	public void setLastName(String lastName) {
		preset(lastNamePropertyName, lastName);
		this.lastName = lastName;
	}

	/**
	 * {@link #dateOfBirth} accessor.
	 * @return	The value.
	 **/
	public DateOnly getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * {@link #dateOfBirth} mutator.
	 * @param dateOfBirth	The new value.
	 **/
	@XmlSchemaType(name = "date")
	@XmlJavaTypeAdapter(DateOnlyMapper.class)
	@XmlElement
	public void setDateOfBirth(DateOnly dateOfBirth) {
		preset(dateOfBirthPropertyName, dateOfBirth);
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * {@link #medical} accessor.
	 * @return	The value.
	 **/
	public String getMedical() {
		return medical;
	}

	/**
	 * {@link #medical} mutator.
	 * @param medical	The new value.
	 **/
	@XmlElement
	public void setMedical(String medical) {
		preset(medicalPropertyName, medical);
		this.medical = medical;
	}

	/**
	 * {@link #image} accessor.
	 * @return	The value.
	 **/
	public String getImage() {
		return image;
	}

	/**
	 * {@link #image} mutator.
	 * @param image	The new value.
	 **/
	@XmlElement
	public void setImage(String image) {
		preset(imagePropertyName, image);
		this.image = image;
	}
}
