package ca.myseneca.a2;

import javax.persistence.*;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Quiz{
	
	private int quizId;
	private String name;
	private String description;
	private List<User> users = new ArrayList<>();
	
	@Id
	@GeneratedValue
	public int getQuizId() {
		return quizId;
	}
	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToMany
	@JoinTable(name="JOIN_USER_QUIZ",joinColumns={@JoinColumn(name="quizId")},
	inverseJoinColumns={@JoinColumn(name="userId")})
	public List<User> getUsers() {
		System.out.println("Before size is "+users.size());
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
public void objGet(String name){
	Configuration cfg = new Configuration();
	cfg.addAnnotatedClass(User.class);
	cfg.addAnnotatedClass(Quiz.class);
	
	
	// http://stackoverflow.com/questions/14977018/jpa-how-to-get-entity-based-on-field-value-other-than-id
	cfg.configure();
	new SchemaExport(cfg).create(true,false);
	SessionFactory f = cfg.buildSessionFactory();
	Session current = f.getCurrentSession();
	current.beginTransaction();
	
	Criteria criteria = current.createCriteria(Quiz.class);
	Quiz temp = (Quiz) criteria.add(Restrictions.eq("name", name)).uniqueResult();
	
//	Quiz temp = (Quiz) current.get(Quiz.class,id);
	
	 System.out.println("The QUIZ name is " + temp.getName() +" and " + "desc is " + temp.getDescription());
	 current.getTransaction().commit();
	
	
}	
	
public void goO(String name, String desc){
		
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(User.class);
		cfg.addAnnotatedClass(Quiz.class);
		
		cfg.configure();
		new SchemaExport(cfg).create(true,false);
		SessionFactory f = cfg.buildSessionFactory();
		Session current = f.getCurrentSession();
		current.beginTransaction();
		
		/*User oleg = new User();
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
		*/
	//	List<Quiz> q = new ArrayList<Quiz>();
		//q.add(c);
		//q.add(java);
		
		//oleg.setQuizzes(q);
		
		Quiz temp = new Quiz();
		temp.setDescription(desc);
		temp.setName(name);
		/*
		java.getUsers().add(oleg);
		c.getUsers().add(oleg);
		System.out.println("CHECK is " + oleg.arsize());
		oleg.getQuizzes().add(java);
		System.out.println("CHECK is " + oleg.arsize());
		String tot = "";
		
		List<Quiz> temp = new ArrayList<Quiz>();
		temp = oleg.getQuizzes();
		for (Quiz s : temp)
		{
		    tot += s.getDescription() + "\t";
		}
		*/
		///System.out.println("RESULT is " + tot);
		//current.save(oleg);
		//current.save(c);
		//current.save(java);
		current.save(temp);
		current.getTransaction().commit();
		//List<Quiz> r = new ArrayList<Quiz>();
		//r = oleg.getQuizzes();
		
		//for(Quiz t : r){
			//System.out.println(t.getName());
			
		//}
		
	
		//System.out.println("ADD1");
	  //  Scanner sc = new Scanner(System.in);
	  //   int i = sc.nextInt();
//String res = "Welcome " + oleg.getName() + " back. You have the next quizzes available " + oleg.getQuizzes();
	//System.out.println("ADD2");
//System.out.println(res);
	//	return tot;
		
	}
	
}
