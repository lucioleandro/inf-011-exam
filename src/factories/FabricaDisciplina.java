package factories;

import models.Disciplina;
import models.Produto;

public class FabricaDisciplina implements FabricaProduto {

	@Override
	public Produto criaProduto(String codigo, String nome, double preco) {
		return new Disciplina(codigo, nome,  preco);
	}

}
