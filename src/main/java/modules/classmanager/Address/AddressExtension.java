package modules.classmanager.Address;

import modules.classmanager.domain.Address;

@SuppressWarnings("serial")
public class AddressExtension extends Address {
	@Override
	public String getBizKey() {
		return String.format("%s %s %s %s", getStreetAddress(), getSuburb(), getPostcode(), getState().toCode());
	}
}
