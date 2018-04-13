package modules.classmanager.domain;

import modules.classmanager.util.ClientFactory;
import util.AbstractDomainTest;

/**
 * Generated - local changes will be overwritten.
 * Extend {@link AbstractDomainTest} to create your own tests for this document.
 */
public class ClientTest extends AbstractDomainTest<Client> {

	private ClientFactory factory;

	@Override
	protected Client getBean() throws Exception {
		if (factory == null) {
			factory = new ClientFactory();
		}

		return factory.getInstance();
	}
}