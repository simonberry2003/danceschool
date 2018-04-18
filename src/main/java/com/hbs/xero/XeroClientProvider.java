package com.hbs.xero;

import com.xero.api.XeroClient;

public interface XeroClientProvider {
	XeroClient getClient();
}
