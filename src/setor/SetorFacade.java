package setor;

import java.util.List;



public class SetorFacade {
	
	private SetorDAO dao;
	
	public SetorFacade(){
		dao = new SetorDAO();
	}
	
	public List<Setor> listarSetor(){
		return dao.listarSetor();
	}
	
	public boolean insertSetor(Setor c){
		return dao.insertSetor(c);
	}
	
	public boolean alterarSetor(Setor c){
		return dao.alterarSetor(c);
	}
	
	public boolean excluirSetor(Setor c){
		return dao.excluirSetor(c);
	}
	

}
