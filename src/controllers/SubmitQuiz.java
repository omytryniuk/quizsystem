package controllers;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/SubmitQuiz")
public class SubmitQuiz extends HttpServlet {
	
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
    	String languages[] = request.getParameterValues("question0");
    	String htmlRespone = "<html>";
    	 
    	int i = 1;
    	
    	if (languages != null) {
    	    System.out.println("Languages are: ");
    	    for (String lang : languages) {
    	    	i++;
    	    	htmlRespone += i + "<h2> answer is: " + lang + "</h2>";
    	    	htmlRespone += "</html>";    	    	
    	        System.out.println("\t" + lang);
    	    }
    	}
    	
    	PrintWriter writer = response.getWriter();
    	

    	 
    	writer.println(htmlRespone);
 
    }

}
