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


//import com.mysql.jdbc.*;

@Entity
public class User{
	private int userId;
	private String email;
	private String password;
	private String name;
	private String type;
	private List<Quiz> quizzes = new ArrayList<Quiz>();
	
	
	public User(String email, String password, String name, String type) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		
		
		// http://stackoverflow.com/questions/14977018/jpa-how-to-get-entity-based-on-field-value-other-than-id
		cfg.configure();
		new SchemaExport(cfg).create(true,false);
		SessionFactory f = cfg.buildSessionFactory();
		Session current = f.getCurrentSession();
		current.beginTransaction();
		
		Criteria criteria = current.createCriteria(User.class);
		
		User temp = (User)criteria.add(Restrictions.eq("email", em)).uniqueResult();
		
//		Quiz temp = (Quiz) current.get(Quiz.class,id);
		if(temp==null){
			System.out.println("Not found");
			return false;
		}else {		
		 System.out.println("The User name is " + temp.getName() +" and " + "password is " + temp.getPassword());
		 current.getTransaction().commit();
		 return true;
		}
		
	}
}
