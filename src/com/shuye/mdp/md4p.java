/**
 * 
 */
package com.shuye.mdp;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author shuye
 *
 */
public class md4p {
	public static String p2md(String psw){
		String hash = null;
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			md.update(psw.getBytes("UTF8"));
			byte ca[] = md.digest();
			hash = b2s(ca);
		} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hash;
	}
	public static String b2s(byte b[]){
		StringBuffer sb = new StringBuffer();
		for(byte i:b){
			sb.append(Integer.toHexString(i & 0xff));
		}
		return sb.toString();
	}
	public static boolean isequal(String hash, String input){
		if(hash.equals(p2md(input)))
			return true;
		else
			return false;
	}
	public static void main(String args[]){
		String str1="123123";
		String str2="123123";
		String str3="111123";
		String hash=p2md(str1);
		System.out.println(isequal(hash, str2));
		System.out.println(isequal(hash, str3));
	}
}
