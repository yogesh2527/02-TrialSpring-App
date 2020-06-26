
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<h2>Student List</h2>

<table border=4 , width=70%, cellpadding=4>
<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Subject</th>
		<th>Marks</th>
		<th>Address</th>
		<th>Edit</th>
		<th>Delete</th>
</tr>

		<c:forEach var="student" items="${list}">
<tr>
			<td>${student.id}</td>
			<td>${student.name}</td>
			<td>${student.subject}</td>
			<td>${student.marks}</td>
			<td>${student.address}</td>
			<td><a href="/edit/${student.id}">edit</td>
			<td><a href="/students/getAll/${student.id}">delete</td>

</tr>
		</c:forEach>
</table>


</body>
</html>