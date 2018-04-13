package modules.classmanager.Client;

import org.skyve.metadata.model.document.Bizlet;

@SuppressWarnings("serial")
public class ClientBizlet extends Bizlet<ClientExtension> {

	@Override
	public void preSave(ClientExtension client) throws Exception {
		super.preSave(client);
		client.initialiseId();
	}
}
