package cdac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cdac.reposp1.Coursesrepo;
import cdac.servicesp1.ServiceInf;

@SpringBootApplication
public class CdacApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CdacApplication.class, args);
	}

	@Autowired
	Coursesrepo cs;

	@Autowired
	ServiceInf s;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello");

		// ------------------------ //

	}

}
