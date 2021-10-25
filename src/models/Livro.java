package models;

public class Livro extends Produto {
	
	private String isbn;

	public Livro(String codigo, String produto, String isbn) {
		super(codigo, produto);
		this.isbn = isbn;
	}
	
	public String getIsbn() {
		return isbn;
	}

	@Override
	public double getPreco() {
		return 0;
	}

}
