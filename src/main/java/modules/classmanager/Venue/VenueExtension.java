package modules.classmanager.Venue;

import modules.classmanager.domain.Venue;

@SuppressWarnings("serial")
public class VenueExtension extends Venue {
	@Override
	public String getBizKey() {
		return getName();
	}

	@Override
	public String toString() {
		return getBizKey();
	}
}
