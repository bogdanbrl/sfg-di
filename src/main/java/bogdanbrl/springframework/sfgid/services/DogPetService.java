package bogdanbrl.springframework.sfgid.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Bogdan Brl
 * @created 19/03/2021 - 1:30 PM
 * @project sfg-di
 */

@Profile({"dog", "default"})
@Service
public class DogPetService implements PetService{
    public String getPetType(){
        return "Dogs are the best!";
    }
}
