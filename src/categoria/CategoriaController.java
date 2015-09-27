package categoria;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import util.DefaultMB;


@SessionScoped
@ManagedBean(name="categoriaMB")
public class CategoriaController extends DefaultMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Categoria categoria;
	private ListDataModel<Categoria> listaCategoria;
	private CategoriaFacade categoriaFacade;
	private boolean btnEditarCategoria;
	
	@PostConstruct
	public void init(){
		
		categoria = new Categoria();
		listaCategoria = new ListDataModel<Categoria>();
		categoriaFacade = new CategoriaFacade();
		btnEditarCategoria = false;
		
		listarCategoria();
		
	}
	
	public String listarCategoria(){
		
		listaCategoria  = new ListDataModel<Categoria>(categoriaFacade.listarCategoria());
		
		return "";
	}
	
	public String insertCategoria(){
		
		if(isCategoriaPreenchida() == false)
			return "";
		
		if(categoriaFacade.insertCategoria(categoria)){
			registrarMensagemInfo("","Categoria Cadastrada com sucesso!");
		}else{
			registrarMensagemErro("","Erro ao cadastrar a categoria!");
		}
		
		init();
		return "";
	}
	
	public String excluirCategoria(){
		if(categoriaFacade.excluirCategoria(listaCategoria.getRowData())){
			registrarMensagemInfo("","Categoria Excluída com sucesso");
		}else{
			registrarMensagemErro("","Não é possível excluir a Categoria. Esta categoria está associada com um produto!");
		}
		init();
		return "";
	}
	
	public String alterarCategoriaInit(){
		btnEditarCategoria = true;
		categoria = listaCategoria.getRowData();
		
		return "";
	}
	
	public String alterarCategoria(){
		
		if(isCategoriaPreenchida() == false)
			return "";
		
		if(categoriaFacade.alterarCategoria(categoria)){
			registrarMensagemInfo("","Categoria editada com sucesso");
		}else{
			registrarMensagemErro("","Erro!");
		}
		init();
		return "";
	}
	
	public boolean isCategoriaPreenchida(){
		boolean retorno = true;
		if(categoria.getDescricao() == null || categoria.getDescricao().length() == 0){
			registrarMensagemErro("Você precisa preencher a descrição da categoria");
			retorno = false;
		}
		
		return retorno;
	}
	
	/*
	 * Getters
	 * and
	 * Setters
	 * */

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public ListDataModel<Categoria> getListaCategoria() {
		return listaCategoria;
	}

	public void setListaCategoria(ListDataModel<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}

	public boolean isBtnEditarCategoria() {
		return btnEditarCategoria;
	}

	public void setBtnEditarCategoria(boolean btnEditarCategoria) {
		this.btnEditarCategoria = btnEditarCategoria;
	}

	
	

}
