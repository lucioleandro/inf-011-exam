package models;

public class Livro extends Produto {
	
	private String isbn;

	public Livro(String codigo, double preco) {
		super(codigo, preco);
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

}
