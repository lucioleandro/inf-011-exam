package factories;

import models.Produto;

public interface FabricaProduto {
	Produto criaProduto(String codigo, double preco);
}
