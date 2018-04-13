package modules.classmanager.domain;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import modules.classmanager.ClassBase.ClassBaseExtension;
import org.skyve.CORE;
import org.skyve.domain.messages.DomainException;

/**
 * Class Definition
 * <br/>
 * Defines a class as part of a timetable. Used to generate classes.
 * 
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class ClassDefinition extends ClassBaseExtension {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "classmanager";
	/** @hidden */
	public static final String DOCUMENT_NAME = "ClassDefinition";



	@Override
	@XmlTransient
	public String getBizModule() {
		return ClassDefinition.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return ClassDefinition.DOCUMENT_NAME;
	}

	public static ClassDefinition newInstance() {
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
		return ((o instanceof ClassDefinition) && 
					this.getBizId().equals(((ClassDefinition) o).getBizId()));
	}
}
