package repository;

import java.util.ArrayList;
import java.util.List;

import models.Disciplina;

public class DisciplinaRepository {
	
	private List<Disciplina> disciplinas;
	
	public DisciplinaRepository() {
		this.disciplinas = new ArrayList<>();
	}
	
	public void create(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}
	
	public List<Disciplina> findAll() {
		return this.disciplinas;
	}

}
