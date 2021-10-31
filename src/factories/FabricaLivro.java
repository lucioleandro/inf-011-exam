package factories;

import models.Livro;
import models.Produto;

public class FabricaLivro implements FabricaProduto {

	public Produto criaProduto(String codigo, String nome, double preco) {
		return new Livro(codigo, nome, preco);
	}

}
