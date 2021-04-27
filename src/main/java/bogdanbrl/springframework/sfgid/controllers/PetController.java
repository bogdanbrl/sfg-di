package bogdanbrl.springframework.sfgid.controllers;

import com.bogdanbrl.springframework.pets.PetService;
import org.springframework.stereotype.Controller;

/**
 * @author Bogdan Brl
 * @created 19/03/2021 - 1:28 PM
 * @project sfg-di
 */

@Controller
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    public String whichPetIsTheBest(){
        return petService.getPetType();
    }
}
