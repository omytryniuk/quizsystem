package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mysql.jdbc.DatabaseMetaData;

import ca.myseneca.a2.User;
import util.*;

/**
 * Servlet implementation class CreateUser
 */
@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
    public CreateUser() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		boolean valid = true;
		// GETTING ALL VALUES FROM THE FORM
		
		String uname = request.getParameter("email");
		String password = request.getParameter("password");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String type=null;
		
		
		if(uname.toLowerCase().contains("@myseneca.ca")){
			System.out.println("User");
			type="User";
		}
		else{
			System.out.println("Admin");
			type="Admin";
		}
		
		
		
		
		
		
		
		HibernateUtil hu = new HibernateUtil();
		User add=new User();
		
		// VALIDATE THE USER'S INPUT
		if(uname.length()==0||password.length()==0||fname.length()==0||lname.length()==0){
			request.setAttribute("message", "The Registration did not pass the validation!!");
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		}
		else {
			if(!hu.tablesExist()){
				System.out.println("TABLES DO NOT EXIST");
				hu.createSchema();
			}
					
			add = new User(uname,password, fname,lname,type);
			valid = hu.validation(uname);
		}
		
		// IF VALIDATION PASSES - CREATE SESSION
		
		
		if(valid){
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
						
			// ADDING A NEW USER TO THE DB	
			try {session.saveOrUpdate(add);}
			catch (Exception e) {
				String message = "Can not login";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("registration.jsp");
				dispatcher.forward(request,response);
				
				request.setAttribute("message", message);
				request.getRequestDispatcher("registration.jsp").forward(request, response);
			} 
			session.getTransaction().commit();
			session.close();
			request.setAttribute("message", "Your account was successfully created, please log-in:)");
			request.getRequestDispatcher("login.jsp").forward(request, response);
					
		}
	

	else {
		request.setAttribute("message", "The user with such name already exists. Choose another email");
		request.getRequestDispatcher("registration.jsp").forward(request, response);
		
	}
	
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
