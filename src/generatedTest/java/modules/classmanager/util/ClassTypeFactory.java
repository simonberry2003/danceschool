package modules.classmanager.util;

import modules.classmanager.ClassType.ClassTypeExtension;
import modules.classmanager.domain.ClassType;
import org.skyve.CORE;
import org.skyve.metadata.customer.Customer;
import org.skyve.metadata.model.document.Document;
import org.skyve.metadata.module.Module;
import org.skyve.util.Util;
import org.skyve.util.test.SkyveFactory;
import util.AbstractDomainFactory;

/**
 * Generated - local changes will be overwritten.
 * Create class src/test/java/modules/classmanager/util/ClassTypeFactoryExtension.java
 * to extend this class and customise specific values for this document.
 */
@SkyveFactory
public class ClassTypeFactory extends AbstractDomainFactory<ClassTypeExtension > {

	@Override
	public ClassTypeExtension getInstance() throws Exception {
		Customer customer = CORE.getUser().getCustomer();
		Module module = customer.getModule(ClassType.MODULE_NAME);
		Document document = module.getDocument(customer, ClassType.DOCUMENT_NAME);

		ClassTypeExtension classType = Util.constructRandomInstance(CORE.getPersistence().getUser(), module, document, 1);

		return classType;
	}
}