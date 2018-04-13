package modules.classmanager.domain;

import modules.classmanager.util.AttachmentFactory;
import util.AbstractDomainTest;

/**
 * Generated - local changes will be overwritten.
 * Extend {@link AbstractDomainTest} to create your own tests for this document.
 */
public class AttachmentTest extends AbstractDomainTest<Attachment> {

	private AttachmentFactory factory;

	@Override
	protected Attachment getBean() throws Exception {
		if (factory == null) {
			factory = new AttachmentFactory();
		}

		return factory.getInstance();
	}
}