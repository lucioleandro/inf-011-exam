package models;

public class Disciplina extends Produto {
	
	private int chTotal;
	private double pctCumprido;

	public Disciplina(String codigo, String produto, int chTotal, double pctCumprido) {
		super(codigo, produto);
		this.chTotal = chTotal;
		this.pctCumprido = pctCumprido;
	}

	public int getChTotal() {
		return chTotal;
	}

	public double getPctCumprido() {
		return pctCumprido;
	}

	@Override
	public double getPreco() {
		return 0;
	}

}
