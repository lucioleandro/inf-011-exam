package models.situacao;

import models.Curso;

public class SituacaoEmAndamento extends Situacao {

	public void certificado(Curso curso) {
		throw new SituacaoException("Não é possível pegar o certificado do curso");
	}
	
}
