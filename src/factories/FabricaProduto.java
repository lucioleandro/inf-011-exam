package factories;

import models.Produto;

public interface FabricaProduto {
	Produto criaProduto(String codigo, String nome, double preco);
}
