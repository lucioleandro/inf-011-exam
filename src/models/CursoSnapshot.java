package models;

import java.util.List;

import models.situacao.Situacao;

public class CursoSnapshot {
	
	private Curso curso;
	private List<Disciplina> disciplinas;
	private List<Livro> livros;
	private Situacao situacao;
	
	public CursoSnapshot(Curso curso, List<Disciplina> disciplinas, List<Livro> livros, Situacao situacao) {
		this.curso = curso;
		this.disciplinas = disciplinas;
		this.livros = livros;
		this.situacao = situacao;
	}

	public void restore() {
		this.curso.setDisciplinas(disciplinas);
		this.curso.setLivros(livros);
		this.curso.setSituacao(situacao);
	}
	
}
