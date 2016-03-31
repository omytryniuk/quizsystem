package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import ca.myseneca.a2.Question;
import ca.myseneca.a2.User;
import util.HibernateUtil;

/**
 * Servlet implementation class DeleteQuestion
 */
@WebServlet("/DeleteQuestion")
public class DeleteQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id =  Integer.parseInt(request.getParameter("id"));
		response.getWriter().print("The passed ID is " + id);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
			
	   	Criteria criteria = session.createCriteria(Question.class);
		Question q = new Question();
		q = (Question)criteria.add(Restrictions.eq("questionId",id)).uniqueResult();
		
		
		if(q!=null){
			response.getWriter().print("QUESTION is FOUND");
			q.getAnswers().clear();
			session.delete(q);
		}else
			response.getWriter().print("NOT FOUND");
		
		
	//	session.save(q);
		
		session.getTransaction().commit();
		
		request.getRequestDispatcher("allquestions.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
