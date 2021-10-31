package models;

public abstract class Produto {
	
	protected String codigo;
	protected double preco;
	
	public Produto(String codigo, double produto) {
		this.codigo = codigo;
		this.preco = produto;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public abstract double getPreco();
	
}
