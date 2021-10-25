package models;

public abstract class Produto {
	
	private String codigo;
	private String preco;
	
	public Produto(String codigo, String produto) {
		this.codigo = codigo;
		this.preco = produto;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public abstract double getPreco();

}
