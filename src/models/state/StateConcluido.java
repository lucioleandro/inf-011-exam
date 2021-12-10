package models.state;

import models.Curso;

public class StateConcluido extends State {

	@Override
	public void certificado(Curso curso) {
		if(curso.getPctCumprido() == 100.0) {
			emiteCertificado(curso);
		}
		System.out.println("O aluno completou o curso todo");
	}

	private void emiteCertificado(Curso curso) {
		System.out.println("O aluno completou o curso todo");
	}
}
