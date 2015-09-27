package setor;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import util.DefaultMB;
import util.HibernateUtil;



public class SetorDAO extends DefaultMB{
	
private Session session;
	
	public boolean alterarSetor(Setor c) {
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
	
	public boolean insertSetor(Setor c) {
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
	
	public boolean excluirSetor(Setor c) {
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
	public List<Setor> listarSetor() {
		List<Setor> lista = new ArrayList<Setor>();
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			Query query = session.createQuery("Select m from setor m"); 
			lista = (List<Setor>) query.list();
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
