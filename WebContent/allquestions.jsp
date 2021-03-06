<%@ page import="java.util.*,org.hibernate.Session,org.hibernate.SessionFactory,org.hibernate.cfg.Configuration,ca.myseneca.a2.Question,ca.myseneca.a2.Answer" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="assets/stylesheets/style.css" type="text/css">
  
  <link rel="stylesheet" href="./assets/mdl/material.min.css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <script src="./assets/mdl/material.min.js"></script>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<%
HttpSession currSession = request.getSession();
 
if(currSession.getAttribute("isLoggedIn") == null) {
	response.sendRedirect("login.jsp");
}
%>

  <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
  
    <header class="mdl-layout__header">
      <div class="mdl-layout__header-row">
        <a class="homeButton" href="index.jsp">
          <i class="material-icons">home</i>
        </a>
        <span class="mdl-layout__title">ROME Quiz System</span>
        <div class="mdl-layout-spacer"></div>
        <a href="Logoff" class="logoutButton">Log-out</a>
      </div>
    </header>
    
    <main class="mdl-layout__content">
    
      <button onclick="location.href='mainadmin.jsp';" class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--primary backButton">
        <i class="material-icons">keyboard_backspace</i>
      </button>

<%
SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
Session ses = sessionFactory.openSession();
List<Question> list = ses.createCriteria(Question.class).list();
String hello = "hello";
%>

<% for(int i=0; i<list.size();i++){%>

      <div class="mdl-card mdl-shadow--2dp QuestionCard">
        <div class="mdl-card__title">
          <h4> Question: <% out.println(list.get(i).getText()); Set<Answer> la = new HashSet<Answer>(); la = list.get(i).getAnswers();%>
          <br>Difficulty:<% out.println(list.get(i).getDifficulty()); %> </h4>
        </div>
        <div class="mdl-card__supporting-text">
	
    <% for(Answer a:la){%>
    	<p><% out.println(a.getText());%> &nbsp; <% out.println(a.isCorrect());%></p>
    <% }%><p>Correct answer is <%out.println(list.get(i).getAnswerExplained()); %></p><p><a href="DeleteQuestion?id=<%=list.get(i).getQuestionId()%>">DELETE
	   </a>&nbsp;&nbsp;<a href="EditQuestion?id=<%=list.get(i).getQuestionId()%>">EDIT</a>
	</p>
	
        </div>
      </div>

<% } %>

    </main>
  </div>
</body>
</html>