package produto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import categoria.Categoria;
import categoria.CategoriaFacade;
import util.DefaultMB;


@SessionScoped
@ManagedBean(name="produtoMB")
public class ProdutoController extends DefaultMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Produto produto;
	private ListDataModel<Produto> listaProduto;
	private ProdutoFacade produtoFacade;
	private boolean btnEditarProduto;
	private CategoriaFacade categoriaFacade;
	private List<Categoria> listaCategoria;
	
	@PostConstruct
	public void init(){
		
		produto = new Produto();
		listaCategoria = new ArrayList<Categoria>();
		categoriaFacade = new CategoriaFacade();
		listaProduto = new ListDataModel<Produto>();
		produtoFacade = new ProdutoFacade();
		btnEditarProduto = false;
		
		listaCategoria = categoriaFacade.listarCategoria();
		
		listarProduto();
		produto.setAtivo(true);;
		
	}
	
	public String listarProduto(){
		
		listaProduto  = new ListDataModel<Produto>(produtoFacade.listarProduto());
		
		return "";
	}
	
	public String insertProduto(){
		
		if(isProdutoPreenchida() == false)
			return "";
		
		if(produtoFacade.insertProduto(produto)){
			registrarMensagemInfo("","Produto Cadastrado com sucesso!");
		}else{
			registrarMensagemErro("","Erro ao cadastrar o produto!");
		}
		
		init();
		return "";
	}
	
	public String excluirProduto(){
		if(produtoFacade.excluirProduto(listaProduto.getRowData())){
			registrarMensagemInfo("","Produto Excluído com sucesso");
		}else{
			registrarMensagemErro("","Não é possível excluir o Produto. Esta produto está associado com um produto!");
		}
		init();
		return "";
	}
	
	public String alterarProdutoInit(){
		btnEditarProduto = true;
		produto = listaProduto.getRowData();
		
		return "";
	}
	
	public String alterarProduto(){
		
		if(isProdutoPreenchida() == false)
			return "";
		
		if(produtoFacade.alterarProduto(produto)){
			registrarMensagemInfo("","Produto editado com sucesso");
		}else{
			registrarMensagemErro("","Erro!");
		}
		init();
		return "";
	}
	
	public boolean isProdutoPreenchida(){
		boolean retorno = true;
		if(produto.getNome() == null || produto.getNome().length() == 0){
			registrarMensagemErro("Você precisa preencher o nome do produto");
			retorno = false;
		}
		
		
		return retorno;
	}
	
	/*
	 * Getters
	 * and
	 * Setters
	 * */

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ListDataModel<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(ListDataModel<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public boolean isBtnEditarProduto() {
		return btnEditarProduto;
	}

	public void setBtnEditarProduto(boolean btnEditarProduto) {
		this.btnEditarProduto = btnEditarProduto;
	}

	public ProdutoFacade getProdutoFacade() {
		return produtoFacade;
	}

	public void setProdutoFacade(ProdutoFacade produtoFacade) {
		this.produtoFacade = produtoFacade;
	}

	public CategoriaFacade getCategoriaFacade() {
		return categoriaFacade;
	}

	public void setCategoriaFacade(CategoriaFacade categoriaFacade) {
		this.categoriaFacade = categoriaFacade;
	}

	public List<Categoria> getListaCategoria() {
		return listaCategoria;
	}

	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}

	
	

}
