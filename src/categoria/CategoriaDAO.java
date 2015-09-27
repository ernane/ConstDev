package categoria;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import util.DefaultMB;
import util.HibernateUtil;



public class CategoriaDAO extends DefaultMB{
	
private Session session;
	
	public boolean alterarCategoria(Categoria c) {
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
	
	public boolean insertCategoria(Categoria c) {
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
	
	public boolean excluirCategoria(Categoria c) {
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
	public List<Categoria> listarCategoria() {
		List<Categoria> lista = new ArrayList<Categoria>();
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			Query query = session.createQuery("Select m from categoria m"); 
			lista = (List<Categoria>) query.list();
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
