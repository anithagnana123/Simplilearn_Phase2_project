<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<html>
<head>
    <title>classsubteach-list</title>
</head>
<body>
    <sql:setDataSource 
    var="database" 
    driver="com.mysql.cj.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/learners_academy?allowPublicKeyRetrieval=true&useSSL=false"
     user="root"
     password="123456"
     />
     
     
<h2>Master List of all classes and subjects assigned to a teacher</h2>     
<sql:query var="rs" dataSource="${database}">
    SELECT * FROM class_sub_teach order by class_sec asc;
</sql:query>    
<table border="2" width="100%">
    <tr>
        <td><b>Class</b></td>
        <td><b>Subject</b></td>
         <td><b>Teacher</b></td>
    </tr>
    
    <c:forEach var="class_sub_teach" items="${rs.rows}">
        <tr>
            <td> <c:out value="${class_sub_teach.class_sec}"/> </td>
            <td> <c:out value="${class_sub_teach.subject}"/> </td>
            <td> <c:out value="${class_sub_teach.teacher_id}"/> </td>
        </tr>
    </c:forEach>
</table>

<form action='welcome' method='get'>
	 <br> <input type='submit' value='home page'/>
</form>

</body>
</html>