package edu.ifsp.loja.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ifsp.loja.modelo.Cliente;
import edu.ifsp.loja.persistencia.ClienteRepositorio;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepositorio repo;

	@GetMapping("/editar")
	public String iniciar(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		
		return "cliente/editar";
	}
	
	@PostMapping("/editar")
	public String salvar(@Valid Cliente cliente, Errors errors) {
		if (errors.hasErrors()) {
			for (var e : errors.getAllErrors()) {
				System.out.println(e);
			}
			return "cliente/editar";
		}
		System.out.println("Salvando cliente...");
		
		System.out.println("ID: " + cliente.getId());
		System.out.println("Nome: " + cliente.getNome());
		System.out.println("Ativo: " + cliente.isAtivo());
		
		return "redirect:/cliente/editar";
	}
	
	
	
	@GetMapping("/listar")
	public String listar(Model model) {
		
		Iterable<Cliente> clientes = repo.findAll();
		
		model.addAttribute("clientes", clientes);
		
		return "cliente/listar";
	}

}
