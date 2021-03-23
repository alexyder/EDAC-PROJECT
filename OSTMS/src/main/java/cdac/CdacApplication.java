package cdac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cdac.servicesp1.ServiceInf;
import cdac.servicesp2.ServiceInf2;

@SpringBootApplication
public class CdacApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CdacApplication.class, args);
	}

	@Autowired
	ServiceInf2 s2;

	@Autowired
	ServiceInf s1;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello");

	}

}
