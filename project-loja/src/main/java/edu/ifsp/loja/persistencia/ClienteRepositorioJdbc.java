package edu.ifsp.loja.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.ifsp.loja.modelo.Cliente;

@Repository
public class ClienteRepositorioJdbc implements ClienteRepositorio {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Cliente findById(int id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterable<Cliente> findAll() {
		return jdbc.query(
				"SELECT id, nome, email FROM cliente", 
				this::mapRow
				);
	}
	
	private Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setId(rs.getInt("id"));
		cliente.setNome(rs.getString("nome"));
		cliente.setEmail(rs.getString("email"));
		
		return cliente;
	}

	@Override
	public Cliente save(Cliente cliente) {
		throw new UnsupportedOperationException();
	}

}
