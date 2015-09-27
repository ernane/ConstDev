package obra;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import util.DefaultMB;
import util.HibernateUtil;



public class ObraDAO extends DefaultMB{
	
private Session session;
	
	public boolean alterarObra(Obra c) {
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.update(c);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}
	
	public boolean insertObra(Obra c) {
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(c);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}
	
	public boolean excluirObra(Obra c) {
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.delete(c);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Obra> listarObra() {
		List<Obra> lista = new ArrayList<Obra>();
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			Query query = session.createQuery("Select m from obra m"); 
			lista = (List<Obra>) query.list();
			session.getTransaction().commit();
			return lista;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return lista;
		} finally {
			session.close();
		}
	}
}
