<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="assets/stylesheets/style.css" type="text/css">
  
  <link rel="stylesheet" href="./assets/mdl/material.min.css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <script src="./assets/mdl/material.min.js"></script>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
    HttpSession currSession = request.getSession();
 
    if(currSession.getAttribute("isLoggedIn") == null) {
	    response.sendRedirect("index.jsp");
    }
  %>

<!--<div class="navbar navbar-default navbar-fixed-top">
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
                           <li><a href="createdropdown.jsp">Dropdown</a></li>
                           <li><a href="createmultiplechoice.jsp">Multiple Choice</a></li>
                           <li><a href="createnumberinput.jsp">Numeric input</a></li>
                           <li><a href="createtextinput.jsp">Text input</a></li>
                       </ul>
                 </li>
                    <li><a href="allquestions.jsp">All Questions</a></li>
                    <li><a href="Logoff">Log-out</a></li> 
                                       
                </ul>
            </div>             
        </div>
    </div>-->
    
<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
  
    <header class="mdl-layout__header">
      <div class="mdl-layout__header-row">
        <a class="homeButton" href="index.jsp">
          <i class="material-icons">home</i>
        </a>
        
        
        <!--<button id="demo-menu-lower-left"
        class="mdl-button mdl-js-button mdl-button--icon">
  <i class="material-icons">more_vert</i>
</button>-->

<button class="mdl-button mdl-js-button mdl-layout__title" id="demo-menu-lower-left" style="color: white;">Create Question</button>

<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="demo-menu-lower-left">
  <li class="mdl-menu__item mdl-menu__item--full-bleed-divider questionTypeButton"><a href="createcheckbox.jsp">Check Boxes</a></li>
  <li class="mdl-menu__item mdl-menu__item--full-bleed-divider questionTypeButton"><a href="createdropdown.jsp">Dropdown</a></li>
  <li class="mdl-menu__item mdl-menu__item--full-bleed-divider questionTypeButton"><a href="createmultiplechoice.jsp">Multiple Choice</a></li>
  <li class="mdl-menu__item mdl-menu__item--full-bleed-divider questionTypeButton"><a href="createnumberinput.jsp">Numeric input</a></li>
  <li class="mdl-menu__item mdl-menu__item--full-bleed-divider questionTypeButton"><a href="createtextinput.jsp">Text input</a></li>
</ul>

        
        
        <div class="mdl-layout-spacer"></div>
        <a href="Logoff" class="logoutButton">Log-out</a>
      </div>
    </header>
    
    <main class="mdl-layout__content">
    
    <div class="MainAdminCard">
        <a href="allquestions.jsp">
          <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored mdl-js-ripple-effect">
            All Question
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



  <!--<p style="color:red"> ${name}, Welcome back. Your status is Admin </p>
  <a href="#">CREATE A QUESTION</a><br>-->
 
</body>
</html>