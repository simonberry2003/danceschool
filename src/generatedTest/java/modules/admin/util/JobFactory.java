package modules.admin.util;

import modules.admin.domain.Job;
import org.skyve.CORE;
import org.skyve.metadata.customer.Customer;
import org.skyve.metadata.model.document.Document;
import org.skyve.metadata.module.Module;
import org.skyve.util.Util;
import org.skyve.util.test.SkyveFactory;
import util.AbstractDomainFactory;

/**
 * Generated - local changes will be overwritten.
 * Create class src/test/java/modules/admin/util/JobFactoryExtension.java
 * to extend this class and customise specific values for this document.
 */
@SkyveFactory
public class JobFactory extends AbstractDomainFactory<Job > {

	@Override
	public Job getInstance() throws Exception {
		Customer customer = CORE.getUser().getCustomer();
		Module module = customer.getModule(Job.MODULE_NAME);
		Document document = module.getDocument(customer, Job.DOCUMENT_NAME);

		Job job = Util.constructRandomInstance(CORE.getPersistence().getUser(), module, document, 1);

		return job;
	}
}