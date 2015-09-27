package setor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import obra.Obra;
import obra.ObraFacade;
import util.DefaultMB;
import almoxarifadoSetor.AlmoxarifadoSetor;


@SessionScoped
@ManagedBean(name="setorMB")
public class SetorController extends DefaultMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ObraFacade obraFacade;
	private List<Obra> obras;
	private Setor setor;
	private AlmoxarifadoSetor almoxarifado;
	private ListDataModel<AlmoxarifadoSetor> listaAlmoxarifado;
	private ListDataModel<Setor> listaSetor;
	private SetorFacade setorFacade;
	private boolean btnEditarSetor;
	
	@PostConstruct
	public void init(){
		setor = new Setor();
		setor.setObra(new Obra());
		
		almoxarifado = new AlmoxarifadoSetor();
		listaAlmoxarifado = new ListDataModel<AlmoxarifadoSetor>();
		listaSetor = new ListDataModel<Setor>();
		setorFacade = new SetorFacade();
		btnEditarSetor = false;
		obraFacade = new ObraFacade();
		obras = new ArrayList<Obra>();
		
		obras = obraFacade.listarObra();
		listarSetor();
		
	}
	
	public String listarSetor(){
		
		listaSetor  = new ListDataModel<Setor>(setorFacade.listarSetor());
		
		return "";
	}
	
	public String insertSetor(){
		
		if(isSetorPreenchida() == false)
			return "";
		
		if(setorFacade.insertSetor(setor)){
			registrarMensagemInfo("","Setor Cadastrada com sucesso!");
		}else{
			registrarMensagemErro("","Erro ao cadastrar a setor!");
		}
		
		init();
		return "";
	}
	
	public String excluirSetor(){
		if(setorFacade.excluirSetor(listaSetor.getRowData())){
			registrarMensagemInfo("","Setor Excluída com sucesso");
		}else{
			registrarMensagemErro("","Não é possível excluir a Setor. Esta setor está associada com um produto!");
		}
		init();
		return "";
	}
	
	public String alterarSetorInit(){
		btnEditarSetor = true;
		setor = listaSetor.getRowData();
		
		return "";
	}
	
	public String alterarSetor(){
		
		if(isSetorPreenchida() == false)
			return "";
		
		if(setorFacade.alterarSetor(setor)){
			registrarMensagemInfo("","Setor editada com sucesso");
		}else{
			registrarMensagemErro("","Erro!");
		}
		init();
		return "";
	}
	
	public boolean isSetorPreenchida(){
		boolean retorno = true;
		if(setor.getDescricao() == null || setor.getDescricao().length() == 0){
			registrarMensagemErro("Você precisa preencher a descrição da setor");
			retorno = false;
		}
		
		return retorno;
	}
	
	/*
	 * Getters
	 * and
	 * Setters
	 * */

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public ListDataModel<Setor> getListaSetor() {
		return listaSetor;
	}

	public void setListaSetor(ListDataModel<Setor> listaSetor) {
		this.listaSetor = listaSetor;
	}

	public boolean isBtnEditarSetor() {
		return btnEditarSetor;
	}

	public void setBtnEditarSetor(boolean btnEditarSetor) {
		this.btnEditarSetor = btnEditarSetor;
	}

	public AlmoxarifadoSetor getAlmoxarifado() {
		return almoxarifado;
	}

	public void setAlmoxarifado(AlmoxarifadoSetor almoxarifado) {
		this.almoxarifado = almoxarifado;
	}

	public ListDataModel<AlmoxarifadoSetor> getListaAlmoxarifado() {
		return listaAlmoxarifado;
	}

	public void setListaAlmoxarifado(
			ListDataModel<AlmoxarifadoSetor> listaAlmoxarifado) {
		this.listaAlmoxarifado = listaAlmoxarifado;
	}

	public SetorFacade getSetorFacade() {
		return setorFacade;
	}

	public void setSetorFacade(SetorFacade setorFacade) {
		this.setorFacade = setorFacade;
	}

	public List<Obra> getObras() {
		return obras;
	}

	public void setObras(List<Obra> obras) {
		this.obras = obras;
	}
	

	
	
}
