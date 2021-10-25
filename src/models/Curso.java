package models;

import java.util.ArrayList;
import java.util.List;

public class Curso extends Produto {
	
	private List<Disciplina> disciplinas;
	private List<Livro> livros;

	public Curso(String codigo, String produto) {
		super(codigo, produto);
		this.disciplinas = new ArrayList<>();
		this.livros = new ArrayList<>();
	}

	@Override
	public double getPreco() {
		return 0;
	}

}
