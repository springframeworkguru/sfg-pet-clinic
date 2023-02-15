/**
 * 
 */
package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Hoek0024 on 15 feb. 2023
 *
 */
@Controller
public class IndexController {
	
	@GetMapping({"", "/", "index", "index.html"})
	public String index() {
		return "index";
	}

}
