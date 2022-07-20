package hello;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SayHelloApplication {
	@Autowired
	Environment env;
  private static Logger log = LoggerFactory.getLogger(SayHelloApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SayHelloApplication.class, args);
	}

  @GetMapping("/greeting")
  public String greet() {
	log.info("Access /greeting");

	List<String> greetings = Arrays.asList("Hi there", "Greetings", "Salutations");
	Random rand = new Random();

	int randomNum = rand.nextInt(greetings.size());
	return "Instance Id : "+env.getProperty("instance.id") + " --  "+greetings.get(randomNum);
  }

  @GetMapping("/")
  public String home() {
	log.info("Access /");
	return "Hi!";
  }
}
