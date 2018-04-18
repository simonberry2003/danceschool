package modules.classmanager.Client;

import modules.ModulesUtil;
import modules.classmanager.domain.Client;

@SuppressWarnings("serial")
public class ClientExtension extends Client {
	@Override
	public String getBizKey() {
		return String.format("%s (%d)", getContact().getBizKey(), getClientId());
	}

	@Override
	public String toString() {
		return getBizKey();
	}

	public void initialiseId() throws Exception {
		if (getClientId() == null) {
			setClientId(ModulesUtil.getNextDocumentNumber(Client.MODULE_NAME, Client.DOCUMENT_NAME, Client.clientIdPropertyName));
		}
	}

	public void markUpdated() {
		setUpdated(true);
	}
}
