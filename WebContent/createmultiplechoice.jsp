<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <title>Create Multiple Choice Question</title>
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
  
    <div class="main">
	  <form id="form1" method="post" action="CreateQuestion">
	    <header>
	      <h2>Create Multiple Choise Question</h2>
		</header>
		<section id="basic">
      <p class="textLabel">Question Text</p>
      <textarea name="questionText"></textarea>
      <p class="textLabel">Option A</p>
      <textarea name="answerA"></textarea>
      <p class="textLabel">Option B</p>
      <textarea name="answerB"></textarea>
      <p class="textLabel">Option C</p>
      <textarea name="answerC"></textarea>
      <p class="textLabel">Option D</p>
      <textarea name="answerD"></textarea> 
       <p class="textLabel">Answer explanation</p>
      <textarea name="answerexpl"></textarea>  
      <input type="hidden" name="qtype" value="multiplechoice">
		  <fieldset>
		    <legend>Correct Answer</legend>
			<ul>
			  <li>
			    <label for="answerA">
				<input type="radio" id="answerA" name="answer" value="0" />
				A
				</label>
			  </li>
			  <li>
			    <label for="answerB">
				<input type="radio" id="answerB" name="answer" value="1" />
				B
				</label>
			  </li>
			  <li>
			    <label for="answerC">
				<input type="radio" id="answerC" name="answer" value="2" />
				C
				</label>
			  </li>
			  <li>
			    <label for="answerD">
				<input type="radio" id="answerD" name="answer" value="3" />
				D
				</label>
			  </li>
			</ul>
			  </fieldset> 
			<fieldset> 
			<legend>Difficulty of the Answer</legend>
			<ul>
			  <li>
			    <label for="easyq">
				<input type="radio" id="easyt" name="difftype" value="1" />
				Easy
				</label>
			  </li>
			  <li>
			    <label for="middleq">
				<input type="radio" id="middlet" name="difftype" value="2" />
				Middle
				</label>
			  </li>
			  <li>
			    <label for="hardq">
				<input type="radio" id="hardt" name="difftype" value="3" />
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