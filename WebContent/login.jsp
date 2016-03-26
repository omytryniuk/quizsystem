<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.indigo-pink.min.css">
  
  <link rel="stylesheet" href="style.css" type="text/css">
  
  <script defer src="https://code.getmdl.io/1.1.3/material.min.js"></script>
  
  <title>Insert title here</title>
</head>
<body>
Welcome to login page
<h4>Login please</h4>
    <hr />
 
  <form action="Login" method=post onsubmit="return validate(this);">
  <p style="color:red"> ${message} </p>
  <div class="form-group">
    <label for="email">Email address</label>
    <input type="email" class="form-control" name="email" placeholder="Email">
  </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control" name="password" placeholder="Password">
  </div>
  
  <button type="submit" class="btn btn-default">Submit</button>
</form>
</body>
</html>