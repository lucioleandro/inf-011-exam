package factories;

import models.Livro;
import models.Produto;

public class FabricaLivro implements FabricaProduto {

	public Produto criaProduto(String codigo, double preco) {
		return new Livro(codigo, preco);
	}


}
