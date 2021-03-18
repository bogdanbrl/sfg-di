package bogdanbrl.springframework.sfgid.controllers;

import org.springframework.stereotype.Controller;

/**
 * @author Bogdan Brl
 * @created 18/03/2021 - 3:38 PM
 * @project sfg-di
 */

@Controller
public class MyController {

    public String sayHello(){
        System.out.println("Hello World!!!");
        return "Hi Folks!";
    }
}
