package produto;

import java.sql.SQLException;
import java.util.List;



public class ProdutoFacade {
	
	private ProdutoDAO dao;
	
	public ProdutoFacade(){
		dao = new ProdutoDAO();
	}
	
	public List<Produto> listarProduto(){
		return dao.listarProduto();
	}
	
	public boolean insertProduto(Produto c){
		return dao.insertProduto(c);
	}
	
	public boolean alterarProduto(Produto c){
		return dao.alterarProduto(c);
	}
	
	public boolean excluirProduto(Produto c){
		return dao.excluirProduto(c);
	}
	

}
