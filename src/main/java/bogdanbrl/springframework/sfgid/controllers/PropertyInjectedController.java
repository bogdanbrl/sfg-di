package bogdanbrl.springframework.sfgid.controllers;

import bogdanbrl.springframework.sfgid.services.GreetingService;

/**
 * @author Bogdan Brl
 * @created 19/03/2021 - 11:09 AM
 * @project sfg-di
 */
public class PropertyInjectedController {

    public GreetingService greetingService;

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
