package modules.classmanager.util;

import modules.classmanager.ClassDefinition.ClassDefinitionExtension;
import modules.classmanager.domain.ClassDefinition;
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
 * Create class src/test/java/modules/classmanager/util/ClassDefinitionFactoryExtension.java
 * to extend this class and customise specific values for this document.
 */
@SkyveFactory
public class ClassDefinitionFactory extends AbstractDomainFactory<ClassDefinitionExtension > {

	@Override
	public ClassDefinitionExtension getInstance() throws Exception {
		Customer customer = CORE.getUser().getCustomer();
		Module module = customer.getModule(ClassDefinition.MODULE_NAME);
		Document document = module.getDocument(customer, ClassDefinition.DOCUMENT_NAME);

		ClassDefinitionExtension classDefinition = Util.constructRandomInstance(CORE.getPersistence().getUser(), module, document, 1);
		classDefinition.setType(new ClassTypeFactory().getInstance());
		classDefinition.setVenue(new VenueFactory().getInstance());

		return classDefinition;
	}
}