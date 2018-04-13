package modules.classmanager.Attachment;

import modules.classmanager.domain.Attachment;

@SuppressWarnings("serial")
public class AttachmentExtension extends Attachment {
	@Override
	public String getBizKey() {
		return getName();
	}
}
