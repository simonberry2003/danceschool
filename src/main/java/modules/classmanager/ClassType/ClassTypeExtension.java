package modules.classmanager.ClassType;

import modules.classmanager.domain.ClassType;

@SuppressWarnings("serial")
public class ClassTypeExtension extends ClassType {
	@Override
	public String getBizKey() {
		return getName();
	}
}
