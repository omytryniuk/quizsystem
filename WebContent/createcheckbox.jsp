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
  
  <%
    HttpSession currSession = request.getSession();
 
    if(currSession.getAttribute("isLoggedIn") == null) {
	    response.sendRedirect("login.jsp");
    }
  %>
  
   <% String post = "CreateQuestion";
	int diff=0;
	String[] correct = new String[4];
	if(request.getParameter("id")!=null){
		post+="?id="+request.getParameter("id");
		diff = (Integer)request.getAttribute("diff");
		correct = (String[])request.getAttribute("correct");
		//String[] correct = (String[])request.getAttribute("correct");
		System.out.println("difficult type "+diff);
	}

 %>
  
    <div class="main">
	 <form id="form1" method="post" action="<%=post%>" >
	    <header>
	      <h2>Create Multiple Choice Question</h2>
		</header>
		<section id="basic">
      <p class="textLabel">Question Text</p>
      <textarea name="questionText">${questionText}</textarea><br/>
      Check all answers that are true
      <p class="textLabel">Option A</p>
  <input style="width:15px"type="checkbox" name="answer" id="optionA" <% if(correct[0]=="1"){%> checked <%}%> value="0"><textarea name="answerA">${A1}</textarea><br>
      <p class="textLabel">Option B</p>  
  <input style="width:15px"type="checkbox" name="answer" id="optionB"  <% if(correct[1]=="1"){%> checked <%}%>   value="1"><textarea name="answerB">${A2}</textarea><br> 
      <p class="textLabel">Option C</p>  
  <input style="width:15px"type="checkbox" name="answer" id="optionC"  <% if(correct[2]=="1"){%> checked <%}%>  value="2"><textarea name="answerC">${A3}</textarea><br>
        <p class="textLabel">Option D</p> 
  <input style="width:15px"type="checkbox" name="answer" id="optionD"  <% if(correct[3]=="1"){%> checked <%}%>  value="3"><textarea name="answerD">${A4}</textarea><br>                           
   <p class="textLabel">Answer explanation</p>
      <textarea name="answerexpl">${answerexpl}</textarea>  
      <input type="hidden" name="qtype" value="checkbox">	
	<fieldset> 
			<legend>Difficulty of the Answer</legend>
			<ul>
			  <li>
			    <label for="easyq">
				<input type="radio" id="easyt" name="difftype" <% if(diff==1){%> checked <%}%> value="1" />
				Easy
				</label>
			  </li>
			  <li>
			    <label for="middleq">
				<input type="radio" id="middlet" name="difftype" <% if(diff==2){%> checked <%}%> value="2" />
				Middle
				</label>
			  </li>
			  <li>
			    <label for="hardq">
				<input type="radio" id="hardt" name="difftype" <% if(diff==3){%> checked <%}%> value="3" />
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