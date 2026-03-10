package edu.ifsp.loja.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.ifsp.loja.modelo.Produto;

@Repository
public class ProdutoRepositorioJdbc implements ProdutoRepositorio{
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Produto findById(int id) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public Iterable<Produto> findAll() {
		return jdbc.query(
				"SELECT id, descricao, preco FROM produto", 
				this::mapRow
				);
	}
	
	private Produto mapRow(ResultSet rs, int rowNum) throws SQLException {
		Produto produto = new Produto();
		produto.setId(rs.getInt("id"));
		produto.setDescricao(rs.getString("descricao"));
		produto.setPreco(rs.getDouble("preco"));
		
		return produto;
	}
	
	@Override
	public Produto save(Produto produto) {
		throw new UnsupportedOperationException();
	}

	
}
