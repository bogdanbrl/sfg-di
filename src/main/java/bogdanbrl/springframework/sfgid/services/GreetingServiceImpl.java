package bogdanbrl.springframework.sfgid.services;

/**
 * @author Bogdan Brl
 * @created 19/03/2021 - 11:07 AM
 * @project sfg-di
 */
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World!!!";
    }
}
