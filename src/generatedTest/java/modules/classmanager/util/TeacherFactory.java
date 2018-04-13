package modules.classmanager.util;

import modules.classmanager.Teacher.TeacherExtension;
import modules.classmanager.domain.Teacher;
import modules.classmanager.util.ContactFactory;
import org.skyve.CORE;
import org.skyve.metadata.customer.Customer;
import org.skyve.metadata.model.document.Document;
import org.skyve.metadata.module.Module;
import org.skyve.util.Util;
import org.skyve.util.test.SkyveFactory;
import util.AbstractDomainFactory;

/**
 * Generated - local changes will be overwritten.
 * Create class src/test/java/modules/classmanager/util/TeacherFactoryExtension.java
 * to extend this class and customise specific values for this document.
 */
@SkyveFactory
public class TeacherFactory extends AbstractDomainFactory<TeacherExtension > {

	@Override
	public TeacherExtension getInstance() throws Exception {
		Customer customer = CORE.getUser().getCustomer();
		Module module = customer.getModule(Teacher.MODULE_NAME);
		Document document = module.getDocument(customer, Teacher.DOCUMENT_NAME);

		TeacherExtension teacher = Util.constructRandomInstance(CORE.getPersistence().getUser(), module, document, 1);
		teacher.setContact(new ContactFactory().getInstance());

		return teacher;
	}
}