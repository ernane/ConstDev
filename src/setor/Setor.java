package setor;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import obra.Obra;
import almoxarifadoSetor.AlmoxarifadoSetor;

@Entity(name="setor")
public class Setor {
	
	@Id
	@Column(name="idsetor")
	private int idSetor;
	
	@ManyToOne
	@JoinColumn(name="idobra")
	private Obra obra;
	
	@OneToMany(mappedBy="idAlmoxarifadoSetor")
	private List<AlmoxarifadoSetor> almoxarifados;
	
	private String descricao;
	
	
	public List<AlmoxarifadoSetor> getAlmoxarifados() {
		return almoxarifados;
	}
	public void setAlmoxarifados(List<AlmoxarifadoSetor> almoxarifados) {
		this.almoxarifados = almoxarifados;
	}
	public int getIdSetor() {
		return idSetor;
	}
	public void setIdSetor(int idSetor) {
		this.idSetor = idSetor;
	}
	public Obra getObra() {
		return obra;
	}
	public void setObra(Obra obra) {
		this.obra = obra;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
