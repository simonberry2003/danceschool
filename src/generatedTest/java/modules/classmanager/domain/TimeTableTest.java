package modules.classmanager.domain;

import modules.classmanager.util.TimeTableFactory;
import util.AbstractDomainTest;

/**
 * Generated - local changes will be overwritten.
 * Extend {@link AbstractDomainTest} to create your own tests for this document.
 */
public class TimeTableTest extends AbstractDomainTest<TimeTable> {

	private TimeTableFactory factory;

	@Override
	protected TimeTable getBean() throws Exception {
		if (factory == null) {
			factory = new TimeTableFactory();
		}

		return factory.getInstance();
	}
}