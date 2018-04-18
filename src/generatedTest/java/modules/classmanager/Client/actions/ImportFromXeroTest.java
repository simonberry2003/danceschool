package modules.classmanager.Client.actions;

import modules.classmanager.Client.ClientExtension;
import modules.classmanager.util.ClientFactory;
import util.AbstractActionTest;

/**
 * Generated - local changes will be overwritten.
 * Extend {@link AbstractActionTest} to create your own tests for this action.
 */
public class ImportFromXeroTest extends AbstractActionTest<ClientExtension, ImportFromXero> {

	private ClientFactory factory;

	@Override
	protected ImportFromXero getAction() {
		return new ImportFromXero();
	}

	@Override
	protected ClientExtension getBean() throws Exception {
		if (factory == null) {
			factory = new ClientFactory();
		}

		return factory.getInstance();
	}
}