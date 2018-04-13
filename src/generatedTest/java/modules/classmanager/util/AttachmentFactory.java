package modules.classmanager.util;

import modules.classmanager.Attachment.AttachmentExtension;
import modules.classmanager.domain.Attachment;
import org.skyve.CORE;
import org.skyve.metadata.customer.Customer;
import org.skyve.metadata.model.document.Document;
import org.skyve.metadata.module.Module;
import org.skyve.util.Util;
import org.skyve.util.test.SkyveFactory;
import util.AbstractDomainFactory;

/**
 * Generated - local changes will be overwritten.
 * Create class src/test/java/modules/classmanager/util/AttachmentFactoryExtension.java
 * to extend this class and customise specific values for this document.
 */
@SkyveFactory
public class AttachmentFactory extends AbstractDomainFactory<AttachmentExtension > {

	@Override
	public AttachmentExtension getInstance() throws Exception {
		Customer customer = CORE.getUser().getCustomer();
		Module module = customer.getModule(Attachment.MODULE_NAME);
		Document document = module.getDocument(customer, Attachment.DOCUMENT_NAME);

		AttachmentExtension attachment = Util.constructRandomInstance(CORE.getPersistence().getUser(), module, document, 1);

		return attachment;
	}
}