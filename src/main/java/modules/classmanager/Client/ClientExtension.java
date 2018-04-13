package modules.classmanager.Client;

import modules.ModulesUtil;
import modules.classmanager.domain.Client;

@SuppressWarnings("serial")
public class ClientExtension extends Client {
	@Override
	public String getBizKey() {
		return String.format("%s (%d)", getContact().getBizKey(), getClientId());
	}

	public void initialiseId() throws Exception {
		if (getClientId() == null) {
			setClientId(ModulesUtil.getNextDocumentNumber(Client.MODULE_NAME, Client.DOCUMENT_NAME, Client.clientIdPropertyName));
		}
	}
}
