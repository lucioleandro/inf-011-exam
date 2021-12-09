package models.state;

import java.util.Stack;

import models.Curso;
import models.CursoSnapshot;

public abstract class State {
	
	protected Stack<CursoSnapshot> checks = new Stack<CursoSnapshot>();
	
	public void avancar(String codigoDisciplina, double porcentagem, Curso curso) {
		throw new StateException("O curso não pode ser avançado");
	}
	
	public void checkPoint(Curso curso) {
		throw new StateException("Não é possível fazer checkpoint do curso");
	}
	
	public void restore(Curso curso) {
		throw new StateException("Não é possível restaurar o curso");
	}
	
	public void certificado(Curso curso) {
		throw new StateException("Não é possível pegar o certificado do curso");
	}

}
