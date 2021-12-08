package models.situacao;

import models.Curso;

public class SituacaoSuspenso extends Situacao {
	
	@Override
	public void checkPoint(String codigoDisciplina, Curso curso) {
		throw new SituacaoException("Não é possível fazer checkpoint do curso");
	}
	
	@Override
	public void restore(String codigoDisciplina, Curso curso) {
		throw new SituacaoException("Não é possível restaurar o curso");
	}

}
