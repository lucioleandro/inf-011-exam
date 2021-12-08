package models.situacao;

import models.Curso;

public class SituacaoConcluido extends Situacao {

	public void avancar(Curso curso) {
		throw new SituacaoException("O curso não pode ser avançado");
	}
	
	public void checkPoint(Curso curso) {
		throw new SituacaoException("Não é possível fazer checkpoint do curso");
	}
	
	public void restore(Curso curso) {
		throw new SituacaoException("Não é possível restaurar o curso");
	}
}
