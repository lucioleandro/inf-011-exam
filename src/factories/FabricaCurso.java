package factories;

import models.Curso;
import models.Produto;

public class FabricaCurso implements FabricaProduto {

	@Override
	public Produto criaProduto(String codigo, String nome, double preco) {
		return new Curso(codigo, nome, preco);
	}

}
