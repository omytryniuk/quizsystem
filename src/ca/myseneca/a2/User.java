package ca.myseneca.a2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.tool.hbm2ddl.SchemaExport;

@Entity
public class User{
	private int userId;
	private String email;
	private String password;
	private String fname;
	private String lname;
	private String type;
	private List<Quiz> quizzes = new ArrayList<Quiz>();
	
	
	public User(String email, String password, String fname,String lname, String type) {
		super();
		this.email = email;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.type = type;
	}
	
	
	
		
	public User() {
		super();
	}
	
	@Id
	@GeneratedValue
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public int arsize() {
		return quizzes.size();
	}
	
	@ManyToMany
	@JoinTable(name="JOIN_USER_QUIZ",joinColumns={@JoinColumn(name="userId")},
	inverseJoinColumns={@JoinColumn(name="quizId")})
	public List<Quiz> getQuizzes() {
		System.out.println("Inside" + quizzes.size());
		return quizzes;
	}
	public void setQuizzes(List<Quiz> quizzes) {
	//	System.out.println("Inside" + quizzes.size());
		
		this.quizzes = quizzes;
	}
	
	
		
	public boolean useGet(String em){
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(User.class);
		cfg.addAnnotatedClass(Quiz.class);
		
		
		cfg.configure();
		new SchemaExport(cfg).create(true,false);
		SessionFactory f = cfg.buildSessionFactory();
		Session current = f.getCurrentSession();
		current.beginTransaction();
		
		Criteria criteria = current.createCriteria(User.class);
		
		User temp = (User)criteria.add(Restrictions.eq("email", em)).uniqueResult();
		
		if(temp==null){
			System.out.println("Not found");
			return false;
		}else {		
		 System.out.println("The User name is " + temp.getFname() +" and " + "password is " + temp.getPassword());
		 current.getTransaction().commit();
		 return true;
		}
		
	}
}
