package entidades;

import estoque.Estoque;

public class EmprestimoEstoque {
	
	private int idEmprestimo;
	private int quantidadeEmprestada;
	private Estoque estoqueSaida;
	private Estoque estoqueEmprestada;
	private Emprestimo emprestimo;
	public int getIdEmprestimo() {
		return idEmprestimo;
	}
	public void setIdEmprestimo(int idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}
	public int getQuantidadeEmprestada() {
		return quantidadeEmprestada;
	}
	public void setQuantidadeEmprestada(int quantidadeEmprestada) {
		this.quantidadeEmprestada = quantidadeEmprestada;
	}
	public Estoque getEstoqueSaida() {
		return estoqueSaida;
	}
	public void setEstoqueSaida(Estoque estoqueSaida) {
		this.estoqueSaida = estoqueSaida;
	}
	public Estoque getEstoqueEmprestada() {
		return estoqueEmprestada;
	}
	public void setEstoqueEmprestada(Estoque estoqueEmprestada) {
		this.estoqueEmprestada = estoqueEmprestada;
	}
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}
	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
	
	

}
