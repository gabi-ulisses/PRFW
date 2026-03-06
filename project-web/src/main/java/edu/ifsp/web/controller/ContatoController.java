package edu.ifsp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/contato")
public class ContatoController {

	@GetMapping("/novo")
	public String home(Model model) {
		model.addAttribute("contato",  new ContatoDTO());
		return "contato";
	}

	@PostMapping("/salvar")
	public String save(@Valid @ModelAttribute("contato") ContatoDTO contato, Errors errors, Model model) {
		
		if (errors.hasErrors()) {
			System.out.println("Deu problema!");
			
			for(var e: errors.getAllErrors()) {
				System.out.println(e);
			}
			
		} else {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("E-mail: " + contato.getEmail());
			System.out.println("Idade: " + contato.getIdade());
		}
		
		
		model.addAttribute("contato", contato);

		return "contato";
	}

}
