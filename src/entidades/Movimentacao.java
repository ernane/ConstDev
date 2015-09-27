package entidades;

import java.util.Date;

import almoxarifadoSetor.AlmoxarifadoSetor;

public class Movimentacao {
	
	private int idMovimentacao;
	private Usuario usuarioSaida;
	private Usuario usuarioEntrada;
	private AlmoxarifadoSetor almoxarifadoSetorSaida;
	private AlmoxarifadoSetor almoxarifadoSetorEntrada;
	private Date dataSaida;
	private Date dataEntrada;
	private int statusMovimentacao;
	
	public int getIdMovimentacao() {
		return idMovimentacao;
	}
	public void setIdMovimentacao(int idMovimentacao) {
		this.idMovimentacao = idMovimentacao;
	}
	public Usuario getUsuarioSaida() {
		return usuarioSaida;
	}
	public void setUsuarioSaida(Usuario usuarioSaida) {
		this.usuarioSaida = usuarioSaida;
	}
	public Usuario getUsuarioEntrada() {
		return usuarioEntrada;
	}
	public void setUsuarioEntrada(Usuario usuarioEntrada) {
		this.usuarioEntrada = usuarioEntrada;
	}
	public AlmoxarifadoSetor getAlmoxarifadoSetorSaida() {
		return almoxarifadoSetorSaida;
	}
	public void setAlmoxarifadoSetorSaida(AlmoxarifadoSetor almoxarifadoSetorSaida) {
		this.almoxarifadoSetorSaida = almoxarifadoSetorSaida;
	}
	public AlmoxarifadoSetor getAlmoxarifadoSetorEntrada() {
		return almoxarifadoSetorEntrada;
	}
	public void setAlmoxarifadoSetorEntrada(
			AlmoxarifadoSetor almoxarifadoSetorEntrada) {
		this.almoxarifadoSetorEntrada = almoxarifadoSetorEntrada;
	}
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public int getStatusMovimentacao() {
		return statusMovimentacao;
	}
	public void setStatusMovimentacao(int statusMovimentacao) {
		this.statusMovimentacao = statusMovimentacao;
	}
	
	

}
