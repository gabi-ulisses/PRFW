package edu.ifsp.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

	@GetMapping("/novo")
	public String form(Model model) {
		model.addAttribute("funcionario",  new FuncionarioDTO());
		return "funcionario";
	}
	
	@PostMapping("/salvar")
	public String save(@Valid @ModelAttribute("funcionario") FuncionarioDTO funcionario,  Errors errors, Model model) {
		
		if (errors.hasErrors()) {
			System.out.println("Deu problema!");
			
			for(var e: errors.getAllErrors()) {
				System.out.println(e);
			}
			
		} else {
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("E-mail: " + funcionario.getEmail());
			System.out.println("Idade: " + funcionario.getIdade());
			System.out.println("Telefone: " + funcionario.getFone());

		}
		
		
		model.addAttribute("funcionario", funcionario);
		
		return "funcionario";
	}
	

}
