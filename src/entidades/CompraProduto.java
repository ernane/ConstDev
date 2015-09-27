package entidades;

import produto.Produto;

public class CompraProduto {
	
	private int idCompraProduto;
	private Produto produto;
	private Compra compra;
	private int quantidade;
	private double precoUnitario;
	public int getIdCompraProduto() {
		return idCompraProduto;
	}
	public void setIdCompraProduto(int idCompraProduto) {
		this.idCompraProduto = idCompraProduto;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	
	

}
