package pruebas;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class usuarioPrueba {
	public static void main(String[] args) {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String plainPassword = "claseclase";
		String encodedPassword = passwordEncoder.encode(plainPassword);

		System.out.println(encodedPassword);

		/*
		 INSERT INTO `sql7600578`.`datos_personales` (`dni`, `apellidos`, `direccion`, `es_cliente`, `nombre`, `telefono`) VALUES ('12345678A', 'Rodrigo Pla', 'calle de la Calle', '1', 'Carlos', '9874989898');
		 INSERT INTO `sql7600578`.`datos_personales` (`dni`, `apellidos`, `direccion`, `es_cliente`, `nombre`, `telefono`) VALUES ('87654321B', 'Martinez Pla','calle de la Calle', '1', 'Laura', '9874989898');
		 
		 INSERT INTO `sql7600578`.`vehiculo` (`matricula`, `anio`, `marca`, `modelo`, `tipo`, `cliente_dni`) VALUES ('4567OKI', '2021', 'Volkswgen', 'Touran', 'TURISMO', '12345678A');
		 INSERT INTO `sql7600578`.`vehiculo` (`matricula`, `anio`, `marca`, `modelo`, `tipo`, `cliente_dni`) VALUES ('1234LKJ', '2008', 'Ducati', 'M1', 'MOTOCICLETA', '12345678A');
		 INSERT INTO `sql7600578`.`vehiculo` (`matricula`, `anio`, `marca`, `modelo`, `tipo`, `cliente_dni`) VALUES ('5194YTH', '2012', 'Seat', 'Ibiza', 'TURISMO', '87654321B');
		 */

	}
}
