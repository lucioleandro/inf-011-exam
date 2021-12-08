package models.situacao;

public class SituacaoConcluido extends Situacao {

	public void avancar() {
		throw new SituacaoException("O curso não pode ser avançado");
	}
	
	public void checkPoint() {
		throw new SituacaoException("Não é possível fazer checkpoint do curso");
	}
	
	public void restore() {
		throw new SituacaoException("Não é possível restaurar o curso");
	}
}
