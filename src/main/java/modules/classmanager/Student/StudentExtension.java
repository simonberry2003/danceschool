package modules.classmanager.Student;

import modules.ModulesUtil;
import modules.classmanager.domain.Student;

@SuppressWarnings("serial")
public class StudentExtension extends Student {
	@Override
	public String getBizKey() {
		return String.format("%s %s (%d)", getFirstName(), getLastName(), getStudentId());
	}

	public void initialiseId() throws Exception {
		if (getStudentId() == null) {
			setStudentId(ModulesUtil.getNextDocumentNumber(Student.MODULE_NAME, Student.DOCUMENT_NAME, Student.studentIdPropertyName));
		}
	}
}
