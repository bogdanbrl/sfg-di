package bogdanbrl.springframework.sfgid;

import bogdanbrl.springframework.sfgid.controllers.ConstructorInjectorController;
import bogdanbrl.springframework.sfgid.controllers.MyController;
import bogdanbrl.springframework.sfgid.controllers.PropertyInjectedController;
import bogdanbrl.springframework.sfgid.controllers.SetterInjectedController;
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

		System.out.println("----------- Property DI:");

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");

		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("----------- Setter DI:");

		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");

		System.out.println(setterInjectedController.getGreeting());

		System.out.println("----------- Constructor DI:");

		ConstructorInjectorController constructorInjectorController = (ConstructorInjectorController) ctx.getBean("constructorInjectorController");

		System.out.println(constructorInjectorController.getGreeting());
	}

}
