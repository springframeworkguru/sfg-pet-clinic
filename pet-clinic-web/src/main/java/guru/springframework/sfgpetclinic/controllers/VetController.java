/**
 * 
 */
package guru.springframework.sfgpetclinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.interfaces.VetService;

/**
 * @author Hoek0024 on 15 feb. 2023
 *
 */
@RequestMapping("/vets")
@Controller
public class VetController {

	private final VetService<Vet> vetService;

	/**
	 * @param vetService
	 */
	@Autowired
	public VetController(VetService<Vet> vetService) {
		this.vetService = vetService;
	}

	@GetMapping({ "", "/", "/index", "/index.html" })
	public String listVets(Model model) {
		
		model.addAttribute("vets", vetService.findAll());
		
		return "vets/index";
	}

}
