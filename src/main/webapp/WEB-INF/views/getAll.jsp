
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
   <!DOCTYPE html>
<html>
<head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>

<h2>Students Record</h2>

<table>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Subject</th>
    <th>Marks</th>
    <th>Address</th>
    <th>Update</th>
    <th>Delete</th>
  </tr>
  <tr>
    <c:forEach var="student" items="${list}">
<tr>
			<td>${student.id}</td>
			<td>${student.name}</td>
			<td>${student.subject}</td>
			<td>${student.marks}</td>
			<td>${student.address}</td>
			<td><a href="/students/editStudent/${student.id}" />edit</td>
			<td><a href="/students/deleteStudent/${student.id}" />delete</td>

</tr>
		</c:forEach>
  </tr>

</table>

    <br>       
       <br>
<a href="/students/createStudent">Add New Student</a>
       <br>
<a href="/students/home">To Home Page</a>
<a href="/perform_logout">Logout</a>

</body>
</html> 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    













