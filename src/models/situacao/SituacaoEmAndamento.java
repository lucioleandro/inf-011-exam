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
	public void checkPoint(String codigoDisciplina, Curso curso) {
		throw new SituacaoException("Não é possível fazer checkpoint do curso");
	}
	
	@Override
	public void restore(String codigoDisciplina, Curso curso) {
		throw new SituacaoException("Não é possível restaurar o curso");
	}

}
