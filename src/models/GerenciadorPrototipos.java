package models;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorPrototipos {
	
	private static GerenciadorPrototipos gerenciador = null;
	
	private List<Curso> prototiposCurso;
	
	private GerenciadorPrototipos() {
		this.prototiposCurso = new ArrayList<>();
	}
	
	public static GerenciadorPrototipos getInstance() {
		if(gerenciador == null) {
			gerenciador = new GerenciadorPrototipos();
			return gerenciador;
		}
		return gerenciador;
	}
	
	public void add(Prototipo prototipo) {
		this.prototiposCurso.add((Curso) prototipo);
	}
	
	public List<Curso>findAll() {
		return this.prototiposCurso;
	}
	
	public Prototipo getByName(String nome) {
		Curso curso = null;
		for(Curso cur: this.prototiposCurso) {
			if(cur == null) {
				curso = cur;
				break;
			}
		}
		return curso;
	}

}
