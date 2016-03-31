<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	int correct = 0;
	if(request.getParameter("id")!=null){
		post+="?id="+request.getParameter("id");
		diff = (Integer)request.getAttribute("diff");
		correct = (Integer)request.getAttribute("correct");
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
      <textarea name="questionText">${questionText}</textarea>
      <p class="textLabel">Option A</p>
      <textarea name="answerA">${A1}</textarea>
      <p class="textLabel">Option B</p>
      <textarea name="answerB">${A2}</textarea>
      <p class="textLabel">Option C</p>
      <textarea name="answerC">${A3}</textarea>
      <p class="textLabel">Option D</p>
      <textarea name="answerD">${A4}</textarea> 
       <p class="textLabel">Answer explanation</p>
      <textarea name="answerexpl">${answerexpl}</textarea>  
      <input type="hidden" name="qtype" value="dropdown">
		  <fieldset>
		    <legend>Correct Answer</legend>
			<ul>
			  <li>
			    <label for="answerA">
				<input type="radio" id="answerA" name="answer" <% if(correct==0){%> checked <%}%> value="0" />
				A
				</label>
			  </li>
			  <li>
			    <label for="answerB">
				<input type="radio" id="answerB" name="answer" <% if(correct==1){%> checked <%}%>  value="1" />
				B
				</label>
			  </li>
			  <li>
			    <label for="answerC">
				<input type="radio" id="answerC" name="answer" <% if(correct==2){%> checked <%}%>  value="2" />
				C
				</label>
			  </li>
			  <li>
			    <label for="answerD">
				<input type="radio" id="answerD" name="answer" <% if(correct==3){%> checked <%}%>  value="3" />
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
				<input type="radio" id="easyt" name="difftype" <% if(diff==1){%> checked <%}%>  value="1" />
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