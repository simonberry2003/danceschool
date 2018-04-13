package modules.classmanager.util;

import modules.classmanager.ClassBase.ClassBaseExtension;
import modules.classmanager.domain.ClassBase;
import modules.classmanager.util.ClassTypeFactory;
import modules.classmanager.util.VenueFactory;
import org.skyve.CORE;
import org.skyve.metadata.customer.Customer;
import org.skyve.metadata.model.document.Document;
import org.skyve.metadata.module.Module;
import org.skyve.util.Util;
import org.skyve.util.test.SkyveFactory;
import util.AbstractDomainFactory;

/**
 * Generated - local changes will be overwritten.
 * Create class src/test/java/modules/classmanager/util/ClassBaseFactoryExtension.java
 * to extend this class and customise specific values for this document.
 */
@SkyveFactory
public class ClassBaseFactory extends AbstractDomainFactory<ClassBaseExtension > {

	@Override
	public ClassBaseExtension getInstance() throws Exception {
		Customer customer = CORE.getUser().getCustomer();
		Module module = customer.getModule(ClassBase.MODULE_NAME);
		Document document = module.getDocument(customer, ClassBase.DOCUMENT_NAME);

		ClassBaseExtension classBase = Util.constructRandomInstance(CORE.getPersistence().getUser(), module, document, 1);
		classBase.setType(new ClassTypeFactory().getInstance());
		classBase.setVenue(new VenueFactory().getInstance());

		return classBase;
	}
}