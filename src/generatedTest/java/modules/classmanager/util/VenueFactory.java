package modules.classmanager.util;

import modules.classmanager.Venue.VenueExtension;
import modules.classmanager.domain.Venue;
import modules.classmanager.util.AddressFactory;
import org.skyve.CORE;
import org.skyve.metadata.customer.Customer;
import org.skyve.metadata.model.document.Document;
import org.skyve.metadata.module.Module;
import org.skyve.util.Util;
import org.skyve.util.test.SkyveFactory;
import util.AbstractDomainFactory;

/**
 * Generated - local changes will be overwritten.
 * Create class src/test/java/modules/classmanager/util/VenueFactoryExtension.java
 * to extend this class and customise specific values for this document.
 */
@SkyveFactory
public class VenueFactory extends AbstractDomainFactory<VenueExtension > {

	@Override
	public VenueExtension getInstance() throws Exception {
		Customer customer = CORE.getUser().getCustomer();
		Module module = customer.getModule(Venue.MODULE_NAME);
		Document document = module.getDocument(customer, Venue.DOCUMENT_NAME);

		VenueExtension venue = Util.constructRandomInstance(CORE.getPersistence().getUser(), module, document, 1);
		venue.setAddress(new AddressFactory().getInstance());

		return venue;
	}
}