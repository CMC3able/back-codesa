package co.com.codesa.prueba.backCodesa;

import co.com.codesa.prueba.backCodesa.model.MySQL.Persona;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackCodesaApplicationTests {

	@Test
	void contextLoads() {
		Persona p = new Persona();
		p.setNombre("juan");
		p.setApellido("montoya");
		p.setTelefono("123456789");
		p.setEmail("hola@gmail.com");
		System.out.println(p.toString());
	}

}
