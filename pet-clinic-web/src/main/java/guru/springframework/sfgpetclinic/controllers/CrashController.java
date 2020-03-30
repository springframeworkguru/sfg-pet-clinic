package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Gaetan Bloch
 * Created on 30/03/2020
 */
@Controller
final class CrashController {
    static final String URL_OUPS = "/oups";

    @GetMapping(URL_OUPS)
    public String triggerException() {
        throw new RuntimeException("Expected: controller used to showcase what happens when an exception is thrown");
    }
}
