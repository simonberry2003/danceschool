package modules.classmanager.domain;

import modules.classmanager.util.TeacherFactory;
import util.AbstractDomainTest;

/**
 * Generated - local changes will be overwritten.
 * Extend {@link AbstractDomainTest} to create your own tests for this document.
 */
public class TeacherTest extends AbstractDomainTest<Teacher> {

	private TeacherFactory factory;

	@Override
	protected Teacher getBean() throws Exception {
		if (factory == null) {
			factory = new TeacherFactory();
		}

		return factory.getInstance();
	}
}