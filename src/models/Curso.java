package models;

import java.util.ArrayList;
import java.util.List;

import models.situacao.Situacao;
import models.situacao.SituacaoEmAndamento;

public class Curso extends Produto implements Prototipo {
	
	private List<Disciplina> disciplinas;
	private List<Livro> livros;
	private Situacao situacao;

	public Curso(String codigo, String nome, double preco) {
		super(codigo, nome, preco);
		this.disciplinas = new ArrayList<>();
		this.livros = new ArrayList<>();
		this.situacao = new SituacaoEmAndamento();
	}
	
	public void addDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
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
	
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	public void avancar(String codigoDisciplina, double porcentagem) {
		this.situacao.avancar(codigoDisciplina, porcentagem, this);
	}
	
	public void checkpoint(String codigoDisciplina) {
		this.situacao.checkPoint(codigoDisciplina, this);
	}
	
	public void restore(String codigoDisciplina) {
		this.situacao.restore(codigoDisciplina, this);
	}
	
	public void certificado() {
		this.situacao.certificado(this);
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
