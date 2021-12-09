package models.state;

import models.Curso;

public class StateConcluido extends State {

	@Override
	public void certificado(Curso curso) {
		System.out.println("O aluno completou o curso todo");
	}
}
