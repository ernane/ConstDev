package fornecedor;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

import util.DefaultMB;

@SessionScoped
@ManagedBean(name = "fornecedorMB")
public class FornecedorController extends DefaultMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private Fornecedor fornecedor;
	private FornecedorFacade fornecedorFacade;
	private ListDataModel<Fornecedor> listaFornecedor;

	public ListDataModel<Fornecedor> getListaFornecedor() {
		return listaFornecedor;
	}

	public void setListaFornecedor(ListDataModel<Fornecedor> listaFornecedor) {
		this.listaFornecedor = listaFornecedor;
	}

	@PostConstruct
	public void init() {
		fornecedor = new Fornecedor();
		listaFornecedor = new ListDataModel<Fornecedor>();
		fornecedorFacade = new FornecedorFacade();
		listarFornecedor();
	}

	public String listarFornecedor() {
		listaFornecedor = new ListDataModel<Fornecedor>(fornecedorFacade.listarFornecedor());
		return "";
	}

	public String insert() {

		if (fornecedorFacade.insert(fornecedor)) {
			registrarMensagemInfo("", "Fornecedor cadastrado com sucesso!");
		} else {
			registrarMensagemErro("", "Erro ao cadastrar Fornecedor!");
		}

		init();
		return "";
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
}
