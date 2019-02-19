package cn.boai.util;

import java.security.MessageDigest;

public class ChangePass {
	public static String Change(String password){
		try {
			MessageDigest m = MessageDigest.getInstance("SHA");
			m.update(password.getBytes());
			byte[] b = m.digest();
			password= new String(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return password;
	}
}
