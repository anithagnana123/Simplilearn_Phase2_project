<%@ page errorPage = "error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<html>
<head>
    <title>classsub-list</title>
</head>
<body>
    <sql:setDataSource 
    var="database" 
    driver="com.mysql.cj.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/learners_academy?allowPublicKeyRetrieval=true&useSSL=false"
     user="root"
     password="123456"
     />
     
     
<h2>Add a student</h2>    

<br> <br>


<form action="test"  method="get">
  <table>
	 <tr>
	   <td>Enter the first name</td>
	   <td> <input type='text' name='firstName'> </td>
	 </tr>
	 <tr>
	   <td>Enter the last name</td>
	   <td> <input type='text' name='lastName'> </td>
	 </tr>
	 <tr>
	   <td>Enter the D.O.B</td>
	   <td> <input type='text' name='dateOfBirth'> </td>
	 </tr>
	 
    <sql:query var="rs" dataSource="${database}">
         SELECT * FROM class_info;
    </sql:query>    
    
    <tr>
        Select class and section :    
        <select name = "class_sec">
             <c:forEach var="class_info" items="${rs.rows}">
                 <option> <c:out value="${class_info.class_sec}"/> </option>
             </c:forEach>
        </select>
    </tr>

    <br> <br>
    <tr>  
      <td><input type="submit" value="submit"/></td>
      <td><input type="hidden" name="operation" value="addstudent"/></td>  
    </tr>
</table>
</form>

<br> <br>
<form action="welcome" method="get">
	<input type="submit" value="home page"/>
</form>

</body>
</html>