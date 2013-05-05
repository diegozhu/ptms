package net.diegozhu.j2ee.ptms.utils;

import java.util.regex.Pattern;

public class Utils {

	public static boolean isPswFormat(String password) {
		return Pattern.matches("\\w{4,18}", password);
	}

	public static boolean isEmailFormat(String email) {
		return Pattern.matches("\\w+([-+.']\\w+\\.*)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*", email);
	}

	public static boolean isPhoneFormat(String username) {
		return Pattern.matches("\\d{11}", username);
	}
}
