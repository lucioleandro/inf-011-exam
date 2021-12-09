package models.strategy;

import models.observer.Listener;

public class EnviadoraPorEmail extends EnviadoraStatusCurso {

	@Override
	public void envia(String mensagem, Listener listener) {
		System.out.println("Recuperando endereço de email do aluno: " + listener.getEmail());
		System.out.println("Setando destinatário: " + listener.getNome());
		System.out.println("Setando assunto: Atualização do curso");
		System.out.println("Setando mensagem: " + mensagem);
		System.out.println("Enviando mensagem por email...");
	}


}
