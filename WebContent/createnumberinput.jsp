<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>  
    <link rel="stylesheet" href="assets/stylesheets/style.css" type="text/css">
    <link rel="stylesheet" href="./assets/mdl/material.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="./assets/mdl/material.min.js"></script>
    <title>Create Numerical Input Question</title>
    <meta charset="utf-8">
    <link href="form.css" rel="stylesheet">
  </head>
  <body>
  
  <%
    HttpSession currSession = request.getSession();
 
    if(currSession.getAttribute("isLoggedIn") == null) {
	    response.sendRedirect("login.jsp");
    }
  %>
  
  <% String post = "CreateInputQuestion";
	int diff=0;
	if(request.getParameter("id")!=null){
		post+="?id="+request.getParameter("id");
		diff = (Integer)request.getAttribute("diff");
		System.out.println("difficult type "+diff);
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
        <div class="CreateQuestionCard mdl-card mdl-shadow--6dp">
	    <form id="form1" method="post" action="<%=post%>" >
	    <header>
	      <h2>Create Number Input Question</h2>
		</header>
		<section id="basic">
      <p class="textLabel">Question Text</p>
         <textarea name="questionText">${questionText}</textarea><br/>
      <p class="textLabel">Answer</p>
      <input "margin-left:12em;" type="number" id="answer" name="answer" min="-99999" max="999999999999" value ="${answer}"><br>
      <p class="textLabel">Answer explanation</p>
      <textarea name="answerexpl">${answerexpl}</textarea>  
      <input type="hidden" name="qtype" value="numberinput">	
          <fieldset> 
      <legend>Difficulty of the Question</legend>
      <ul>
        <li>
          <label for="easyq">
        <input type="radio" id="easy" name="difftype" <% if(diff==1){%> checked <%}%> value="1" />
        Easy
        </label>
        </li>
        <li>
          <label for="middleq">
        <input type="radio" id="middle" name="difftype" <% if(diff==2){%> checked <%}%> value="2" />
        Medium
        </label>
        </li>
        <li>
          <label for="hardq">
        <input type="radio" id="hard" name="difftype" <% if(diff==3){%> checked <%}%> value="3" />
        Hard
        </label>
        </li>
        </ul>
      </fieldset>                 
		  <p class="buttonSet">
		    <button type="reset" id="resetButton" value="reset">Reset</button>
			<button type="submit" id="submitButton" value="Apply">Create</button>
		  </p> 
		</section>
		<footer>
		</footer>
	  </form>
    
    </div>
    </main>
    
  </body>
</html>
