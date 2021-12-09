package models.strategy;

public class EnviadoraPorEmail extends EnviadoraBase {

	@Override
	public void envia(String mensagem) {
		System.out.println("Enviando mensagem por email: " + mensagem);
	}


}
