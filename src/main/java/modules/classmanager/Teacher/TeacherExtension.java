package modules.classmanager.Teacher;

import modules.classmanager.domain.Teacher;

@SuppressWarnings("serial")
public class TeacherExtension extends Teacher {
	@Override
	public String getBizKey() {
		return getContact().getBizKey();
	}
}
