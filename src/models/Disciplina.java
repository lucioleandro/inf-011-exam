package models;

public class Disciplina extends Produto {
	
	private int chTotal;
	private double pctCumprido;

	public Disciplina(String codigo, double preco) {
		super(codigo, preco);
	}

	public int getChTotal() {
		return chTotal;
	}
	
	public void setChTotal(int chTotal) {
		this.chTotal = chTotal;
	}

	public double getPctCumprido() {
		return pctCumprido;
	}
	
	public void setPctCumprido(double pctCumprido) {
		this.pctCumprido = pctCumprido;
	}

	@Override
	public double getPreco() {
		return 0;
	}

}
