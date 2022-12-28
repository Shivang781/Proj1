package dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;

import vo.CountryVO;

public class CountryDAO {
	
	public void insert(CountryVO countryVO)
		{
			try
				{
					SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
					
					Session session = sessionFactory.openSession();
					
					Transaction transaction=session.beginTransaction();
					
					session.save(countryVO);
					
					transaction.commit();
					
					session.close();
				}
			catch(Exception ex)
				{
					ex.printStackTrace();
				}
		}

public List search(){

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction transaction = session.beginTransaction();

			Query q = session.createQuery("from CountryVO");
			List ls = q.list();
	
			transaction.commit();

			session.close();

return ls;			
}

public void delete(CountryVO v1) {
	// TODO Auto-generated method stub
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	Session session = sessionFactory.openSession();

	Transaction transaction = session.beginTransaction();

	session.delete(v1);
	transaction.commit();

	session.close();
}

public List edit(CountryVO v1){

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	Session session = sessionFactory.openSession();

	Transaction transaction = session.beginTransaction();

	Query q = session.createQuery("from CountryVO where id='"+v1.getId()+"' ");

	List ls = q.list();
	transaction.commit();

	session.close();

return ls;			
}

public void update(CountryVO countryVO)
{
	try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.update(countryVO);
			
			transaction.commit();
			
			session.close();
		}
	catch(Exception ex)
		{
			ex.printStackTrace();
		}
}


}
