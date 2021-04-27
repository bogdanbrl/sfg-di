package bogdanbrl.springframework.sfgid.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author Bogdan Brl
 * @created 19/03/2021 - 12:44 PM
 * @project sfg-di
 */

//@Primary
//@Service
public class PrimaryGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello world - from the PRIMARy Bean";
    }
}
