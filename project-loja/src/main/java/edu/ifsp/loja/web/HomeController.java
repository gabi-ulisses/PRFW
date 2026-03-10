package edu.ifsp.loja.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping("/")
	public String haus(
			@RequestParam(name="nome", required=false, defaultValue="Usuário") String nome,
			Model model) {
		
		model.addAttribute("nome", nome);		
		return "home";
	}
	
}
