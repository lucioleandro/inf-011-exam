package repository;

import java.util.ArrayList;
import java.util.List;

import models.Curso;

public class CursoRepository {
	
	private List<Curso> cursos;
	private List<Curso> prototipos;
	
	public CursoRepository() {
		this.cursos = new ArrayList<>();
		this.prototipos = new ArrayList<>();
	}
	
	public void criaERegistraPrototipo(Curso curso) {
		this.cursos.add(curso);
		this.prototipos.add(curso);
	}
	
	public List<Curso> findAll() {
		return this.cursos;
	}
	
	public List<Curso> findAllPrototipos() {
		return this.cursos;
	}

}
