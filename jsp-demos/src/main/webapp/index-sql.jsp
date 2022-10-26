<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<html>
<head>
    <title>simplilearn</title>
</head>
<body>
    <sql:setDataSource 
    var="database" 
    driver="com.mysql.cj.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/studentdb?allowPublicKeyRetrieval=true&useSSL=false"
     user="root"
     password="123456"
     />
     
<sql:query var="rs" dataSource="${database}">
    SELECT * FROM users;
</sql:query>    
<table border="2" width="100%">
    <tr>
        <td>ID</td>
        <td>NAME</td>
    </tr>
    
    <c:forEach var="user" items="${rs.rows}">
        <tr>
            <td> <c:out value="${user.id}"/> </td>
            <td> <c:out value="${user.name}"/> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>