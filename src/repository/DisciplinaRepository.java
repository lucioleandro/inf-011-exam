package repository;

import java.util.ArrayList;
import java.util.List;

import models.Disciplina;

public class DisciplinaRepository {
	
	private static DisciplinaRepository repository;
	
	private List<Disciplina> disciplinas;
	
	private DisciplinaRepository() {
		this.disciplinas = new ArrayList<>();
		Disciplina disciplina1 = new Disciplina("555", "Padrões de Projetos", 50.0);
		disciplina1.setChTotal(90);
		Disciplina disciplina2 = new Disciplina("667", "Orientação a Objetos", 60.0);
		disciplina2.setChTotal(60);
		
		create(disciplina1);
		create(disciplina2);
	}
	
	public static DisciplinaRepository getInstance() {
		if(repository == null) {
			repository = new DisciplinaRepository();
			return repository;
		}
		return repository;
	}
	
	public void create(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}
	
	public List<Disciplina> findAll() {
		return this.disciplinas;
	}

	public Disciplina findByCodigo(String codigo) {
		Disciplina disciplina = null;
		for(Disciplina dis: this.disciplinas) {
			if(dis.getCodigo().equals(codigo)) {
				disciplina = dis;
				break;
			}
		}
		return disciplina;
	}

}
