package modules.classmanager.util;

import modules.classmanager.Student.StudentExtension;
import modules.classmanager.domain.Student;
import org.skyve.CORE;
import org.skyve.metadata.customer.Customer;
import org.skyve.metadata.model.document.Document;
import org.skyve.metadata.module.Module;
import org.skyve.util.Util;
import org.skyve.util.test.SkyveFactory;
import util.AbstractDomainFactory;

/**
 * Generated - local changes will be overwritten.
 * Create class src/test/java/modules/classmanager/util/StudentFactoryExtension.java
 * to extend this class and customise specific values for this document.
 */
@SkyveFactory
public class StudentFactory extends AbstractDomainFactory<StudentExtension > {

	@Override
	public StudentExtension getInstance() throws Exception {
		Customer customer = CORE.getUser().getCustomer();
		Module module = customer.getModule(Student.MODULE_NAME);
		Document document = module.getDocument(customer, Student.DOCUMENT_NAME);

		StudentExtension student = Util.constructRandomInstance(CORE.getPersistence().getUser(), module, document, 1);

		return student;
	}
}