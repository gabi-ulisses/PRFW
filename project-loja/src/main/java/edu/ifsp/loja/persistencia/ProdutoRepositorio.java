package edu.ifsp.loja.persistencia;

import edu.ifsp.loja.modelo.Produto;

public interface ProdutoRepositorio {
	Produto findById(int id);
	Iterable<Produto> findAll();
	Produto save(Produto cliente);

}