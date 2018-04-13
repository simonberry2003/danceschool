package modules.classmanager.util;

import modules.classmanager.TimeTable.TimeTableExtension;
import modules.classmanager.domain.TimeTable;
import org.skyve.CORE;
import org.skyve.metadata.customer.Customer;
import org.skyve.metadata.model.document.Document;
import org.skyve.metadata.module.Module;
import org.skyve.util.Util;
import org.skyve.util.test.SkyveFactory;
import util.AbstractDomainFactory;

/**
 * Generated - local changes will be overwritten.
 * Create class src/test/java/modules/classmanager/util/TimeTableFactoryExtension.java
 * to extend this class and customise specific values for this document.
 */
@SkyveFactory
public class TimeTableFactory extends AbstractDomainFactory<TimeTableExtension > {

	@Override
	public TimeTableExtension getInstance() throws Exception {
		Customer customer = CORE.getUser().getCustomer();
		Module module = customer.getModule(TimeTable.MODULE_NAME);
		Document document = module.getDocument(customer, TimeTable.DOCUMENT_NAME);

		TimeTableExtension timeTable = Util.constructRandomInstance(CORE.getPersistence().getUser(), module, document, 1);

		return timeTable;
	}
}