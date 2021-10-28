package repository;

import java.util.ArrayList;
import java.util.List;

import models.Curso;

public class CursoRepository {
	
	private List<Curso> cursos;
	
	public CursoRepository() {
		this.cursos = new ArrayList<>();
	}
	
	public void create(Curso curso) {
		this.cursos.add(curso);
	}
	
	public List<Curso> findAll() {
		return this.cursos;
	}

}
