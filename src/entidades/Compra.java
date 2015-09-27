package entidades;

import java.util.Date;

import estoque.Estoque;

public class Compra {

	private int idCompra;
	private Date dataCompra;
	private Date dataAutorizacao;
	private double valorCompra;
	private int formaPagamento;
	private Usuario idUsuarioCompra;
	private Usuario idUsuarioAutorizacao;
	private int statusCompra;
	private Estoque estoque;
	private Fornecedor fornecedor;
	public int getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public Date getDataAutorizacao() {
		return dataAutorizacao;
	}
	public void setDataAutorizacao(Date dataAutorizacao) {
		this.dataAutorizacao = dataAutorizacao;
	}
	public double getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}
	public int getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(int formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public Usuario getIdUsuarioCompra() {
		return idUsuarioCompra;
	}
	public void setIdUsuarioCompra(Usuario idUsuarioCompra) {
		this.idUsuarioCompra = idUsuarioCompra;
	}
	public Usuario getIdUsuarioAutorizacao() {
		return idUsuarioAutorizacao;
	}
	public void setIdUsuarioAutorizacao(Usuario idUsuarioAutorizacao) {
		this.idUsuarioAutorizacao = idUsuarioAutorizacao;
	}
	public int getStatusCompra() {
		return statusCompra;
	}
	public void setStatusCompra(int statusCompra) {
		this.statusCompra = statusCompra;
	}
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	
	
}
