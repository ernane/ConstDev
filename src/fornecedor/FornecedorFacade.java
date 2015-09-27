package fornecedor;

import java.util.List;

public class FornecedorFacade {

	private FornecedorDAO dao;

	public FornecedorFacade() {
		dao = new FornecedorDAO();
	}
	
	public boolean insert(Fornecedor fornecedor){
		return dao.insert(fornecedor);
	}
	
	public List<Fornecedor> listarFornecedor(){
		return dao.listarFornecedor();
	}
}
