package models.situacao;

import models.Curso;

public class SituacaoSuspenso extends Situacao {
	
	@Override
	public void checkPoint(Curso curso) {
		this.checks.add(curso.createSnapShot());
	}
	
	@Override
	public void restore() {
		this.checks.pop().restore();
	}

}
