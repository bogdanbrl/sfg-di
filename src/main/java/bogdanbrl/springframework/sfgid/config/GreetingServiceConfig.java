package bogdanbrl.springframework.sfgid.config;

import bogdanbrl.springframework.sfgid.controllers.SetterInjectedController;
import bogdanbrl.springframework.sfgid.datasource.FakeDataSource;
import bogdanbrl.springframework.sfgid.repositories.EnglishGreetingRepository;
import bogdanbrl.springframework.sfgid.repositories.EnglishGreetingRepositoryImpl;
import bogdanbrl.springframework.sfgid.services.*;
import com.bogdanbrl.springframework.pets.PetService;
import com.bogdanbrl.springframework.pets.PetServiceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    // get properties from properties file
    @Bean
    FakeDataSource fakeDataSource(@Value("${db.username}") String username,
                                  @Value("${db.password}") String password,
                                  @Value("${db.jdbcurl}") String jdbcurl) {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcurl);

        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Profile({"cat"})
    @Bean
    PetService catDogService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

    // @Bean -- set in xml
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile({"EN", "default"})
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Profile({"ES"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService() {
        return new I18nSpanishGreetingService();
    }

}
