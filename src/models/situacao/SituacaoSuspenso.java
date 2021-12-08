package models.situacao;

import models.Curso;

public class SituacaoSuspenso extends Situacao {
	
	public void restore(Curso curso) {
		throw new SituacaoException("Não é possível restaurar o curso");
	}

}
