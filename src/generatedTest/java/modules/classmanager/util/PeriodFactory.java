package modules.classmanager.util;

import modules.classmanager.Period.PeriodExtension;
import modules.classmanager.domain.Period;
import org.skyve.CORE;
import org.skyve.metadata.customer.Customer;
import org.skyve.metadata.model.document.Document;
import org.skyve.metadata.module.Module;
import org.skyve.util.Util;
import org.skyve.util.test.SkyveFactory;
import util.AbstractDomainFactory;

/**
 * Generated - local changes will be overwritten.
 * Create class src/test/java/modules/classmanager/util/PeriodFactoryExtension.java
 * to extend this class and customise specific values for this document.
 */
@SkyveFactory
public class PeriodFactory extends AbstractDomainFactory<PeriodExtension > {

	@Override
	public PeriodExtension getInstance() throws Exception {
		Customer customer = CORE.getUser().getCustomer();
		Module module = customer.getModule(Period.MODULE_NAME);
		Document document = module.getDocument(customer, Period.DOCUMENT_NAME);

		PeriodExtension period = Util.constructRandomInstance(CORE.getPersistence().getUser(), module, document, 1);

		return period;
	}
}