package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import ca.myseneca.a2.User;
import util.HibernateUtil;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EntityManager em;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uname = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		if(uname.length()==0||password.length()==0){
			request.setAttribute("message", "The Login information is not validated!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			HibernateUtil hu = new HibernateUtil();
			int ui=hu.validateLogin(uname,password);
			System.out.println("Id is "+ ui);
			if(ui>0){
				System.out.println("Id is "+ ui);
				
				Criteria criteria = session.createCriteria(User.class);
				User u = new User();
				u = (User)criteria.add(Restrictions.eq("userId",ui)).uniqueResult();
				
				
			//	u=em.find(User.class,12);
				if(u.getType().compareTo("User")==0){
					request.setAttribute("name", u.getEmail());
					request.getRequestDispatcher("mainuser.jsp").forward(request, response);
				}
				else{
					request.setAttribute("name", u.getEmail());
					request.getRequestDispatcher("mainadmin.jsp").forward(request, response);
				}
				
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("isLoggedIn",true);
			}
				
			else{
				request.setAttribute("message", "The Login information is not validated!!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}
				
				
			
			
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
