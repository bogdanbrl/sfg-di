package bogdanbrl.springframework.sfgid.controllers;

import bogdanbrl.springframework.sfgid.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author Bogdan Brl
 * @created 19/03/2021 - 11:22 AM
 * @project sfg-di
 */
@Controller
public class ConstructorInjectedController {

    private final GreetingService greetingService;

    /* since spring 4.2, is no longer necessary to add @Autowired to a constructor dependency injector
    * because spring will add it automatically
    * */

    public ConstructorInjectedController(@Qualifier("constructorGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
