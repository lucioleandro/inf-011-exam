package models;

public class Livro extends Produto {
	
	private String isbn;

	public Livro(String codigo, double preco) {
		super(codigo, preco);
	}
	
	public Livro(String codigo, double preco, String isbn) {
		super(codigo, preco);
		this.isbn = isbn;
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
		return "Livro [isbn=" + isbn + ", codigo=" + codigo + ", preco=" + preco + "]";
	}

	

}
