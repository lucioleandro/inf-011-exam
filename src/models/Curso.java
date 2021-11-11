package models;

import java.util.ArrayList;
import java.util.List;

public class Curso extends Produto implements Cloneable {
	
	private List<Disciplina> disciplinas;
	private List<Livro> livros;

	public Curso(String codigo, String nome, double produto) {
		super(codigo, nome, produto);
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
	public Produto cloneable() {
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
