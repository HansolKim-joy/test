package common.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class LockPassWord extends HttpServletRequestWrapper {

	public LockPassWord(HttpServletRequest request) {
		super(request);
	}
	
	// 회원가입, 로그인 , 비밀번호 변경 (암호화)
	// user_Pass, lg_userPwd, userPwd 
	@Override
	public String getParameter(String name) {
		String value = "";
		if(name != null && (name.equals("user_Pass") || name.equals("lg_userPwd") || name.equals("userPwd") || name.equals("inputPwd"))) {
			value = getSha512(super.getParameter(name));
		} else {
			value = super.getParameter(name);
		}
		
		return value;
	
	}
	
	
	public static String getSha512(String userPwd) {
		String encPwd = null;
		
		MessageDigest md = null;
		
		try {
			md = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		byte[] bytes = userPwd.getBytes(Charset.forName("UTF-8"));
		md.update(bytes);
		encPwd = Base64.getEncoder().encodeToString(md.digest());
		
		return encPwd;
	}
	
}
