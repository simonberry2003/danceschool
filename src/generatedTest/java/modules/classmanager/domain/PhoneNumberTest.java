package modules.classmanager.domain;

import modules.classmanager.util.PhoneNumberFactory;
import util.AbstractDomainTest;

/**
 * Generated - local changes will be overwritten.
 * Extend {@link AbstractDomainTest} to create your own tests for this document.
 */
public class PhoneNumberTest extends AbstractDomainTest<PhoneNumber> {

	private PhoneNumberFactory factory;

	@Override
	protected PhoneNumber getBean() throws Exception {
		if (factory == null) {
			factory = new PhoneNumberFactory();
		}

		return factory.getInstance();
	}
}