package bogdanbrl.springframework.sfgid.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Bogdan Brl
 * @created 19/03/2021 - 12:59 PM
 * @project sfg-di
 */

@Profile("ES")
@Service("i18nService")
public class I18nSpanishGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hola Mundo - ES";
    }
}
