<%@ page import="java.util.*,org.hibernate.Session,org.hibernate.SessionFactory,org.hibernate.cfg.Configuration,ca.myseneca.a2.Question,ca.myseneca.a2.Answer" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<%
//HttpSession currSession = request.getSession();
 
//if(currSession.getAttribute("isLoggedIn") == null) {
//	response.sendRedirect("login.jsp");
//}
%>
<div class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="allquestions.jsp">All Questions</a></li>                         
                </ul>
            </div>             
        </div>
    </div>
<h2>The list of all questions</h2>
<%
SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
Session ses = sessionFactory.openSession();
List<Question> list = ses.createCriteria(Question.class).list();
List<Question> Questions = new ArrayList<Question>();

String difficulty = "";
int easy_counter = 0;
int medium_counter = 0;
int hard_counter = 0;
for(int i = 0; i < list.size(); i++) {
	
if(list.get(i).getDifficulty() == 1 && easy_counter < 3) {
	Questions.add(list.get(i));
	easy_counter++;
}
if(list.get(i).getDifficulty() == 2 && medium_counter < 2) {
	Questions.add(list.get(i));
	medium_counter++;
}
if(list.get(i).getDifficulty() == 3 && hard_counter < 1) {
	Questions.add(list.get(i));
	hard_counter++;
}
}

HttpSession currSession = request.getSession();
currSession.setAttribute("quiz", Questions);

int q = 0;
%>



<form id="form1" method="post" action="SubmitQuiz">
    <% for(int i = 0; i < Questions.size(); i++) {
        if(Questions.get(i).getType().equals("multiplechoice")) {
  	%>
  	    <p> <% out.println(q+1); %>) <% out.println(list.get(i).getText()); Set<Answer> la = new HashSet<Answer>();la = list.get(i).getAnswers(); %> </p>
		  <ul>
		      <% for(Answer a:la) {
			      int l = 1;%>
			      <li>
			          <label for="answerA">
				      <input type="radio" id="answerA" name="question<% out.print(q); %>" value="<% out.print(a.getAnswerId()); %>" />
                          <% out.println(a.getText());
                          l++;%>
				      </label>
			      </li>
			  <%} %>
		  </ul> 
    <%  
	    q++;
    
    } else if(Questions.get(i).getType().equals("numberinput")) {
  	%>
  	    <p> <% out.println(q+1); %>) <% out.println(list.get(i).getText()); Set<Answer> la = new HashSet<Answer>();la = list.get(i).getAnswers(); %> </p>

	    <label for="answerA">
        <input "margin-left:12em;" type="number" id="answer" name="question<% out.print(q); %>" value ="">				</label>
    <%  
	    q++;
    
    } else if(Questions.get(i).getType().equals("textinput")) {
  	%>
  	    <p> <% out.println(q+1); %>) <% out.println(list.get(i).getText()); Set<Answer> la = new HashSet<Answer>();la = list.get(i).getAnswers(); %> </p>

	    <label for="answerA">
        <input "margin-left:12em;" type="text" id="answer" name="question<% out.print(q); %>" value ="">				</label>
    <%  
	    q++;
    
    } else if(Questions.get(i).getType().equals("checkbox")) {
  	%>
  	    <p> <% out.println(q+1); %>) <% out.println(list.get(i).getText()); Set<Answer> la = new HashSet<Answer>();la = list.get(i).getAnswers(); %> </p>
  		<ul>
  		    <% for(Answer a:la) {
  			    int l = 1;%>
  				<li>
  				    <label for="answerA">
  					<input type="checkbox" id="answerA" name="question<% out.print(q); %>" value="<% out.print(a.getAnswerId()); %>" />
  	                <% out.println(a.getText());
  	                l++;%>
  		            </label>
  				</li>
  		    <%
  		    } %>
  		</ul> 
  	<%  
  		q++;
  	}   
}

%>  
<br/>
<p class="buttonSet">
<button type="reset" id="resetButton" value="reset">Reset</button>
<button type="submit" id="submitButton" value="Apply">Submit</button>
</p>   				   
</form> 
</body>
</html>