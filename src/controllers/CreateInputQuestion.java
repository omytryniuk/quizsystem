package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

import ca.myseneca.a2.Answer;
import ca.myseneca.a2.Question;

/**
 * Servlet implementation class CreateInputQuestion
 */
@WebServlet("/CreateInputQuestion")
public class CreateInputQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateInputQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String receivedId = request.getParameter("id");
			
		
		
		
		String questionText = request.getParameter("questionText");
		
		String answer = request.getParameter("answer");
		String qtype = request.getParameter("qtype");
		Integer diff = Integer.parseInt(request.getParameter("difftype"));
		String answerexplained = request.getParameter("answerexpl");
				
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		Question q = null;
		Answer a = null;
		if(receivedId==null){
			response.getWriter().print("NO ID");
			q = new Question(questionText,answerexplained,qtype,diff);
			a = new Answer(q,answer,"true");
		}
		else{
			response.getWriter().print("ID: "+receivedId);
			Integer id =  Integer.parseInt(receivedId);
			Criteria criteria = session.createCriteria(Question.class);
			q = new Question();
			q = (Question)criteria.add(Restrictions.eq("questionId",id)).uniqueResult();
		
			q.getAnswers().clear();
			session.delete(q);
			
			q = new Question(questionText,answerexplained,qtype, diff);
			q.setQuestionId(id);
			a = new Answer(q,answer,"true");
		}	
			
			//q.setAnswerExplained(answerexplained);
			//q.setDifficulty(diff);
			//q.setText(questionText);
			//q.setType(qtype);
			
			
			
			
			
			
			
		
		
		
		
		
	//	response.getWriter().print("The passed ID is " + receivedId);
	//	Question q = new Question(questionText,answerexplained,qtype,diff);
		//Answer a = new Answer(q,answer,"true");
		session.save(q);
		session.save(a);
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
