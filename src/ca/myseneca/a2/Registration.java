package ca.myseneca.a2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class Registration {
	
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(User.class);
		cfg.addAnnotatedClass(Quiz.class);
		
		cfg.configure();
		new SchemaExport(cfg).create(true,true);
		SessionFactory f = cfg.buildSessionFactory();
		Session current = f.getCurrentSession();
		current.beginTransaction();
		
		User oleg = new User();
		oleg.setName("Oleg");
		oleg.setEmail("omytryniuk@myseneca.ca");
		oleg.setPassword("p@ssword");
		oleg.setType("admin");
		
		Quiz java = new Quiz();
		Quiz c = new Quiz();
		java.setDescription("Java Course");
		java.setName("Java");
		c.setDescription("C++ Course");
		c.setName("C++");
		
	//	List<Quiz> q = new ArrayList<Quiz>();
		//q.add(c);
		//q.add(java);
		
		//oleg.setQuizzes(q);
		java.getUsers().add(oleg);
		c.getUsers().add(oleg);
		oleg.getQuizzes().add(java);
		
		current.save(oleg);
		current.save(c);
		current.save(java);
		current.getTransaction().commit();
		//List<Quiz> r = new ArrayList<Quiz>();
		//r = oleg.getQuizzes();
		
		//for(Quiz t : r){
			//System.out.println(t.getName());
			
		//}
		
	
		//System.out.println("ADD1");
	  //  Scanner sc = new Scanner(System.in);
	  //   int i = sc.nextInt();
String res = "Welcome " + oleg.getName() + " back. You have the next quizzes available " + oleg.getQuizzes();
	//System.out.println("ADD2");
System.out.println(res);
	}

}
