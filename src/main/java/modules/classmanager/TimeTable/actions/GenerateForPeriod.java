package modules.classmanager.TimeTable.actions;

import org.skyve.metadata.controller.ServerSideAction;
import org.skyve.metadata.controller.ServerSideActionResult;
import org.skyve.web.WebContext;

import modules.classmanager.TimeTable.TimeTableExtension;

@SuppressWarnings("serial")
public class GenerateForPeriod implements ServerSideAction<TimeTableExtension> {

	@Override
	public ServerSideActionResult execute(TimeTableExtension timeTable, WebContext webContext) throws Exception {
		timeTable.generateForPeriod();
		return new ServerSideActionResult(timeTable);
	}
}
