package bogdanbrl.springframework.sfgid.controllers;

import bogdanbrl.springframework.sfgid.services.GreetingService;
import org.springframework.stereotype.Controller;

/**
 * @author Bogdan Brl
 * @created 18/03/2021 - 3:38 PM
 * @project sfg-di
 */

@Controller
public class MyController {

    private final GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello(){
        return greetingService.sayGreeting();
    }
}
