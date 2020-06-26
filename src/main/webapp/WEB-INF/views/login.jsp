
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    

<html>
<head>
<title>Login Page</title>
</head>

<body>

		<form:form action="dologin" method="post">

			<table width=80%>
			
					<tr>
						<td>User name :</td>
						<td><input type="text" name="username" /></td>
					</tr>
					<tr>
						<td>Password : </td>
						<td><input type="password" name="password"/></td>
					</tr>
					<tr>
					<td>
					<input type="submit" value="submit" >
					 </td>
					</tr>
			</table>
		
		</form:form>
			
			<a href="/register"> Register</a>

</body>
</html>