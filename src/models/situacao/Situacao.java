package models.situacao;

public abstract class Situacao {
	
	public void avancar() {
		throw new SituacaoException("O curso não pode ser avançado");
	}
	
	public void checkPoint() {
		throw new SituacaoException("Não é possível fazer checkpoint do curso");
	}
	
	public void restore() {
		throw new SituacaoException("Não é possível restaurar o curso");
	}
	
	public void certificado() {
		throw new SituacaoException("Não é possível pegar o certificado do curso");
	}

}
