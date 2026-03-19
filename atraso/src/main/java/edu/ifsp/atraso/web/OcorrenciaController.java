package edu.ifsp.atraso.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import edu.ifsp.atraso.modelo.Ocorrencia;
import edu.ifsp.atraso.persistencia.OcorrenciaRepositorio;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/ocorrencia")
public class OcorrenciaController {
	
	private OcorrenciaRepositorio repo;

	public OcorrenciaController(OcorrenciaRepositorio repo) {
		this.repo = repo;
	}
	
	@GetMapping("/novo")
	public String novo(Model model) {				
		model.addAttribute("ocorrencia", new Ocorrencia());						
		return "ocorrencia/editar";
	}
	
	@GetMapping("/{id}/editar")
	public String editar(
			@PathVariable(name = "id") Integer id, 
			Model model) {
		
		Ocorrencia ocorrencia = repo.findById(id).get();
		model.addAttribute("ocorrencia", ocorrencia);

		return "ocorrencia/editar";
	}

	
	@PostMapping("/salvar")
	public String salvar(@Valid Ocorrencia ocorrencia, Errors errors) {
		if (errors.hasErrors()) {
			for (var e : errors.getAllErrors()) {
				System.out.println(e);
			}
			return "ocorrencia/editar";
		}
		System.out.println("Salvando ocorrência...");
		
		System.out.println("ID: " + ocorrencia.getId());
		System.out.println("Nome do aluno: " + ocorrencia.getNome_aluno());
		System.out.println("Horário: " + ocorrencia.getHorario());
		System.out.println("Justificativa: " + ocorrencia.getJustificativa());

		ocorrencia = repo.save(ocorrencia);
		
		return "redirect:/ocorrencia/%d/editar".formatted(ocorrencia.getId());
	}

	@GetMapping("/{id}/excluir")
	public String excluir(
			@PathVariable(name = "id") Integer id, 
			Model model) {
		
		Ocorrencia ocorrencia = repo.findById(id).get();
		model.addAttribute("ocorrencia", ocorrencia);
		
		repo.delete(ocorrencia);

		return "redirect:/ocorrencia/listar";
	}

	
	@GetMapping("/listar")
	public String listar(Model model) {
		
		Iterable<Ocorrencia> ocorrencias = repo.findAll();		
		model.addAttribute("ocorrencias", ocorrencias);
		
		return "ocorrencia/listar";
	}



}
