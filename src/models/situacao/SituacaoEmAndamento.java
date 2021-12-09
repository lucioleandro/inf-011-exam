package models.situacao;

import models.Curso;
import models.Disciplina;
import models.observer.NotificationManager;

public class SituacaoEmAndamento extends Situacao {
	
	private NotificationManager notificador;
	
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
		this.notificador.notify(curso);
	}
	
	@Override
	public void restore(Curso curso) {
		this.checks.pop().restore();
		this.notificador.notify(curso);
	}

}
