package modules.admin.util;

import modules.admin.domain.Communication;
import org.skyve.CORE;
import org.skyve.metadata.customer.Customer;
import org.skyve.metadata.model.document.Document;
import org.skyve.metadata.module.Module;
import org.skyve.util.Util;
import org.skyve.util.test.SkyveFactory;
import util.AbstractDomainFactory;

/**
 * Generated - local changes will be overwritten.
 * Create class src/test/java/modules/admin/util/CommunicationFactoryExtension.java
 * to extend this class and customise specific values for this document.
 */
@SkyveFactory
public class CommunicationFactory extends AbstractDomainFactory<Communication > {

	@Override
	public Communication getInstance() throws Exception {
		Customer customer = CORE.getUser().getCustomer();
		Module module = customer.getModule(Communication.MODULE_NAME);
		Document document = module.getDocument(customer, Communication.DOCUMENT_NAME);

		Communication communication = Util.constructRandomInstance(CORE.getPersistence().getUser(), module, document, 1);

		return communication;
	}
}