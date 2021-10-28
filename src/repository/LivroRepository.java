package repository;

import java.util.ArrayList;
import java.util.List;

import models.Livro;

public class LivroRepository {
	
	private List<Livro> livros;
	
	public LivroRepository() {
		this.livros = new ArrayList<>();
	}
	public void create(Livro livro) {
		this.livros.add(livro);
	}
	
	public List<Livro> findAll() {
		return this.livros;
	}

}
