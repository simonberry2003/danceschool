package modules.classmanager.domain;

import modules.classmanager.util.PeriodFactory;
import util.AbstractDomainTest;

/**
 * Generated - local changes will be overwritten.
 * Extend {@link AbstractDomainTest} to create your own tests for this document.
 */
public class PeriodTest extends AbstractDomainTest<Period> {

	private PeriodFactory factory;

	@Override
	protected Period getBean() throws Exception {
		if (factory == null) {
			factory = new PeriodFactory();
		}

		return factory.getInstance();
	}
}