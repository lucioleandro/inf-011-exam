package models.situacao;

import models.Curso;

public class SituacaoConcluido extends Situacao {

	@Override
	public void certificado(Curso curso) {
		System.out.println("O aluno completou o curso todo");
	}
}
