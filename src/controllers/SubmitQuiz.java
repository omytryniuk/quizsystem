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

import java.util.*;
import ca.myseneca.a2.Question;
import ca.myseneca.a2.Answer;

@WebServlet("/SubmitQuiz")
public class SubmitQuiz extends HttpServlet {
	
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	
    	// Getting quiz info from the session:
    	
    	HttpSession currSession = request.getSession();
    	
    	List<Question> questionsList = (List<Question>)currSession.getAttribute("quiz");
    	
    	Set<Answer> answersSet;
    	Boolean isAnswerCorrect;
    	Boolean flag;
    	
    	String languages[];
    	String htmlResponse = "<html>";
    	//int i;
    	
    	int totalScore = 0;
    	
    	String[][] myAnswers = {
    		request.getParameterValues("question0"),
    		request.getParameterValues("question1"),
    		request.getParameterValues("question2"),
    		request.getParameterValues("question3"),
    		request.getParameterValues("question4"),
    		request.getParameterValues("question5")
    	};
    	
    	for(int i = 0; i < questionsList.size(); i++) {
    		htmlResponse += "<h1>QUESTION</h1>";
    		isAnswerCorrect = true;
    		if(questionsList.get(i).getType().equals("checkbox")) {
    	//		htmlResponse += "<h3>checkbox</h3>";
    	//		htmlResponse += Integer.toString(questionsList.get(i).getDifficulty());
    			htmlResponse += (questionsList.get(i).getText());
    			answersSet = questionsList.get(i).getAnswers();
    			
    			//ADDED
    			htmlResponse+="<p>Correct answers: </p>";
    			for(Answer a : answersSet){
    				if(a.isCorrect().equals("true")){
    				htmlResponse += a.getText()+"<br>";
    				System.out.println(a.getText());
    				}
    			}
    			
    			for(Answer ans: answersSet) {
    	    	    if(ans.isCorrect().equals("true")) {
    	    	    	flag = false;
    	    	    	for(int j = 0; j < myAnswers[i].length; j++) {
    	    	    		if(Integer.parseInt(myAnswers[i][j]) == ans.getAnswerId()) {
    	    	    			flag = true;
    	    	    			break;
    	    	    		}
    	    	    	}
    	    	    	if(flag == false) {
    	    	    		isAnswerCorrect = false;
    	    	    		break;
    	    	    	}
    	    	    } else {
    	    	    	flag = false;
    	    	    	for(int j = 0; j < myAnswers[i].length; j++) {
    	    	    		if(Integer.parseInt(myAnswers[i][j]) == ans.getAnswerId()) {
    	    	    			flag = true;
    	    	    			break;
    	    	    		}
    	    	    	}
    	    	    	if(flag == true) {
    	    	    		isAnswerCorrect = false;
    	    	    		break;
    	    	    	}
    	    	    }
    	    	}
    			
    			if(isAnswerCorrect) {
    				totalScore += questionsList.get(i).getDifficulty();
    			}
    			
    			htmlResponse += "<h5>Is my answer correct?</h5>";
    			htmlResponse += "<p>";
    			htmlResponse += String.valueOf(isAnswerCorrect);
    			htmlResponse += "</p>";
    			
    		} else if(questionsList.get(i).getType().equals("textinput")) {
    		//	htmlResponse += "<h3>textinput</h3>";
    		//	htmlResponse += Integer.toString(questionsList.get(i).getDifficulty());
    			
    			htmlResponse += (questionsList.get(i).getText());
    			answersSet = questionsList.get(i).getAnswers();
    			htmlResponse+="<p>Correct answers: </p>";
    			for(Answer a : answersSet){
    				if(a.isCorrect().equals("true")){
    				htmlResponse += a.getText()+"<br>";
    				System.out.println(a.getText());
    				}
    			}
    			
    			
    			htmlResponse += "<h5>Is my answer correct?</h5>";
    			
    	    	if(myAnswers[i][0].equals(((Answer)(answersSet.toArray()[0])).getText())) {
        		    totalScore += questionsList.get(i).getDifficulty();
    	    		htmlResponse += "<p>true</p>";
    	    	} else {
    	    		htmlResponse += "<p>false</p>";
    	    	}
    	    	
    		} else if(questionsList.get(i).getType().equals("multiplechoice")) {
    		//	htmlResponse += "<h3>multiplechoice</h3>";
    		//	htmlResponse += Integer.toString(questionsList.get(i).getDifficulty());
    			
    			htmlResponse += (questionsList.get(i).getText());
    			
    			
    			answersSet = questionsList.get(i).getAnswers();
    			
    			// CHANGED
    			htmlResponse+="<p>Correct answers: </p>";
    			for(Answer a : answersSet){
    				if(a.isCorrect().equals("true")){
    				htmlResponse += a.getText();
    				System.out.println(a.getText());
    				}
    			}
    			
    			
    		//	System.out.println(myAnswers[0][0]);
    			
    			
    			//MAX
    			for(Answer ans: answersSet) {
    				if(ans.isCorrect().equals("true")) {
    				    if(ans.getAnswerId() == Integer.parseInt(myAnswers[i][0])) {
    					    totalScore += questionsList.get(i).getDifficulty();
    					    isAnswerCorrect = true;
    				    } else {
    					    isAnswerCorrect = false;
    				    }
    				    break;
    				}
    			}
    			
    			htmlResponse += "<h5>Is my answer correct?</h5>";
    			htmlResponse += "<p>";
    			htmlResponse += String.valueOf(isAnswerCorrect);
    			htmlResponse += "</p>";
    			
    		} else if(questionsList.get(i).getType().equals("numberinput")) {
    		//	htmlResponse += "<h3>numberinput</h3>";
    		//	htmlResponse += Integer.toString(questionsList.get(i).getDifficulty());
    			htmlResponse += (questionsList.get(i).getText());
    			answersSet = questionsList.get(i).getAnswers();
    			htmlResponse+="<p>Correct answers: </p>";
    			for(Answer a : answersSet){
    				if(a.isCorrect().equals("true")){
    				htmlResponse += a.getText()+"<br>";
    				System.out.println(a.getText());
    				}
    			}
    			
    			
                htmlResponse += "<h5>Is my answer correct?</h5>";
    			
    	    	if(myAnswers[i][0].equals(((Answer)(answersSet.toArray()[0])).getText())) {
        		    totalScore += questionsList.get(i).getDifficulty();
    	    		htmlResponse += "<p>true</p>";
    	    	} else {
    	    		htmlResponse += "<p>false</p>";
    	    	}
    			
    		} else if(questionsList.get(i).getType().equals("dropdown")) {
        		//	htmlResponse += "<h3>multiplechoice</h3>";
        		//	htmlResponse += Integer.toString(questionsList.get(i).getDifficulty());
        			
    			System.out.println("CHECKING IS: "+ request.getParameterValues("question1"));
        			htmlResponse += (questionsList.get(i).getText());
        			
        			
        			answersSet = questionsList.get(i).getAnswers();
        			
        			// CHANGED
        			htmlResponse+="<p>Correct answers: </p>";
        			for(Answer a : answersSet){
        				System.out.println("ANSWER IS" + a.getText()+"\n");
        				System.out.println("ID:" + i);
        				if(a.isCorrect().equals("true")){
        				htmlResponse += a.getText();
        				System.out.println(a.getText());
        				}
        			}
        			
        	System.out.println("ANSWER size is "+ answersSet.size());
        			
        			
        			//MAX
        			for(Answer ans: answersSet) {
        				if(ans.isCorrect().equals("true")) {
        					if(ans.getAnswerId() == Integer.parseInt(myAnswers[i][0])) {
        					    totalScore += questionsList.get(i).getDifficulty();
        					    isAnswerCorrect = true;
        				    } else {
        					    isAnswerCorrect = false;
        				    }
        				    break;
        				}
        			}
        		 			
        			
        			
        			
        			htmlResponse += "<h5>Is my answer correct?</h5>";
        			htmlResponse += "<p>";
        			htmlResponse += String.valueOf(isAnswerCorrect);
        			htmlResponse += "</p>";
        			
        		}
    	}
    	
    	htmlResponse += ("<p>total score is: </p>" + Integer.toString(totalScore * 10) + "%");
    	
    	// Output:
    	
    	PrintWriter writer = response.getWriter();
    	writer.println(htmlResponse);
 
    }

}
