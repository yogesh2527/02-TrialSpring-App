
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
  
  <!DOCTYPE html>
  <html>
  
  <head>
  	<title> Create New Employee </title>
  
  </head>
  
  
  <body>
  
  
  <h2>Creating New Student</h2>
 
  <br><br>
  

 <form:form method="post" action="save" >    
        <table >    
         <tr>    
         <td>Name : </td>
          <td><form:input path="name"  /></td>  
         </tr>    
         <tr>    
         <td>Subject : </td>
          <td><form:input path="subject" /></td>  
         </tr>   
         <tr>    
          <td>Marks : </td>
          <td><form:input path="marks" /></td>  
         </tr>   
         <tr>    
          <td>Address : </td>
          <td><form:input path="address" /></td>  
         </tr>   
         
         <tr>    
           
          <td><input type="submit" value="Submit" /></td>    
         </tr>    
        </table>    
       </form:form>    
           <br>
      <a href="/students/home">To Home Page</a>
      <br>
      <a href="/students/getAll ">Get All Student Informations</a>
  </body>
  
  </html>