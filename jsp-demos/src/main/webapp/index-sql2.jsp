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
     url="jdbc:mysql://localhost:3306/learners_academy_test?allowPublicKeyRetrieval=true&useSSL=false"
     user="root"
     password="123456"
     scope="session"
     />
     
<h3>This is example of update query using JSTL SQL Tags.</h3>
<form method="post">
<table>
<tr>
<td>Enter First Name</td>
<td><input type="text" name="fname"></td>
</tr>
<tr>
<td>Enter Last Name</td>
<td><input type="text" name="lname"></td>
</tr>
<tr>
<td>Enter Experience</td>
<td><input type="text" name="experience"></td>
</tr>
<tr>
<td>Enter Qualification</td>
<td><input type="text" name="qualification"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="submit"></td>
</tr>
</table>
</form>
<sql:update dataSource="${database}" >
INSERT INTO teacher (teacher_firstName,teacher_lastName,experience,qualification) VALUES (?, ?, ?, ?)
<sql:param value="${param.fname}" />
<sql:param value="${param.lname}" />
<sql:param value="${param.experience}" />
<sql:param value="${param.qualification}" />
</sql:update>
<font size="5" color='green'> Congratulations ! Data inserted
successfully.</font>
</body>
</html>