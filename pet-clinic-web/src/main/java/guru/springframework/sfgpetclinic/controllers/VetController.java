/**
 * 
 */
package guru.springframework.sfgpetclinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.sfgpetclinic.services.interfaces.VetService;

/**
 * @author Hoek0024 on 15 feb. 2023
 *
 */
@RequestMapping
@Controller
public class VetController {

	private final VetService vetService;

	/**
	 * @param vetService
	 */
	@Autowired
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}

	@GetMapping({"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
	public String listVets(Model model) {
		
		model.addAttribute("vets", vetService.findAll());
		
		return "vets/index";
	}

}
