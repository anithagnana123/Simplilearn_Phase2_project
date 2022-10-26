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
     url="jdbc:mysql://localhost:3306/learners_academy_test?allowPublicKeyRetrieval=true&useSSL=false"
     user="root"
     password="123456"
     />
     
     
<h2>Assign class for a subject</h2>     

<br> <br>


<form action="test"  method="get">
<p>Enter the subject name </p>
<p><input type="text" name="subject"/></p>

<table>
    
    <sql:query var="rs" dataSource="${database}">
         SELECT * FROM class_info;
    </sql:query>    
    
    <tr>
        Standard :    
        <select name = "standard">
             <c:forEach var="class_info" items="${rs.rows}">
                 <option> <c:out value="${class_info.standard}"/> </option> 
             </c:forEach>
        </select>
    </tr>  
    <br> <br>

    <tr>
        Section :    
        <select name = "class_sec">
             <c:forEach var="class_info" items="${rs.rows}">
                 <option> <c:out value="${class_info.class_sec}"/> </option>
             </c:forEach>
        </select>
    </tr>

    <br> <br>
    <tr>  
      <td><input type="submit" value="submit"/></td>
      <td><input type="hidden" name="operation" value="assignclasssub"/></td>  
    </tr>
</table>
</form>

<br> <br>
<form action="welcome" method="get">
	<input type="submit" value="home page"/>
</form>

</body>
</html>