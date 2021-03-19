package bogdanbrl.springframework.sfgid.controllers;

import bogdanbrl.springframework.sfgid.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Bogdan Brl
 * @created 19/03/2021 - 11:23 AM
 * @project sfg-di
 */
class ConstructorInjectorControllerTest {

    ConstructorInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new ConstructorInjectedController(new ConstructorGreetingService());
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}