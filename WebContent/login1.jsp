<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/Assignment2/SA" method=post onsubmit="return checkform(this);">
   
 <p style="color:red"> ${message} </p>
   
  Your name:
   <input type="text" name="uname" value="${name}"/>
   <p><input type="submit" value="Submit"> 
   <input type="reset"  value="Reset">
   </p>
   </form>

</body>
</html>