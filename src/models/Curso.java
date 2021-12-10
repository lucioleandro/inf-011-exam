package models;

import java.util.ArrayList;
import java.util.List;

import models.state.State;
import models.state.StateEmAndamento;

public class Curso extends Produto implements Prototipo {
	
	private List<Disciplina> disciplinas;
	private List<Livro> livros;
	private State state;

	public Curso(String codigo, String nome, double preco) {
		super(codigo, nome, preco);
		this.disciplinas = new ArrayList<>();
		this.livros = new ArrayList<>();
		this.state = new StateEmAndamento();
	}
	
	public void addDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}
	
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public Disciplina getDisciplinaByCodigo(String codigo) {
		Disciplina disciplina = null;
		for(Disciplina dis: this.disciplinas) {
			if(dis.getCodigo().equals(codigo)) {
				disciplina = dis;
				break;
			}
		}
		return disciplina;
	}
	
	public void addLivro(Livro livro) {
		this.livros.add(livro);
	}
	
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	public void setSituacao(State situacao) {
		this.state = situacao;
	}
	
	public Situacao createSnapShot() {
		return new Situacao(this, this.disciplinas, this.livros, this.state);
	}
	
	public void avancar(String codigoDisciplina, double porcentagem) {
		this.state.avancar(codigoDisciplina, porcentagem, this);
	}
	
	public void checkpoint() {
		this.state.checkPoint(this);
	}
	
	public void restore() {
		this.state.restore(this);
	}
	
	public void certificado() {
		this.state.certificado(this);
	}

	@Override
	public double getPreco() {
		double preco = 0.0;
		for(Disciplina disciplina: this.disciplinas) {
			preco += disciplina.getPreco();
		}
		for(Livro livro: this.livros) {
			preco += livro.getPreco();
		}
		return preco;
	}
	
	public double getCHTotal() {
		double chTotal = 0.0;
		for(Disciplina disciplina: this.disciplinas) {
			chTotal += disciplina.getChTotal();
		}
		return chTotal;
	}
	
	public double getPctCumprido() {
		double pctCumprido = 0.0;
		for(Disciplina disciplina: this.disciplinas) {
			pctCumprido += disciplina.getPctCumprido();
		}
		return pctCumprido;
	}
	
	@Override
	public Prototipo prototipar() {
		return null;
	}

	@Override
	public String toString() {
		return "{\n"
				+ "Curso: " + nome 
				+  "\n	disciplinas: " + disciplinas 
				+ "\n 	livros: " + livros 
				+ "\n 	codigo: " + codigo
				+ "\n 	preco: " + preco
				+ "\n	cargaHoraria: " + getCHTotal()
				+ "\n	pctCumprido: " + getPctCumprido()
				+ "\n}";
	}

	
	
}
