package repository;

import java.util.ArrayList;
import java.util.List;

import models.Livro;

public class LivroRepository {
	
	private static LivroRepository repository;
	
	private List<Livro> livros;
	
	private LivroRepository() {
		this.livros = new ArrayList<>();
		Livro livro1 = new Livro("789", "Algoritmos do Corman", 100.0);
		livro1.setIsbn("hauahuah-hauahuaha");
		Livro livro2 = new Livro("789", "Padrões de projeto", 100.0);
		livro2.setIsbn("hauahuah-tyrtrtrtr");
		create(livro1);
		create(livro2);
	}
	
	public static LivroRepository getInstance() {
		if(repository == null ) {
			repository = new LivroRepository();
			return repository;
		}
		return repository;
	}
	public void create(Livro livro) {
		this.livros.add(livro);
	}
	
	public List<Livro> findAll() {
		return this.livros;
	}
	public Livro findByCodigo(String codigo) {
		Livro livro = null;
		for(Livro liv : this.livros) {
			if(liv.getCodigo().equals(codigo)) {
				livro = liv;
				break;
			}
		}
		return livro;
	}

}
