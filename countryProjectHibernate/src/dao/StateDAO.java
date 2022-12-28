package dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;

import vo.StateVO;

public class StateDAO {
	
	public void insert(StateVO StateVO)
		{
			try
				{
					SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
					
					Session session = sessionFactory.openSession();
					
					Transaction transaction=session.beginTransaction();
					
					session.save(StateVO);
					
					transaction.commit();
					
					session.close();
				}
			catch(Exception ex)
				{
					ex.printStackTrace();
				}
		}

public List statesearch(StateVO v1){

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction transaction = session.beginTransaction();

			Query q = session.createQuery("from StateVO");

			List ls = q.list();
			transaction.commit();

			session.close();

return ls;			
}

public void delete(StateVO v1) {
	// TODO Auto-generated method stub
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	Session session = sessionFactory.openSession();

	Transaction transaction = session.beginTransaction();

	session.delete(v1);
	transaction.commit();

	session.close();
}

public List edit(StateVO v1){

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	Session session = sessionFactory.openSession();

	Transaction transaction = session.beginTransaction();

	Query q = session.createQuery("from StateVO where id='"+v1.getId()+"' ");

	List ls = q.list();
	transaction.commit();

	session.close();

return ls;			
}

public void update(StateVO StateVO)
{
	try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.update(StateVO);
			
			transaction.commit();
			
			session.close();
		}
	catch(Exception ex)
		{
			ex.printStackTrace();
		}
}


}
