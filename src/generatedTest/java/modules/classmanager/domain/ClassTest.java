package modules.classmanager.domain;

import modules.classmanager.util.ClassFactory;
import util.AbstractDomainTest;

/**
 * Generated - local changes will be overwritten.
 * Extend {@link AbstractDomainTest} to create your own tests for this document.
 */
public class ClassTest extends AbstractDomainTest<Class> {

	private ClassFactory factory;

	@Override
	protected Class getBean() throws Exception {
		if (factory == null) {
			factory = new ClassFactory();
		}

		return factory.getInstance();
	}
}