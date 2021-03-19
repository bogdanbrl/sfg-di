package bogdanbrl.springframework.sfgid.services;

import org.springframework.stereotype.Service;

/**
 * @author Bogdan Brl
 * @created 19/03/2021 - 11:58 AM
 * @project sfg-di
 */

@Service
public class ServiceInjectedGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello World - service";
    }
}
