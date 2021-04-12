package cdac;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cdac.servicesp1.Service;

@SpringBootTest
public class Service1Test {

	@Autowired
	Service s1;

	@Test // testing student login
	public void loginte() {
		assertEquals(true, s1.login(1010520001, "anshul66"));
	}
}
