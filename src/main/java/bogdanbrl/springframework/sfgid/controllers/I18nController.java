package bogdanbrl.springframework.sfgid.controllers;

import bogdanbrl.springframework.sfgid.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author Bogdan Brl
 * @created 19/03/2021 - 12:56 PM
 * @project sfg-di
 */

@Controller
public class I18nController {

    private final GreetingService greetingService;

    public I18nController(@Qualifier("i18nService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello(){
        return greetingService.sayGreeting();
    }
}
