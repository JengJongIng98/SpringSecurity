package com.itwillbs.security;

import org.springframework.security.crypto.password.PasswordEncoder;

//NoOpPasswordEncoder 객체 => {noop}비밀번호 형태를 처리하는 객체
// => 시큐리티 5버전부터 사용불가
public class CustomNoopPasswordEncoder implements PasswordEncoder {
	
	@Override
	public String encode(CharSequence rawPassword) {
		System.out.println(" 암호화 처리! ");
		// a => 5, h => q => +(salt) b
		System.out.println(" 임시로 암호화 없이 처리! ");
		return rawPassword.toString();
	}
	
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		System.out.println(" 기존의 비밀번호, 암호화된 비밀번호 비교 !");
		
		return rawPassword.toString().equals(encodedPassword);
	}
	
}
