package models.situacao;

public class SituacaoSuspenso extends Situacao {
	
	public void restore() {
		throw new SituacaoException("Não é possível restaurar o curso");
	}

}
