package produto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import util.DefaultMB;
import util.HibernateUtil;

public class ProdutoDAO extends DefaultMB{
	
private Session session;
	
	public boolean alterarProduto(Produto c) {
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
	
	public boolean insertProduto(Produto c) {
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
	
	public boolean excluirProduto(Produto c) {
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
	public List<Produto> listarProduto() {
		List<Produto> lista = new ArrayList<Produto>();
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			Query query = session.createQuery("Select m from produto m"); 
			lista = (List<Produto>) query.list();
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
