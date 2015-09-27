package almoxarifadoSetor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import estoque.Estoque;
import setor.Setor;

@Entity(name="almoxarifadoSetor")
public class AlmoxarifadoSetor {
	
	@Id
	private int idAlmoxarifadoSetor;
	
	@ManyToOne
	@JoinColumn(name="idEstoque")
	private Estoque estoque;
	
	@ManyToOne
	@JoinColumn(name="idSetor")
	private Setor setor;
	
	private String descricao;
	
	
	public int getIdAlmoxarifadoSetor() {
		return idAlmoxarifadoSetor;
	}
	public void setIdAlmoxarifadoSetor(int idAlmoxarifadoSetor) {
		this.idAlmoxarifadoSetor = idAlmoxarifadoSetor;
	}
	
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	
	
	
	

}
