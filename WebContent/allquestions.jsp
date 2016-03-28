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
HttpSession currSession = request.getSession();
 
if(currSession.getAttribute("isLoggedIn") == null) {
	response.sendRedirect("login.jsp");
}
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
                <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Create questions<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                             <li><a href="createcheckbox.jsp">Check Boxes</a></li>
                           <li><a href="createmultiplechoice.jsp">Multiple Choice</a></li>
                           <li><a href="createnumberinput.jsp">Numeric input</a></li>
                           <li><a href="createtextinput.jsp">Text input</a></li>
                       </ul>
                 </li>
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
String hello = "hello";
%>

Are you logged in? - <%= request.getSession().getAttribute("isLoggedIn") %>

<% for(int i=0; i<list.size();i++){%>
	<hr>
	<p> Question: <% out.println(list.get(i).getText()); Set<Answer> la = new HashSet<Answer>(); la = list.get(i).getAnswers();%>
	<br>Difficulty:<% out.println(list.get(i).getDifficulty()); %> </p>
	<p><a href="/Assignment2/DeleteQuestion?id=<%=list.get(i).getQuestionId()%>">DELETE
	   </a>&nbsp;&nbsp;<a href="/Assignment2/EditQuestion?id=<%=list.get(i).getQuestionId()%>">EDIT</a>
	</p>
    <% for(Answer a:la){%>
    	<p><% out.println(a.getText());%> &nbsp; <% out.println(a.isCorrect());%></p>
    <% }%><p>Correct answer is <%out.println(list.get(i).getAnswerExplained()); %></p><% } %>
    <a href="createquestion.jsp">CREATE </a><br>
</body>
</html>