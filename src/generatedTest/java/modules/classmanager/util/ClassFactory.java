package modules.classmanager.util;

import modules.classmanager.Class.ClassExtension;
import modules.classmanager.domain.Class;
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
 * Create class src/test/java/modules/classmanager/util/ClassFactoryExtension.java
 * to extend this class and customise specific values for this document.
 */
@SkyveFactory
public class ClassFactory extends AbstractDomainFactory<ClassExtension > {

	@Override
	public ClassExtension getInstance() throws Exception {
		Customer customer = CORE.getUser().getCustomer();
		Module module = customer.getModule(Class.MODULE_NAME);
		Document document = module.getDocument(customer, Class.DOCUMENT_NAME);

		ClassExtension _class = Util.constructRandomInstance(CORE.getPersistence().getUser(), module, document, 1);
		_class.setType(new ClassTypeFactory().getInstance());
		_class.setVenue(new VenueFactory().getInstance());

		return _class;
	}
}