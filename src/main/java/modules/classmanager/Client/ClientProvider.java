package modules.classmanager.Client;

public interface ClientProvider {
	ClientExtension getByExternalId(String externalId);
}
