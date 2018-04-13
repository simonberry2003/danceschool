package modules.classmanager.Period;

import modules.classmanager.domain.Period;

@SuppressWarnings("serial")
public class PeriodExtension extends Period {
	@Override
	public String getBizKey() {
		return String.format("%s (%s - %s)", getName(), getStart(), getEnd());
	}
}
