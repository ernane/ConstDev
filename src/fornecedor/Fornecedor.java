package fornecedor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "fornecedor")
public class Fornecedor {

	@Id
	@Column(name = "idfornecedor")
	private int idFornecedor;

	private String nome;
	private String descricao;
	private String cnpj;

	public int getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
