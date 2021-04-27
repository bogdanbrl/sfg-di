package bogdanbrl.springframework.sfgid;

import bogdanbrl.springframework.sfgid.config.SfgPropertiesBindingConfiguration;
import bogdanbrl.springframework.sfgid.config.SfgPropertiesConstructorConfig;
import bogdanbrl.springframework.sfgid.controllers.*;
import bogdanbrl.springframework.sfgid.datasource.FakeDataSource;
import bogdanbrl.springframework.sfgid.services.beanScopeExample.PrototypeBean;
import bogdanbrl.springframework.sfgid.services.beanScopeExample.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"bogdanbrl.springframework.sfgid", "com.bogdanbrl.springframework.pets"})
@SpringBootApplication
public class SfgIdApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SfgIdApplication.class, args);

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());


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

		System.out.println("\n\n\n\nDemonstrating bean scopes");
		SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());
		SingletonBean singletonBean3 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean3.getMyScope());

		PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());
		PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());
		PrototypeBean prototypeBean3 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());

		System.out.println("\n\n\n\n\nUse properties files");
		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcurl());


		System.out.println("\n\n\n\n\n\nConfig app with properties");
		SfgPropertiesBindingConfiguration sfgPropertiesBindingConfiguration = ctx.getBean(SfgPropertiesBindingConfiguration.class);
		System.out.println(sfgPropertiesBindingConfiguration.getUsername());
		System.out.println(sfgPropertiesBindingConfiguration.getPassword());
		System.out.println(sfgPropertiesBindingConfiguration.getJdbcurl());

		System.out.println("\n\n\n\n\n\nConfig app with properties in constructor");
		SfgPropertiesConstructorConfig sfgPropertiesConstructorConfig = ctx.getBean(SfgPropertiesConstructorConfig.class);
		System.out.println(sfgPropertiesConstructorConfig.getUsername());
		System.out.println(sfgPropertiesConstructorConfig.getPassword());
		System.out.println(sfgPropertiesConstructorConfig.getJdbcurl());
	}

}
