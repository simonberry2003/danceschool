package modules.classmanager.util;

import modules.classmanager.Contact.ContactExtension;
import modules.classmanager.domain.Contact;
import org.skyve.CORE;
import org.skyve.metadata.customer.Customer;
import org.skyve.metadata.model.document.Document;
import org.skyve.metadata.module.Module;
import org.skyve.util.Util;
import org.skyve.util.test.SkyveFactory;
import util.AbstractDomainFactory;

/**
 * Generated - local changes will be overwritten.
 * Create class src/test/java/modules/classmanager/util/ContactFactoryExtension.java
 * to extend this class and customise specific values for this document.
 */
@SkyveFactory
public class ContactFactory extends AbstractDomainFactory<ContactExtension > {

	@Override
	public ContactExtension getInstance() throws Exception {
		Customer customer = CORE.getUser().getCustomer();
		Module module = customer.getModule(Contact.MODULE_NAME);
		Document document = module.getDocument(customer, Contact.DOCUMENT_NAME);

		ContactExtension contact = Util.constructRandomInstance(CORE.getPersistence().getUser(), module, document, 1);

		return contact;
	}
}