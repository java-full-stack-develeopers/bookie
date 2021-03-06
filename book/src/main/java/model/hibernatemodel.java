package model;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import book.User;

public class hibernatemodel {
	
	public void createuser(User createuser) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			String firstname = createuser.getFirst_name();
			String lastname = createuser.getLast_name();
			String username = createuser.getUsername();
			String password = createuser.getPassword();
			String email = createuser.getEmail();
			String contact = createuser.getContact();
			
			User user = new User(firstname,lastname,username,password,email,contact);
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			
		}finally {
			session.close();
			factory.close();
		}
          
}

	public boolean signin(User sample) {
		
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		User user =null;
		Transaction transaction =null;
		try{
			String Username = sample.getUsername();
			String Password = sample.getPassword();
			transaction = session.beginTransaction();
			user= (User)session.createQuery("from User U where U.username=:username").setParameter("username", Username).uniqueResult();
			if(user != null && user.getPassword().equals(Password)) {
				System.out.println("login successfull");
			}
			transaction.commit();
			}catch(Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			}return false;
		
		
		
		
		
	}

	



		
}
