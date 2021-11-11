package repository;

import java.util.ArrayList;
import java.util.List;

import models.Curso;
import models.GerenciadorPrototipos;

public class CursoRepository {
	
	private List<Curso> cursos;
	private GerenciadorPrototipos gerenciadorPrototipos;
	
	public CursoRepository() {
		this.cursos = new ArrayList<>();
		this.gerenciadorPrototipos = GerenciadorPrototipos.getInstance();
	}
	
	public void criaERegistraPrototipo(Curso curso) {
		this.cursos.add(curso);
		this.gerenciadorPrototipos.add(curso);
	}
	
	public void cria(Curso curso) {
		this.cursos.add(curso);
	}
	
	public List<Curso> findAll() {
		return this.cursos;
	}
	
	public List<Curso> findAllPrototipos() {
		return this.cursos;
	}

	public Curso findByNome(String nome) {
		Curso curso = null;
		for(Curso curs: this.cursos) {
			if(curs.getNome().equals(nome)) {
				curso = curs;
				break;
			}
		}
		return curso;
	}

}
