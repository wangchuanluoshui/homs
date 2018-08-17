package com.summit.homs.util;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncode implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return equalsNoEarlyReturn(rawPassword.toString(), encodedPassword);
	}

	
	static boolean equalsNoEarlyReturn(String a, String b) {
		char[] caa = a.toCharArray();
		char[] cab = b.toCharArray();

		if (caa.length != cab.length) {
			return false;
		}

		byte ret = 0;
		for (int i = 0; i < caa.length; i++) {
			ret |= caa[i] ^ cab[i];
		}
		return ret == 0;
	}
}
