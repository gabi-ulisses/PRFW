package edu.ifsp.loja.persistencia;

import edu.ifsp.loja.modelo.Cliente;

public interface ClienteRepositorio {
	Cliente findById(int id);
	Iterable<Cliente> findAll();
	Cliente save(Cliente cliente);
}
