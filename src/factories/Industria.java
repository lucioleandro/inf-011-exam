package factories;

import enums.ProdutosEnum;
import models.Produto;

public class Industria {

	public static Produto criaProduto(ProdutosEnum tipo, String nome, String codigo, double preco) {
		if(ProdutosEnum.LIVRO.equals(tipo)) {
			return new FabricaLivro().criaProduto(codigo,nome, preco);
		} 
		else if(ProdutosEnum.DISCIPLINA.equals(tipo)) {
			return new FabricaDisciplina().criaProduto(codigo, nome, preco);
		}
		else {
			return new FabricaCurso().criaProduto(codigo, nome, preco);
		}
	}
}
