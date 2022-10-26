<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<html>
<head>
    <title>viewclass-list</title>
</head>
<body>
    <sql:setDataSource 
    var="database" 
    driver="com.mysql.cj.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/learners_academy?allowPublicKeyRetrieval=true&useSSL=false"
     user="root"
     password="123456"
     />
     
     
<h2>Master List of subjects</h2>     
<sql:query var="rs" dataSource="${database}">
    SELECT * FROM subject_info order by sub_id asc;
</sql:query>    
<table border="2" width="100%">
    <tr>
        <td><b>Subject ID</b></td>
        <td><b>Subject</b></td>
    </tr>
    
    <c:forEach var="class_info" items="${rs.rows}">
        <tr>
            <td> <c:out value="${class_info.sub_id}"/> </td>
            <td> <c:out value="${class_info.subject}"/> </td>
        </tr>
    </c:forEach>
</table>

<form action='welcome' method='get'>
	 <br> <input type='submit' value='home page'/>
</form>

</body>
</html>