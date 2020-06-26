<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>

<style type="text/css">
.user{

		background:lightblue;
		text-align: center;
		text-shadow: black;
}
</style>

<title>Register Page</title>

</head>

<body>

		<form:form method="post" action="registert" class="user">    
        <table  width=60%>    
         <tr>    
         <td>User Name : </td>
          <td><form:input path="username"  /></td>  
         </tr>    
         <tr>    
         <td>Last Name : </td>
          <td><form:input path="lastName" /></td>  
         </tr>   
         <tr>    
          <td>Mobile Number : </td>
          <td><form:input path="mobileNumber" /></td>  
         </tr>   
         <tr>    
          <td>Password : </td>
          <td><form:input type="password" path="password" /></td>  
         </tr>   
         
         <tr>    
           
          <td><input type="submit" value="Submit" /></td>    
         </tr>    
        </table>    
       </form:form>    
		

</body>

</html>