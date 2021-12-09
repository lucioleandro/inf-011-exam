package models.strategy;

import models.Curso;
import models.observer.Listener;

public abstract class EnviadoraStatusCurso  {

	public void montaEEnviaMensagem(Curso curso, Listener listener) {
		envia(montaMensagem(curso, listener), listener);
	}
	
	private String montaMensagem(Curso curso, Listener listener) {
		return  "Olá " + listener.getNome() + ", seu curso teve uma modificação. COnfira: " 
				+ curso.toString();
	}
	
	public abstract void envia(String mensagem, Listener listener);
	
}
