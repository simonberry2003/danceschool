package com.hbs.xero;

import javax.enterprise.inject.Default;
import javax.inject.Singleton;

import com.xero.api.JsonConfig;
import com.xero.api.XeroClient;

import lombok.val;

@Default
@Singleton
public class XeroClientProviderImpl implements XeroClientProvider {
	@Override
	public XeroClient getClient() {
		val config = JsonConfig.getInstance();
		val client = new XeroClient();
		client.setOAuthToken(config.getConsumerKey(), config.getConsumerSecret());
		return client;
	}
}
