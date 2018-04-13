package modules.classmanager.TimeTable.actions;

import modules.classmanager.TimeTable.TimeTableExtension;
import modules.classmanager.util.TimeTableFactory;
import util.AbstractActionTest;

/**
 * Generated - local changes will be overwritten.
 * Extend {@link AbstractActionTest} to create your own tests for this action.
 */
public class GenerateForPeriodTest extends AbstractActionTest<TimeTableExtension, GenerateForPeriod> {

	private TimeTableFactory factory;

	@Override
	protected GenerateForPeriod getAction() {
		return new GenerateForPeriod();
	}

	@Override
	protected TimeTableExtension getBean() throws Exception {
		if (factory == null) {
			factory = new TimeTableFactory();
		}

		return factory.getInstance();
	}
}