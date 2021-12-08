package models;

import java.util.ArrayList;
import java.util.List;

import models.situacao.Situacao;

public class Curso extends Produto implements Prototipo {
	
	private Situacao situacao;
	
	private List<Disciplina> disciplinas;
	private List<Livro> livros;

	public Curso(String codigo, String nome, double preco) {
		super(codigo, nome, preco);
		this.disciplinas = new ArrayList<>();
		this.livros = new ArrayList<>();
	}

	public void addDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}
	
	public void addLivro(Livro livro) {
		this.livros.add(livro);
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
