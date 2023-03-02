package wm.web;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class passwordEncoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
		 String pass= passwordEncoder.encode("claseclase");
		 System.out.println(pass);
		 
		 
		
		 
		
		 
		
		 
	}

}
//$2a$10$QY4LUF/zeOTgrlYPmlXt4uSrGZ.e29Wluo8lf1KLIVv9DyQ1lA.lu
//7110eda4d09e062aa5e4a390b0a572ac0d2c0220

//68da2f061abdb7429fbb3a04b1f742d9469b3ac47f0ddce909e817c41af7466209b195cccbbf740c
//504f008c8fcf8b2ed5dfcde752fc5464ab8ba064215d9c5b5fc486af3d9ab8c81b14785180d2ad7cee1ab792ad44798c