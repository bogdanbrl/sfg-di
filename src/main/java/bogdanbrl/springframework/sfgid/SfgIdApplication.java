package bogdanbrl.springframework.sfgid;

import bogdanbrl.springframework.sfgid.controllers.ConstructorInjectedController;
import bogdanbrl.springframework.sfgid.controllers.MyController;
import bogdanbrl.springframework.sfgid.controllers.PropertyInjectedController;
import bogdanbrl.springframework.sfgid.controllers.SetterInjectedController;
import bogdanbrl.springframework.sfgid.services.PrimaryGreetingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgIdApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SfgIdApplication.class, args);

		System.out.println("----------- Property DI:");

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");

		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("----------- Setter DI:");

		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");

		System.out.println(setterInjectedController.getGreeting());

		System.out.println("----------- Constructor DI:");

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");

		System.out.println(constructorInjectedController.getGreeting());

		System.out.println("-----------  DI using Primary annotation (similar to a default value - when no qualifier is provided):");

		MyController myController = (MyController) ctx.getBean("myController");

		System.out.println(myController.sayHello());
	}

}
