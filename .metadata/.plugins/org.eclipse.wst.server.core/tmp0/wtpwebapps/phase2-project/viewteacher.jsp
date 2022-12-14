<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<html>
<head>
    <title>viewteacher-list</title>
</head>
<body>
    <sql:setDataSource 
    var="database" 
    driver="com.mysql.cj.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/learners_academy?allowPublicKeyRetrieval=true&useSSL=false"
     user="root"
     password="123456"
     />
     
     
<h2>Master List of Teachers</h2>     
<sql:query var="rs" dataSource="${database}">
    SELECT * FROM teacher order by teacher_id asc;
</sql:query>    
<table border="2" width="100%">
    <tr>
        <td><b>Teacher ID</b></td>
        <td><b>First Name</b></td>
        <td><b>Last Name</b></td>
        <td><b>Experience</b></td>
        <td><b>Qualification</b></td>
    </tr>
    
    <c:forEach var="teacher" items="${rs.rows}">
        <tr>
            <td> <c:out value="${teacher.teacher_id}"/> </td>
            <td> <c:out value="${teacher.teacher_firstName}"/> </td>
            <td> <c:out value="${teacher.teacher_lastName}"/> </td>
            <td> <c:out value="${teacher.experience}"/> </td>
            <td> <c:out value="${teacher.qualification}"/> </td>
        </tr>
    </c:forEach>
</table>

<form action='welcome' method='get'>
	 <br> <input type='submit' value='home page'/>
</form>

</body>
</html>