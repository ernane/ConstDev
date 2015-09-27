package obra;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import util.DefaultMB;


@SessionScoped
@ManagedBean(name="obraMB")
public class ObraController extends DefaultMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Obra obra;
	private ListDataModel<Obra> listaObra;
	private ObraFacade obraFacade;
	private boolean btnEditarObra;
	
	@PostConstruct
	public void init(){
		
		obra = new Obra();
		listaObra = new ListDataModel<Obra>();
		obraFacade = new ObraFacade();
		btnEditarObra = false;
		
		listarObra();
		
	}
	
	public String listarObra(){
		
		listaObra  = new ListDataModel<Obra>(obraFacade.listarObra());
		
		return "";
	}
	
	public String insertObra(){
		
		if(isObraPreenchida() == false)
			return "";
		
		obra.setDataCadastro(new Date());
		if(obraFacade.insertObra(obra)){
			registrarMensagemInfo("","Obra Cadastrada com sucesso!");
		}else{
			registrarMensagemErro("","Erro ao cadastrar a obra!");
		}
		
		init();
		return "";
	}
	
	public String excluirObra(){
		if(obraFacade.excluirObra(listaObra.getRowData())){
			registrarMensagemInfo("","Obra Excluída com sucesso");
		}else{
			registrarMensagemErro("","Não é possível excluir a Obra. Esta obra está associada com um produto!");
		}
		init();
		return "";
	}
	
	public String alterarObraInit(){
		btnEditarObra = true;
		obra = listaObra.getRowData();
		
		return "";
	}
	
	public String alterarObra(){
		
		if(isObraPreenchida() == false)
			return "";
		
		if(obraFacade.alterarObra(obra)){
			registrarMensagemInfo("","Obra editada com sucesso");
		}else{
			registrarMensagemErro("","Erro!");
		}
		init();
		return "";
	}
	
	public boolean isObraPreenchida(){
		boolean retorno = true;
		if(obra.getDescricao() == null || obra.getDescricao().length() == 0){
			registrarMensagemErro("Você precisa preencher a descrição da obra");
			retorno = false;
		}
		
		return retorno;
	}
	
	/*
	 * Getters
	 * and
	 * Setters
	 * */

	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	public ListDataModel<Obra> getListaObra() {
		return listaObra;
	}

	public void setListaObra(ListDataModel<Obra> listaObra) {
		this.listaObra = listaObra;
	}

	public boolean isBtnEditarObra() {
		return btnEditarObra;
	}

	public void setBtnEditarObra(boolean btnEditarObra) {
		this.btnEditarObra = btnEditarObra;
	}

	
	

}
