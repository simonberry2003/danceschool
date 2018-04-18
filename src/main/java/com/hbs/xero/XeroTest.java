package com.hbs.xero;

import java.io.IOException;

import com.xero.api.XeroClient;

import lombok.val;

public class XeroTest {

	public static void main(String[] args) throws IOException {

		XeroClient client = new XeroClientProviderImpl().getClient();

		// Get All Contacts
		val horn = client.getContact("b07b41d8-a800-4f08-91ed-315c7d31dd2b");
		System.out.println(horn.getName());
//		List<Contact> contactList = client.getContacts();
//		System.out.println("How many contacts did we find: " + contactList.size());
//		for (val contact : contactList) {
//			System.out.println(contact.getContactID() + " : " + contact.getName() + " : " + contact.getEmailAddress());
//		}
	}
}
