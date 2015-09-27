package categoria;

import java.util.List;



public class CategoriaFacade {
	
	private CategoriaDAO dao;
	
	public CategoriaFacade(){
		dao = new CategoriaDAO();
	}
	
	public List<Categoria> listarCategoria(){
		return dao.listarCategoria();
	}
	
	public boolean insertCategoria(Categoria c){
		return dao.insertCategoria(c);
	}
	
	public boolean alterarCategoria(Categoria c){
		return dao.alterarCategoria(c);
	}
	
	public boolean excluirCategoria(Categoria c){
		return dao.excluirCategoria(c);
	}
	

}
