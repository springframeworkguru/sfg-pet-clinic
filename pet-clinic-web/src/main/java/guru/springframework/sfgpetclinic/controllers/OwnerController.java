/**
 * 
 */
package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Hoek0024 on 15 feb. 2023
 *
 */
@RequestMapping("/owners")
@Controller
public class OwnerController {
	@GetMapping({"", "/", "/index", "/index.html" })
	public String listOwners() {
		return "owners/index";
	}
}
