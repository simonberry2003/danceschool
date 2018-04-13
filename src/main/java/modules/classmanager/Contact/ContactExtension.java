package modules.classmanager.Contact;

import modules.classmanager.domain.Contact;

@SuppressWarnings("serial")
public class ContactExtension extends Contact {
	@Override
	public String getBizKey() {
		return String.format("%s %s", getFirstName(), getLastName());
	}
}
