package polszewsky.wineme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan("polszewsky.wineme")
@ComponentScan("polszewsky.wineme")
@SpringBootApplication
public class WineMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WineMeApplication.class, args);
	}

}
