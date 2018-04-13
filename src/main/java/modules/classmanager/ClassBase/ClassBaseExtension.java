package modules.classmanager.ClassBase;

import modules.classmanager.domain.ClassBase;

@SuppressWarnings("serial")
public class ClassBaseExtension extends ClassBase {
	@Override
	public String getBizKey() {
		return String.format("%s - %s - %s - %s", getType().getName(), getVenue().getName(), getStartTime(), getEndTime());
	}
}
