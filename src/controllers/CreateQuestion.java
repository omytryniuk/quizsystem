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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
		
		Question q = new Question(questionText,answerexplained,qtype,diff);
		
		Answer li[]=new Answer[4];
		
		for (int i =0;i<4;i++){
			li[i] = new Answer(q,answers.get(i),"false");
		}
		
		for(Integer i : intanswers)
			li[i].setCorrect("true");
		
		session.save(q);
		
		for (int i =0;i<4;i++){
			session.save(li[i]);
		}
		
		session.save(q);
		
		session.getTransaction().commit();
		
		request.getRequestDispatcher("questionwascreated.jsp").forward(request, response);
		
		
		
		/*
		Integer ca = Integer.parseInt(request.getParameter("answer"));
		System.out.println("INT is " +ca);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		//System.out.println("Question is: " + qt + "\n a: " + a  + "\n b: " + b  + "\n c: " + c + "\n d: " + d + "\n Answer is "+ca+ "\n Type is "+qtype + "\n Difftype is: " + diff);
		
		
		
	//	Session current = f.getCurrentSession();
	
		
		
	
		
		
		
		
	//	Integer id =q.getQuestionId();
	//	temp.setAnswerId(id);
	//	temp.setQuestion(q);
		

		session.save(q);
		
		for (int i =0;i<4;i++){
			session.save(li[i]);
		}
		
		
		//session.save(temp);
		//session.save(temp1);
		//q.getAnswers().add(temp);	
		//	c.getUsers().add(oleg);
		//oleg.getQuizzes().add(java);
		
		session.save(q);
	
		session.getTransaction().commit();
		
		request.getRequestDispatcher("questionwascreated.jsp").forward(request, response);
		*/
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
