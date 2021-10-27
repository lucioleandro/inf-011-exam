package factories;

import models.Curso;
import models.Produto;

public class FabricaCurso implements FabricaProduto {

	@Override
	public Produto criaProduto(String codigo, double preco) {
		return new Curso(codigo, preco);
	}

}
