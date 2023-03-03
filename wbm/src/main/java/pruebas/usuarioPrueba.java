package pruebas;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class usuarioPrueba {
	public static void main(String[] args) {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String plainPassword = "claseclase";
		String encodedPassword = passwordEncoder.encode(plainPassword);

		System.out.println(encodedPassword);

		/*
		 INSERT INTO `sql7600578`.`datos_personales` (`dni`, `apellidos`, `direccion`,
		 `es_cliente`, `nombre`, `telefono`) VALUES ('12345678A', 'Rodrigo Pla',
		 'calle de la Calle', '1', 'Carlos', '9874989898');
		 */

	}
}
