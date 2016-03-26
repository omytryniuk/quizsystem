<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.indigo-pink.min.css">
  
  <link rel="stylesheet" href="style.css" type="text/css">
  <link rel="stylesheet" href="registration.css" type="text/css">
  
  <script defer src="https://code.getmdl.io/1.1.3/material.min.js"></script>
  
  <title>New user registration</title>
<script>
function validate(form)
{
    for (i = 0; i < form.length; i++){
    	
         if( (form.elements[i].value == "")){
           alert("You must provide a value for the field named: " +form.elements[i].value + "and "+ s);
           return false; 

           }
        }
        return true;
}
</script>


</head>
<body>

<div class="registrationCard mdl-card mdl-shadow--6dp">

  <div class="mdl-card__title">
    <h3 class="mdl-card__title-text">Create a new account</h3>
  </div>
  
  <form action="CreateUser" method=post onsubmit="return validate(this);">
  <div class="mdl-card__supporting-text">
  
    <p style="color:red"> ${message} </p>
    
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
      <input class="mdl-textfield__input" type="text" id="fname" name="fname">
      <label class="mdl-textfield__label" for="fname">First Name</label>
    </div>
    
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
      <input class="mdl-textfield__input" type="text" id="lname" name="lname">
      <label class="mdl-textfield__label" for="lname">Last Name</label>
    </div>
    
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
      <input class="mdl-textfield__input" type="email" id="email" name="email">
      <label class="mdl-textfield__label" for="email">Email Address</label>
    </div>
    
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
      <input class="mdl-textfield__input" type="password" id="password" name="password">
      <label class="mdl-textfield__label" for="password">Password</label>
    </div>
    
    <!--<div class="form-group">
      <label for="email">Email address</label>
      <input type="email" class="form-control" name="email" placeholder="Email">
    </div>
    <div class="form-group">
      <label for="password">Password</label>
      <input type="password" class="form-control" name="password" placeholder="Password">
    </div>
    <div class="form-group">
      <label for="fname">First Name</label>
      <input type="text" class="form-control" name="fname" placeholder="Your name">
    </div>
    <div class="form-group">
      <label for="lname">Last name</label>
      <input type="text" class="form-control" name="lname" placeholder="Last name">
    </div>-->
    <!--<button type="submit" class="btn btn-default">Submit</button>-->
  </div>
  
  <div class="mdl-card__actions mdl-card--border">
    <button type="submit" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">Submit</button>
  </div>
  </form>
</div>

<!--Welcome to registration
<h4>Create a new account.</h4>
    <hr /> 
 
  <form action="CreateUser" method=post onsubmit="return validate(this);">
  <p style="color:red"> ${message} </p>
  <div class="form-group">
    <label for="email">Email address</label>
    <input type="email" class="form-control" name="email" placeholder="Email">
  </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control" name="password" placeholder="Password">
  </div>
  <div class="form-group">
    <label for="fname">First Name</label>
    <input type="text" class="form-control" name="fname" placeholder="Your name">
  </div>
  <div class="form-group">
    <label for="lname">Last name</label>
    <input type="text" class="form-control" name="lname" placeholder="Last name">
  </div>
  
  <button type="submit" class="btn btn-default">Submit</button>
</form>-->
   
</body>
</html>