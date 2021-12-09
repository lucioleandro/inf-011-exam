package models.observer;

import models.Curso;
import models.strategy.EnviadoraBase;
import models.strategy.EnviadoraStatusCurso;

public class Aluno implements  Listener {
	
	private String nome;
	private EnviadoraStatusCurso enviadora;
	

	public Aluno(String nome, EnviadoraStatusCurso enviadora) {
		this.nome = nome;
		this.enviadora = enviadora;
	}


	public void aviseMe(Curso curso) {
		((EnviadoraBase) this.enviadora).montaEEnviaMensagem(curso);
	}

}
