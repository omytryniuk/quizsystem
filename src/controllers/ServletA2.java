package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.cfg.Configuration;

import ca.myseneca.a2.goOleg;
/**
 * Servlet implementation class ServletA2
 */
import ca.myseneca.a2.Quiz;
import ca.myseneca.a2.User;
@WebServlet(name = "SA", urlPatterns = { "/SA" })
public class ServletA2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletA2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 //final String uname;
		// uname = "Oleg";
		 
			String uname = request.getParameter("uname");
			System.out.println("Name of you is " + uname);
		 HttpSession session = request.getSession();
		User r = new User();
	//Quiz t = new Quiz();
	//t.goO(name, desc);
//		
		if(r.useGet(uname))
			request.getRequestDispatcher("success.jsp").forward(request, response);
		else{
			 String message = "Can not login";
			    request.setAttribute("message", message);
			    request.setAttribute("name", uname);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
			
		}
	//	Quiz q = new Quiz();
		//	String word = q.goO();
		
	//	response.getWriter().append("Oleg, Your course is: "+word);
		/* 
		 String q1 = request.getParameter("questionText");
		 String a = request.getParameter("answerA");
		 String b = request.getParameter("answerB");
		 String c = request.getParameter("answerC");
		 String d = request.getParameter("answerD");
		 String answer = request.getParameter("answer");
		*/		 
	//	System.out.println(q1 + ":\n" + a + "\n" +  b + "\n" + c + "\n" + d + "\n" + "Correct answer is " + answer);
		 
		 /*
		 
		String name = request.getParameter("qname");
		String username = request.getParameter("username");
		String usname = request.getParameter("usname");
		String desc = request.getParameter("qdesc");
		Quiz t = new Quiz();
		
		t.objGet("iOS");
		*/
		
	//	t.goO(name, desc);
//		HttpSession session = request.getSession();
//		System.out.println("Name is " + username + " and " + usname);
	//	this.doAction(request, response, "/hobby.jsp");
//		request.getRequestDispatcher("registration.jsp").forward(request, response);
		//response.getWriter().append("Hello Oleg. You are "+age + " years old");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
