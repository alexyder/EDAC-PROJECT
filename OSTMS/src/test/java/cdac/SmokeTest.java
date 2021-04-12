package cdac;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cdac.controller.Controller;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private Controller c;

	@Test
	void smokeTesting() {
		assertThat(c).isNotNull();
	}

}

// smoke test is done to check whether the deployed build is stable or not