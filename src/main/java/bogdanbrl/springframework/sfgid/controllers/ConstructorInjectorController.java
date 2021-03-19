package bogdanbrl.springframework.sfgid.controllers;

import bogdanbrl.springframework.sfgid.services.GreetingService;

/**
 * @author Bogdan Brl
 * @created 19/03/2021 - 11:22 AM
 * @project sfg-di
 */
public class ConstructorInjectorController {

    private final GreetingService greetingService;

    public ConstructorInjectorController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
