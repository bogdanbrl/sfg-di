package bogdanbrl.springframework.sfgid;

import bogdanbrl.springframework.sfgid.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgIdApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SfgIdApplication.class, args);

		MyController myController = (MyController) ctx.getBean("myController");

		String greeting = myController.sayHello();

		System.out.println(greeting);
	}

}
