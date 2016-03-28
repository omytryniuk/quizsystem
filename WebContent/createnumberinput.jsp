<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Create Numerical Input Question</title>
    <meta charset="utf-8">
    <link href="form.css" rel="stylesheet">
  </head>
  <body>
    <div class="main">
	  <form id="form1" method="post" action="CreateInputQuestion">
	    <header>
	      <h2>Create Number Input Question</h2>
		</header>
		<section id="basic">
      <p class="textLabel">Question Text</p>
      <textarea name="questionText"></textarea><br/>
      <p class="textLabel">Answer</p>
      <input "margin-left:12em;" type="number" id="answer" name="answer" min="-99999" max="999999999999"><br>
      <p class="textLabel">Answer explanation</p>
      <textarea name="answerexpl"></textarea>  
      <input type="hidden" name="qtype" value="numberinput">	
      <fieldset> 
      <legend>Difficulty of the Question</legend>
      <ul>
        <li>
          <label for="easyq">
        <input type="radio" id="easy" name="difftype" value="1" />
        Easy
        </label>
        </li>
        <li>
          <label for="middleq">
        <input type="radio" id="middle" name="difftype" value="2" />
        Middle
        </label>
        </li>
        <li>
          <label for="hardq">
        <input type="radio" id="hard" name="difftype" value="3" />
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
