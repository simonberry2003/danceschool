package modules.classmanager.Client;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import org.skyve.persistence.Persistence;

import com.google.common.base.Preconditions;

import lombok.val;
import modules.classmanager.domain.Client;

@Default
public class ClientProviderImpl implements ClientProvider {

	private @Inject Persistence persistence;

	@Override
	public ClientExtension getByExternalId(String externalId) {
		Preconditions.checkNotNull(externalId);
		val q = persistence.newDocumentQuery(Client.MODULE_NAME, Client.DOCUMENT_NAME);
		q.getFilter().addEquals(Client.externalIdPropertyName, externalId);
		return q.beanResult();
	}
}
