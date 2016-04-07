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

<div class="LoginCard mdl-card mdl-shadow--6dp">

  <div class="mdl-card__title">
    <h5 class="mdl-card__title-text">Login</h5>
  </div>
  
  <form action="Login" method=post>
  <div class="mdl-card__supporting-text">
  
    <h5 style="color:orange"> ${message} </h5>
    
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

<button onclick="location.href='index.jsp';" class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--primary backButton">
        <i class="material-icons">keyboard_backspace</i>
      </button>
 
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