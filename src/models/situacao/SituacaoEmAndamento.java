package models.situacao;

public class SituacaoEmAndamento extends Situacao {

	public void certificado() {
		throw new SituacaoException("Não é possível pegar o certificado do curso");
	}
	
}
