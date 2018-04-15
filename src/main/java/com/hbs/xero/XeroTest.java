package com.hbs.xero;

import java.io.IOException;
import java.util.List;

import com.xero.api.Config;
import com.xero.api.JsonConfig;
import com.xero.api.XeroClient;
import com.xero.model.Contact;

import lombok.val;

public class XeroTest {

	public static void main(String[] args) throws IOException {

		Config config = JsonConfig.getInstance();

		// For Private Apps the token is your consumerKey and the tokenSecret is your consumerSecret
		// You can get these values out of the config object above
		XeroClient client = new XeroClient();
		client.setOAuthToken(config.getConsumerKey(), config.getConsumerSecret());

		// Get All Contacts
		List<Contact> contactList = client.getContacts();
		System.out.println("How many contacts did we find: " + contactList.size());
		for (val contact : contactList) {
			System.out.println(contact.getContactID() + " : " + contact.getName());
		}
	}
}
