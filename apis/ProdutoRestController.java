/*

Execute os comandos a seguir.
$ git clone https://gitlab.com/mcrisc/loja-frameworks-2026-1.git loja
$ cd loja
$ git switch -c dev pre-rest
$ bash reset-database.sh

*/

package edu.ifsp.loja.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ifsp.loja.modelo.Produto;
import edu.ifsp.loja.persistence.ProdutoRepositorio;

@RestController
@RequestMapping(path = "/api/produto", produces = "application/json")
public class ProdutoRestController {
	
	@Autowired
	private ProdutoRepositorio repo;

	@GetMapping
	public List<Produto> listar(){
		return repo.findAll();
	}
	
}
