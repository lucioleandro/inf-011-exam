package models.strategy;

import models.Curso;

public abstract class EnviadoraBase implements EnviadoraStatusCurso {

	public void montaEEnviaMensagem(Curso curso) {
		String mensagem = "Seu curso teve uma modificação: " + curso.toString();
		envia(mensagem);
	}
	
}
