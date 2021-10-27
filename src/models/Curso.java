package models;

import java.util.ArrayList;
import java.util.List;

public class Curso extends Produto {
	
	private List<Disciplina> disciplinas;
	private List<Livro> livros;

	public Curso(String codigo, double produto) {
		super(codigo, produto);
		this.disciplinas = new ArrayList<>();
		this.livros = new ArrayList<>();
	}

	@Override
	public double getPreco() {
		return 0;
	}
	
	public void addDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}
	
	public void addLivro(Livro livro) {
		this.livros.add(livro);
	}

}
