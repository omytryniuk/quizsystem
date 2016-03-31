<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.indigo-pink.min.css">
  <link rel="stylesheet" href="assets/stylesheets/style.css" type="text/css">
  <link rel="stylesheet" href="assets/stylesheets/user.css" type="text/css">
  
  <script defer src="https://code.getmdl.io/1.1.3/material.min.js"></script>
  
  
  
  <title>Login form</title>
</head>
<body>
<div class="UserCard mdl-card mdl-shadow--6dp">

  <div class="mdl-card__title">
    <h3 class="mdl-card__title-text">Login</h3>
  </div>
  
  <form action="Login" method=post>
  <div class="mdl-card__supporting-text">
  
    <p style="color:red"> ${message} </p>
    
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
      <input class="mdl-textfield__input" type="email" id="email" name="email">
      <label class="mdl-textfield__label" for="email">Email Address</label>
    </div>
    
   <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
      <input class="mdl-textfield__input" type="password" id="password" name="password">
      <label class="mdl-textfield__label" for="password">Password</label>
    </div>
      
    
  </div>
  
  <div class="mdl-card__actions mdl-card--border">
    <button type="submit" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">Submit</button>
  </div>
  </form>
</div>
 
</form>
</body>
</html>