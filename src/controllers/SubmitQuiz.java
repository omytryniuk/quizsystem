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
    	
    	String languages[];
    	String htmlResponse = "<html>";
    	int i;
    	
    	// First Question:
    	
    	languages = request.getParameterValues("question0");
    	
    	i = 1;
    	
    	if (languages != null) {
    	    htmlResponse += "<h2>First Question:</h2>";
    	    for (String lang : languages) {
    	    	i++;
    	    	htmlResponse += i + "<p> answer is: " + lang + "</p>";
    	    	htmlResponse += "</html>";    	    	
    	        System.out.println("\t" + lang);
    	    }
    	    htmlResponse += "<br>";
    	}
    	
        // Second Question:
    	
    	languages = request.getParameterValues("question1");
    	
    	i = 1;
    	
    	if (languages != null) {
    	    htmlResponse += "<h2>Second Question:</h2>";
    	    for (String lang : languages) {
    	    	i++;
    	    	htmlResponse += i + "<p> answer is: " + lang + "</p>";
    	    	htmlResponse += "</html>";    	    	
    	        System.out.println("\t" + lang);
    	    }
    	    htmlResponse += "<br>";
    	}
    	
        // Third Question:
    	
    	languages = request.getParameterValues("question2");
    	
    	i = 1;
    	
    	if (languages != null) {
    	    htmlResponse += "<h2>Third Question:</h2>";
    	    for (String lang : languages) {
    	    	i++;
    	    	htmlResponse += i + "<p> answer is: " + lang + "</p>";
    	    	htmlResponse += "</html>";    	    	
    	        System.out.println("\t" + lang);
    	    }
    	    htmlResponse += "<br>";
    	}
    	
        // Fourth Question:
    	
    	languages = request.getParameterValues("question3");
    	
    	i = 1;
    	
    	if (languages != null) {
    	    htmlResponse += "<h2>Fourth Question:</h2>";
    	    for (String lang : languages) {
    	    	i++;
    	    	htmlResponse += i + "<p> answer is: " + lang + "</p>";
    	    	htmlResponse += "</html>";    	    	
    	        System.out.println("\t" + lang);
    	    }
    	    htmlResponse += "<br>";
    	}
    	
        // Fifth Question:
    	
    	languages = request.getParameterValues("question4");
    	
    	i = 1;
    	
    	if (languages != null) {
    	    htmlResponse += "<h2>Second Question:</h2>";
    	    for (String lang : languages) {
    	    	i++;
    	    	htmlResponse += i + "<p> answer is: " + lang + "</p>";
    	    	htmlResponse += "</html>";    	    	
    	        System.out.println("\t" + lang);
    	    }
    	    htmlResponse += "<br>";
    	}
    	
    	// Output:
    	
    	PrintWriter writer = response.getWriter();
    	writer.println(htmlResponse);
 
    }

}
