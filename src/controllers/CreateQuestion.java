package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import ca.myseneca.a2.Quiz;
import ca.myseneca.a2.User;
import util.HibernateUtil;

/**
 * Servlet implementation class CreateQuestion
 */
@WebServlet("/CreateQuestion")
public class CreateQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String receivedId = request.getParameter("id");
				
		System.out.println("OPENED"); 
		String questionText = request.getParameter("questionText");
		List<String> answers = new ArrayList<String>();
		answers.add(request.getParameter("answerA"));
		answers.add(request.getParameter("answerB"));
		answers.add(request.getParameter("answerC"));
		answers.add(request.getParameter("answerD"));
		
		
		
		String[] canswers=request.getParameterValues("answer");
		//response.getWriter().print("String size is " + canswers.length);
		Integer intanswers[] = new Integer[canswers.length];
		for(int i = 0;i<canswers.length;i++){
			intanswers[i]=Integer.parseInt(canswers[i]);
		}

		for(Integer i:intanswers)
			response.getWriter().print("<br> " + i );
		String qtype = request.getParameter("qtype");
		Integer diff = Integer.parseInt(request.getParameter("difftype"));
		String answerexplained = request.getParameter("answerexpl");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Question q = null;
		Answer li[]=new Answer[4];
		
		
		
		if(receivedId==null){
			response.getWriter().print("NO ID");
			q = new Question(questionText,answerexplained,qtype,diff);
			for (int i =0;i<4;i++){
				li[i] = new Answer(q,answers.get(i),"false");
			}
			
			for(Integer i : intanswers)
				li[i].setCorrect("true");
		}
		
		
		else{
			System.out.println("CHANGING");
			response.getWriter().print("ID: "+receivedId);
			Integer id =  Integer.parseInt(receivedId);
			Criteria criteria = session.createCriteria(Question.class);
			q = new Question();
			q = (Question)criteria.add(Restrictions.eq("questionId",id)).uniqueResult();
		
			q.setAnswerExplained(answerexplained);
			q.setDifficulty(diff);
			q.setType(qtype);
			q.setText(questionText);
			
			
			q.getAnswers().clear();
			//session.delete(q);
			
			for (int i =0;i<4;i++){
				li[i] = new Answer(q,answers.get(i),"false");
			}
			
			for(Integer i : intanswers)
				li[i].setCorrect("true");
		}	
		
		session.save(q);
		
		for (int i =0;i<4;i++){
			session.save(li[i]);
		}
				
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
