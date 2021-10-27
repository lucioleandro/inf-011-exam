package models;

import java.util.ArrayList;
import java.util.List;

import enums.ProdutosEnum;
import factories.FabricaCurso;
import factories.FabricaDisciplina;
import factories.FabricaLivro;

public class App {
	
	List<Curso> cursos;
	List<Disciplina> disciplinas;
	List<Livro> livros;
	
	public App() {
		this.cursos = new ArrayList<>();
		this.disciplinas = new ArrayList<>();
		this.livros = new ArrayList<>();
	}
	
	public Produto criarProduto(ProdutosEnum tipoProduto, String codigo, double preco) {
		if(ProdutosEnum.LIVRO.equals(tipoProduto)) {
			return new FabricaLivro().criaProduto(codigo, preco);
		} else if(ProdutosEnum.DISCIPLINA.equals(tipoProduto)) {
			return new FabricaDisciplina().criaProduto(codigo, preco);
		} else { // Poderia ser só um else, mas vou me defender
			return new FabricaCurso().criaProduto(codigo, preco);
		}
	}
	
	
	
}
