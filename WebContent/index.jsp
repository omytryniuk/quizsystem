<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  
  <link rel="stylesheet" href="assets/stylesheets/style.css" type="text/css">
  <link rel="stylesheet" href="assets/stylesheets/index.css" type="text/css">
  
  <link rel="stylesheet" href="./assets/mdl/material.min.css">
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

</body>
</html>