package edu.ifsp.loja.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ifsp.loja.modelo.Produto;
import edu.ifsp.loja.persistencia.ProdutoRepositorio;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepositorio repo;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		
		Iterable<Produto> produtos = repo.findAll();
		
		model.addAttribute("produtos", produtos);
		
		return "produto/listar";
	}

}
