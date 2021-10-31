package models;

public class Livro extends Produto {
	
	private String isbn;

	public Livro(String codigo,String nome, double preco) {
		super(codigo, nome, preco);
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public double getPreco() {
		return 0;
	}

	@Override
	public String toString() {
		return "Livro: " + nome + "\n[isbn=" + isbn + "\n codigo=" + codigo + "\n preco=" + preco + "]";
	}

	

}
