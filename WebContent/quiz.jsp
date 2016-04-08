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

<script>
function validateForm() {

	var quantity =0;
	var checked = 0;
	var dd;
	var select = document.getElementsByTagName("select").length;

	for(var c =0;c<6;c++){
			var radios = document.getElementsByName("question"+c);
			if(radios.length>1)
				quantity++;
				dd=0;
				for(var i=0; i<radios.length;i++){
					if (radios[i].checked)
				       dd++;
 				}
				if (dd>0){
					checked++;
				}
		
	}
	
	checked+=select;
//	alert("C: "+checked);
//	alert("Q: "+quantity);
//	alert("S: "+select);
	
	

	if(quantity==checked)
		return true;
	else{
		alert("Please, fill all fields")
		return false;
	}
		
	
}
</script>

</head>
<body>

<%
//HttpSession currSession = request.getSession();
 
//if(currSession.getAttribute("isLoggedIn") == null) {
//	response.sendRedirect("login.jsp");
//}
%>

<%

SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
Session ses = sessionFactory.openSession();
List<Question> list = ses.createCriteria(Question.class).list();
List<Question> Questions = new ArrayList<Question>();
String difficulty = "";
int easy_counter = 0;
int medium_counter = 0;
int hard_counter = 0;

Collections.shuffle(list);

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
System.out.println("size is: "+ Questions.size());

int q = 0;
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


    <form id="form1" method="post" action="SubmitQuiz" onsubmit="return validateForm()">
    <% for(int i = 0; i < Questions.size(); i++) {
        if(Questions.get(i).getType().equals("multiplechoice")) {
  	%>
  	<div class="mdl-card mdl-shadow--2dp QuestionCard">
      <div class="mdl-card__title">
        <h4 class="mdl-card__title-text"> <% out.println(q+1); %>) <% out.println(Questions.get(i).getText()); Set<Answer> la = new HashSet<Answer>();la = Questions.get(i).getAnswers(); %> </h4>
      </div>
      <div class="mdl-card__supporting-text">
		  <ul class="demo-list-control mdl-list">
		      <% for(Answer a:la) {
			      int l = 1;%>
			      <li class="mdl-list__item">
		              <!--<span class="mdl-list__item-secondary-action">
                          <label class="question-list-radio mdl-radio mdl-js-radio mdl-js-ripple-effect" for="answerA">
                              <input type="radio" id="answerA" class="mdl-radio__button" name="question<% out.print(q); %>" value="<% out.print(a.getAnswerId()); %>" />
                          </label>
                      </span>
                      <span class="mdl-list__item-primary-content">
			              <% out.println(a.getText());
                          l++;%>
		              </span>-->
			          <label for="answerA">
				          <input type="radio" id="answerA" name="question<% out.print(q); %>" value="<% out.print(a.getAnswerId()); %>" />
                          <% out.println(a.getText());
                          l++;%>
				      </label>
			      </li>
			  <%} %>
		  </ul>
		</div>
	</div>
		
    <%  
	    q++;
    
    } else if(Questions.get(i).getType().equals("numberinput")) {
  	%>
  	    <div class="mdl-card mdl-shadow--2dp QuestionCard">
  	    
  	    <div class="mdl-card__title">
  	    <h4 class="mdl-card__title-text"> <% out.println(q+1); %>) <% out.println(Questions.get(i).getText()); Set<Answer> la = new HashSet<Answer>();la = Questions.get(i).getAnswers(); %> </h4>
  	    </div>
  	    
  	    <div class="mdl-card__supporting-text">
	    <label for="answerA">
        <input "margin-left:12em;" type="number" id="answer" name="question<% out.print(q); %>" value ="" required>				</label>
        </div>
        
        </div>
    <%  
	    q++;
    
    } else if(Questions.get(i).getType().equals("textinput")) {
  	%>
  	    <div class="mdl-card mdl-shadow--2dp QuestionCard">
  	
  	    <div class="mdl-card__title">
  	    <h4 class="mdl-card__title-text"> <% out.println(q+1); %>) <% out.println(Questions.get(i).getText()); Set<Answer> la = new HashSet<Answer>();la = Questions.get(i).getAnswers(); %> </h4>
  	    </div>
  	    
  	    <div class="mdl-card__supporting-text">
	    <label for="answerA">
        <input "margin-left:12em;" type="text" id="answer" name="question<% out.print(q); %>" value ="" required>				</label>
        </div>
        
        </div>
    <%  
	    q++;
    
    } else if(Questions.get(i).getType().equals("checkbox")) {
  	%>
  	    <div class="mdl-card mdl-shadow--2dp QuestionCard">
  	    
  	    <div class="mdl-card__title">
  	    <h4 class="mdl-card__title-text"> <% out.println(q+1); %>) <% out.println(Questions.get(i).getText()); Set<Answer> la = new HashSet<Answer>();la = Questions.get(i).getAnswers(); %> </h4>
  	    </div>
  	    
  	    <div class="mdl-card__supporting-text">
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
  		</div>
  		
  		</div>
  	<%  
  		q++;
  	} else if(Questions.get(i).getType().equals("dropdown")) {
  	%>
  	    <div class="mdl-card mdl-shadow--2dp QuestionCard">
  	
  	    <div class="mdl-card__title">
  	    <h4 class="mdl-card__title-text"> <% out.println(q+1); %>) <% out.println(Questions.get(i).getText()); Set<Answer> la = new HashSet<Answer>();la = Questions.get(i).getAnswers(); %> </h4>
  	    </div>
  	    
  	    <div class="mdl-card__supporting-text">
  	    <select name="question<% out.print(q); %>">
		      <% for(Answer a:la) {
			      int l = 1;%>
				      <option id="answerA" name="question<% out.print(q); %>" value="<% out.print(a.getAnswerId()); %>" ><% out.println(a.getText());%></option>
                          <% out.println(a.getText());
                          l++;%>
			  <%} %>
		  </select>
		 </div>
		  
		</div>
    <%  
	    q++;
    
    }  
}

%>  
<br/>

<div class="ButtonSetCard">
<span>
<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored" type="reset" id="resetButton" value="reset">Reset</button>
<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored" type="submit" id="submitButton" value="Apply">Submit</button>
</span>
</div>

</form> 
</main>
</div>
</body>
</html>