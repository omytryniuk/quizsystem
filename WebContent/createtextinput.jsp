<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Create Text Input Question</title>
    <meta charset="utf-8">
    <link href="form.css" rel="stylesheet">
  </head>
  <body>
  
 
<% 	String answer = request.getParameter("id"); 
String s = (String)request.getAttribute("questionText");
Integer dodo = (Integer)request.getAttribute("diff");
System.out.println("S is " + s);
System.out.println("Dodo is " + dodo);
String post = "CreateInputQuestion";
	if(answer!=null){
		post+="?id="+answer;
		
	
	}
 %>			
  
    <div class="main">
	  <form id="form1" method="post" action="<%=post%>" >
	    <header>
	      <h2>Create Text Input Question</h2>
		</header>
		<section id="basic">
      <p class="textLabel">Question Text</p>
      <textarea name="questionText">${questionText}</textarea><br/>
      <p class="textLabel">Answer</p>
  <input "margin-left:12em;" type="text" id="answer" name="answer" value ="${answer}"><br>
   <p class="textLabel">Answer explanation</p>
      <textarea name="answerexpl">${answerexpl}</textarea>  
      <input type="hidden" name="qtype" value="textinput">	
      <fieldset> 
      <legend>Difficulty of the Question</legend>
      <ul>
        <li>
          <label for="easyq">
        <input type="radio" id="easy" name="difftype" <% if(dodo==1){%> checked <%}%>  value="1" />
        Easy
        </label>
        </li>
        <li>
          <label for="middleq">
        <input type="radio" id="middle" name="difftype" <% if(dodo==2){%> checked <%}%> value="2" />
        Middle
        </label>
        </li>
        <li>
          <label for="hardq">
        <input type="radio" id="hard" name="difftype" <% if(dodo==3){%> checked <%}%> value="3" />
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
  </body>
</html>
