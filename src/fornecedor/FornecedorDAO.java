package fornecedor;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import util.DefaultMB;
import util.HibernateUtil;

public class FornecedorDAO extends DefaultMB {

	private Session session;

	public boolean insert(Fornecedor fornecedor) {
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(fornecedor);
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

	public boolean update(Fornecedor fornecedor) {
		try {

			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.update(fornecedor);
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
	public List<Fornecedor> listarFornecedor() {
		List<Fornecedor> lista = new ArrayList<Fornecedor>();
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			Query query = session.createQuery("Select m from fornecedor m");
			lista = (List<Fornecedor>) query.list();
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
