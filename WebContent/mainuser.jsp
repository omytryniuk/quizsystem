<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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



  <p style="color:red"> ${name}, Welcome back. Your status is User </p>
  
  <a href="StartQuiz">START QUIZ</a><br>
 
</body>
</html>