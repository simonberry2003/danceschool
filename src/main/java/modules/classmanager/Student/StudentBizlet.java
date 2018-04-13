package modules.classmanager.Student;

import org.skyve.metadata.model.document.Bizlet;

@SuppressWarnings("serial")
public class StudentBizlet extends Bizlet<StudentExtension> {

	@Override
	public void preSave(StudentExtension student) throws Exception {
		super.preSave(student);
		student.initialiseId();
	}
}
