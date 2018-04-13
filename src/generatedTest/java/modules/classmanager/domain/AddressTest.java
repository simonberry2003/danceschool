package modules.classmanager.domain;

import modules.classmanager.util.AddressFactory;
import util.AbstractDomainTest;

/**
 * Generated - local changes will be overwritten.
 * Extend {@link AbstractDomainTest} to create your own tests for this document.
 */
public class AddressTest extends AbstractDomainTest<Address> {

	private AddressFactory factory;

	@Override
	protected Address getBean() throws Exception {
		if (factory == null) {
			factory = new AddressFactory();
		}

		return factory.getInstance();
	}
}