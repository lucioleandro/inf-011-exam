package factories;

import models.Disciplina;
import models.Produto;

public class FabricaDisciplina implements FabricaProduto {

	@Override
	public Produto criaProduto(String codigo, double preco) {
		return new Disciplina(codigo, preco);
	}

}
