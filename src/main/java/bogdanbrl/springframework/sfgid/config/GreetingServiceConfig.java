package bogdanbrl.springframework.sfgid.config;

import bogdanbrl.springframework.sfgid.controllers.SetterInjectedController;
import bogdanbrl.springframework.sfgid.repositories.EnglishGreetingRepository;
import bogdanbrl.springframework.sfgid.repositories.EnglishGreetingRepositoryImpl;
import bogdanbrl.springframework.sfgid.services.*;
import com.bogdanbrl.springframework.pets.PetService;
import com.bogdanbrl.springframework.pets.PetServiceFactory;
import org.springframework.context.annotation.*;

@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Profile({"cat"})
    @Bean
    PetService catDogService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }

    // @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile({"EN", "default"})
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Profile({"ES"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService(){
        return new I18nSpanishGreetingService();
    }

}
