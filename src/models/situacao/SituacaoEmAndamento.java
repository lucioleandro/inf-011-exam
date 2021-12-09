package models.situacao;

import models.Curso;
import models.Disciplina;

public class SituacaoEmAndamento extends Situacao {
	
	@Override
	public void avancar(String codigoDisciplina, double porcentagem, Curso curso) {
		Disciplina disciplina = curso.getDisciplinaByCodigo(codigoDisciplina);
		if(disciplina != null) {
			disciplina.incrementaPorcentagem(porcentagem);
		}
		if(curso.getPctCumprido() == 100.0) {
			curso.setSituacao(new SituacaoConcluido());
		}
	}
	
	@Override
	public void checkPoint(Curso curso) {
		this.checks.add(curso.createSnapShot());
	}
	
	@Override
	public void restore() {
		this.checks.pop().restore();
	}

}
