package controllers;

import java.io.IOException;
import java.util.HashSet;
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

/**
 * Servlet implementation class EditQuestion
 */
@WebServlet("/EditQuestion")
public class EditQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		response.getWriter().print("The passed ID is " + id);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
			
	   	Criteria criteria = session.createCriteria(Question.class);
		Question q = new Question();
		q = (Question)criteria.add(Restrictions.eq("questionId",id)).uniqueResult();
		
		
		if(q.getType().equals("textinput") || q.getType().equals("numberinput")){
			response.getWriter().print("TEXT INPUT OR NUMBER");		
			String questionText = q.getText();
			
			String answer="";
			Set<Answer> s = new HashSet<Answer>();
			s.addAll(q.getAnswers());
			for(Answer an:s){
				answer = an.getText();
			}
				
			String qtype = q.getType();
			Integer diff = q.getDifficulty();
			String answerexplained = q.getAnswerExplained();
			
			response.getWriter().print("QT is " + questionText + "<br> Answer is " + answer + "<br> type: " + qtype + "<br> diff " + diff + "<br> Answer Explained: "+ answerexplained);	
			
			request.setAttribute("questionText", questionText);
			request.setAttribute("answerexpl", answerexplained);
			request.setAttribute("answer", answer);
			request.setAttribute("diff",diff);
			request.setAttribute("qtype", qtype);
			request.setAttribute("Id", "12345");
			
			
			if(q.getType().equals("textinput"))
				request.getRequestDispatcher("createtextinput.jsp").forward(request, response);
			else
				request.getRequestDispatcher("createnumberinput.jsp").forward(request, response);
			
			
		}
		
		if(q.getType().equals("multiplechoice")){
			response.getWriter().print("MULTIPLE CHOICE");		
			//String questionText = q.getText();
			String str[]=new String[4];
			Set<Answer> s = q.getAnswers();
			int i = 0;
			int correct=0;
			for(Answer an:s){
				str[i]=an.getText();
				if(an.isCorrect().endsWith("true"))
					correct = i;
				i++;
			}
						
			request.setAttribute("questionText", q.getText());
			request.setAttribute("answerexpl",q.getAnswerExplained());
			request.setAttribute("diff",q.getDifficulty());
			request.setAttribute("A1",str[0]);
			request.setAttribute("A2",str[1]);
			request.setAttribute("A3",str[2]);
			request.setAttribute("A4",str[3]);
			request.setAttribute("correct",correct);
			
			request.getRequestDispatcher("createmultiplechoice.jsp").forward(request, response);				
			
			
			
		} 
		
		else{
			
			response.getWriter().print("M");		
			
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
