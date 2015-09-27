package obra;

import java.util.Date;
import java.util.List;



public class ObraFacade {
	
	private ObraDAO dao;
	
	public ObraFacade(){
		dao = new ObraDAO();
	}
	
	public List<Obra> listarObra(){
		return dao.listarObra();
	}
	
	public boolean insertObra(Obra c){
		return dao.insertObra(c);
	}
	
	public boolean alterarObra(Obra c){
		return dao.alterarObra(c);
	}
	
	public boolean excluirObra(Obra c){
		return dao.excluirObra(c);
	}
	

}
