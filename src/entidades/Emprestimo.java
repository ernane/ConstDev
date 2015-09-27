package entidades;

import java.util.Date;

public class Emprestimo {
	
	private int idEmprestimo;
	private Date dataEmprestimo;
	private Date dataDevolucao;
	private int statusEmprestimo;
	private Usuario usuarioAutorizador;
	private Usuario usuarioEmprestimo;
	public int getIdEmprestimo() {
		return idEmprestimo;
	}
	public void setIdEmprestimo(int idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public int getStatusEmprestimo() {
		return statusEmprestimo;
	}
	public void setStatusEmprestimo(int statusEmprestimo) {
		this.statusEmprestimo = statusEmprestimo;
	}
	public Usuario getUsuarioAutorizador() {
		return usuarioAutorizador;
	}
	public void setUsuarioAutorizador(Usuario usuarioAutorizador) {
		this.usuarioAutorizador = usuarioAutorizador;
	}
	public Usuario getUsuarioEmprestimo() {
		return usuarioEmprestimo;
	}
	public void setUsuarioEmprestimo(Usuario usuarioEmprestimo) {
		this.usuarioEmprestimo = usuarioEmprestimo;
	}
	
	

}
