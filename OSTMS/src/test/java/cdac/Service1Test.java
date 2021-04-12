package cdac;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cdac.servicesp1.Service;

@SpringBootTest
public class Service1Test {

	@Autowired
	Service s1;

	// TESTING NOTIFICATIONS

	@DisplayName("Adding Public Notification")
	@Test
	public void addnoti() {
		assertEquals(true, s1.addgnoti("Testing"));
	}

	@DisplayName("When adding empty/null notification")
	@Test
	public void addnoti2() {
		assertEquals(false, s1.addgnoti(null));
	}
}
