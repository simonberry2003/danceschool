package modules.classmanager.domain;

import modules.classmanager.util.ClassTypeFactory;
import util.AbstractDomainTest;

/**
 * Generated - local changes will be overwritten.
 * Extend {@link AbstractDomainTest} to create your own tests for this document.
 */
public class ClassTypeTest extends AbstractDomainTest<ClassType> {

	private ClassTypeFactory factory;

	@Override
	protected ClassType getBean() throws Exception {
		if (factory == null) {
			factory = new ClassTypeFactory();
		}

		return factory.getInstance();
	}
}