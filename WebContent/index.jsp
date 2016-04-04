<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  
  <link rel="stylesheet" href="assets/stylesheets/style.css" type="text/css">
  <link rel="stylesheet" href="assets/stylesheets/index.css" type="text/css">
  
  <link rel="stylesheet" href="./assets/mdl/material.min.css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <script src="./assets/mdl/material.min.js"></script>
  
  <title>Welcome to QUIZ Manager System</title>
</head>
  <body>
  
   <%
    HttpSession currSession = request.getSession();
 
    if(currSession.getAttribute("isLoggedIn") != null) {
	  	if(currSession.getAttribute("userType").equals("Admin"))
    		response.sendRedirect("mainadmin.jsp");
    	else
    			response.sendRedirect("mainuser.jsp");
    			
    }
  %>
  
  <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
  
    <header class="mdl-layout__header">
      <div class="mdl-layout__header-row">
        <a class="homeButton" href="index.jsp">
          <i class="material-icons">home</i>
        </a>
        <span class="mdl-layout__title">ROME Quiz System</span>
      </div>
    </header>
    
    <main class="mdl-layout__content">
      <div class="indexCard">
        <a href="registration.jsp">
          <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored mdl-js-ripple-effect">
            Register
          </button>
        </a>
        <a href="login.jsp">
          <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored mdl-js-ripple-effect">
            Log In
          </button>
        </a>
      </div>
      
    </main>
    
    <footer class="mdl-mini-footer">
      <div class="mdl-mini-footer__left-section">
        <div class="mdl-logo">
          Team ROME
        </div>
        <ul class="mdl-mini-footer__link-list">
          <li><a href="#">About</a></li>
          <li><a href="#">Technologies</a></li>
          <li><a href="#">Members</a></li>
        </ul>
      </div>
    </footer>
    
  </div>

</body>
</html>