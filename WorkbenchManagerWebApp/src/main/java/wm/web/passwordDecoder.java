package wm.web;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class passwordDecoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
		 boolean pass= passwordEncoder.matches("1234", "$2a$10$icuC.Tz8fBKUOyCL7Wo/6OaU06QwzybRpsHGP9RwzPyNjaJvSSt3S");
		 System.out.println(pass);
	}

}
//$2a$10$QY4LUF/zeOTgrlYPmlXt4uSrGZ.e29Wluo8lf1KLIVv9DyQ1lA.lu