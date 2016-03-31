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

	cfg.configure();
	new SchemaExport(cfg).create(true,false);
	SessionFactory f = cfg.buildSessionFactory();
	Session current = f.getCurrentSession();
	current.beginTransaction();
	
	Criteria criteria = current.createCriteria(Quiz.class);
	Quiz temp = (Quiz) criteria.add(Restrictions.eq("name", name)).uniqueResult();
	
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
		
		
		Quiz temp = new Quiz();
		temp.setDescription(desc);
		temp.setName(name);

		current.save(temp);
		current.getTransaction().commit();

		
	}
	
}
