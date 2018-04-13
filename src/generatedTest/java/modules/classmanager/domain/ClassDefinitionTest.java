package modules.classmanager.domain;

import modules.classmanager.util.ClassDefinitionFactory;
import util.AbstractDomainTest;

/**
 * Generated - local changes will be overwritten.
 * Extend {@link AbstractDomainTest} to create your own tests for this document.
 */
public class ClassDefinitionTest extends AbstractDomainTest<ClassDefinition> {

	private ClassDefinitionFactory factory;

	@Override
	protected ClassDefinition getBean() throws Exception {
		if (factory == null) {
			factory = new ClassDefinitionFactory();
		}

		return factory.getInstance();
	}
}