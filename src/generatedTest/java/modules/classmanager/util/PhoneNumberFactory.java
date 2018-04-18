package modules.classmanager.util;

import modules.classmanager.PhoneNumber.PhoneNumberExtension;
import modules.classmanager.domain.PhoneNumber;
import org.skyve.CORE;
import org.skyve.metadata.customer.Customer;
import org.skyve.metadata.model.document.Document;
import org.skyve.metadata.module.Module;
import org.skyve.util.Util;
import org.skyve.util.test.SkyveFactory;
import util.AbstractDomainFactory;

/**
 * Generated - local changes will be overwritten.
 * Create class src/test/java/modules/classmanager/util/PhoneNumberFactoryExtension.java
 * to extend this class and customise specific values for this document.
 */
@SkyveFactory
public class PhoneNumberFactory extends AbstractDomainFactory<PhoneNumberExtension > {

	@Override
	public PhoneNumberExtension getInstance() throws Exception {
		Customer customer = CORE.getUser().getCustomer();
		Module module = customer.getModule(PhoneNumber.MODULE_NAME);
		Document document = module.getDocument(customer, PhoneNumber.DOCUMENT_NAME);

		PhoneNumberExtension phoneNumber = Util.constructRandomInstance(CORE.getPersistence().getUser(), module, document, 1);

		return phoneNumber;
	}
}