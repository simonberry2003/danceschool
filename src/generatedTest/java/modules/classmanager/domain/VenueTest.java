package modules.classmanager.domain;

import modules.classmanager.util.VenueFactory;
import util.AbstractDomainTest;

/**
 * Generated - local changes will be overwritten.
 * Extend {@link AbstractDomainTest} to create your own tests for this document.
 */
public class VenueTest extends AbstractDomainTest<Venue> {

	private VenueFactory factory;

	@Override
	protected Venue getBean() throws Exception {
		if (factory == null) {
			factory = new VenueFactory();
		}

		return factory.getInstance();
	}
}