package modules.classmanager.PhoneNumber;

import lombok.val;
import modules.classmanager.domain.PhoneNumber;

@SuppressWarnings("serial")
public class PhoneNumberExtension extends PhoneNumber {
	@Override
	public String getBizKey() {
		val sb = new StringBuilder(getType().toCode() + " ");
		if (getCountryCode() != null) {
			sb.append(getCountryCode() + " ");
		}
		if (getAreaCode() != null) {
			sb.append(getAreaCode() + " ");
		}
		if (getNumber() != null) {
			sb.append(getNumber() + " ");
		}
		return sb.substring(0, sb.length() - 1);
	}

	@Override
	public String toString() {
		return getBizKey();
	};
}
