package models.observer;

import models.Curso;
import models.strategy.EnviadoraStatusCurso;

public class Aluno implements Listener {
	
	private String nome;
	private String email;
	private EnviadoraStatusCurso enviadora;
	

	public Aluno(String nome, String email, EnviadoraStatusCurso enviadora) {
		this.nome = nome;
		this.enviadora = enviadora;
		this.email = email;
	}

	@Override
	public String getNome() {
		return nome;
	}
	
	@Override
	public String getEmail() {
		return email;
	}
	
	@Override
	public void aviseMe(Curso curso) {
		this.enviadora.montaEEnviaMensagem(curso, this);
	}

}
