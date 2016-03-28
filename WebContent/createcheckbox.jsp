<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Create Multiple Answer Question</title>
    <meta charset="utf-8">
    <link href="form.css" rel="stylesheet">
  </head>
  <body>
    <div class="main">
	 <form id="form1" method="post" action="CreateQuestion">
	    <header>
	      <h2>Create Multiple Choice Question</h2>
		</header>
		<section id="basic">
      <p class="textLabel">Question Text</p>
      <textarea name="questionText"></textarea><br/>
      Check all answers that are true
      <p class="textLabel">Option A</p>
  <input style="width:15px"type="checkbox" name="answer" id="optionA" value="0"><textarea name="answerA"></textarea><br>
      <p class="textLabel">Option B</p>  
  <input style="width:15px"type="checkbox" name="answer" id="optionB" value="1"><textarea name="answerB"></textarea><br> 
      <p class="textLabel">Option C</p>  
  <input style="width:15px"type="checkbox" name="answer" id="optionC" value="2"><textarea name="answerC"></textarea><br>
        <p class="textLabel">Option D</p> 
  <input style="width:15px"type="checkbox" name="answer" id="optionD" value="3"><textarea name="answerD"></textarea><br>                           
   <p class="textLabel">Answer explanation</p>
      <textarea name="answerexpl"></textarea>  
      <input type="hidden" name="qtype" value="checkbox">	
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














