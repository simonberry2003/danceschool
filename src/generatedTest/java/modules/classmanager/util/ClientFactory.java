package modules.classmanager.util;

import modules.classmanager.Client.ClientExtension;
import modules.classmanager.domain.Client;
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
 * Create class src/test/java/modules/classmanager/util/ClientFactoryExtension.java
 * to extend this class and customise specific values for this document.
 */
@SkyveFactory
public class ClientFactory extends AbstractDomainFactory<ClientExtension > {

	@Override
	public ClientExtension getInstance() throws Exception {
		Customer customer = CORE.getUser().getCustomer();
		Module module = customer.getModule(Client.MODULE_NAME);
		Document document = module.getDocument(customer, Client.DOCUMENT_NAME);

		ClientExtension client = Util.constructRandomInstance(CORE.getPersistence().getUser(), module, document, 1);
		client.setContact(new ContactFactory().getInstance());

		return client;
	}
}