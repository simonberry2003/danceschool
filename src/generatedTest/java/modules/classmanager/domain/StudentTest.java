package modules.classmanager.domain;

import modules.classmanager.util.StudentFactory;
import util.AbstractDomainTest;

/**
 * Generated - local changes will be overwritten.
 * Extend {@link AbstractDomainTest} to create your own tests for this document.
 */
public class StudentTest extends AbstractDomainTest<Student> {

	private StudentFactory factory;

	@Override
	protected Student getBean() throws Exception {
		if (factory == null) {
			factory = new StudentFactory();
		}

		return factory.getInstance();
	}
}