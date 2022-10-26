<%@ page errorPage = "error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<html>
<head>
    <title>thereport-list</title>
</head>
<body>
    <sql:setDataSource 
    var="database" 
    driver="com.mysql.cj.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/learners_academy?allowPublicKeyRetrieval=true&useSSL=false"
     user="root"
     password="123456"
     />
     
     
<h2>Class Report</h2>    

<% String hidden = request.getParameter("class_sec"); %>
Class <%=hidden %>
<br> <br>
   <sql:query var="rs" dataSource="${database}">
         SELECT * FROM student_info where class_sec = "<%=hidden %>";
    </sql:query>    
    
   <table border="2" width="100%">
    <tr>
        <td><b>Student ID</b></td>
        <td><b>First Name</b></td>
        <td><b>Last Name</b></td>
        <td><b>Date of Birth</b></td>
        <td><b>Class</b></td>
    </tr>
    
    <c:forEach var="student_info" items="${rs.rows}">
        <tr>
            <td> <c:out value="${student_info.student_id}"/> </td>
            <td> <c:out value="${student_info.firstName}"/> </td>
            <td> <c:out value="${student_info.lastName}"/> </td>
            <td> <c:out value="${student_info.dateOfBirth}"/> </td>
            <td> <c:out value="${student_info.class_sec}"/> </td>
        </tr>
    </c:forEach>
</table>

<br> <br>

<h2>Master List of all subjects for the class</h2>     
<sql:query var="rs" dataSource="${database}">
    SELECT * FROM class_subject where class_sec = "<%=hidden %>";
</sql:query>    
<table border="2" width="100%">
    <tr>
        <td><b>Class</b></td>
        <td><b>Subject</b></td>
    </tr>
    
    <c:forEach var="class_subject" items="${rs.rows}">
        <tr>
            <td> <c:out value="${class_subject.class_sec}"/> </td>
            <td> <c:out value="${class_subject.subject}"/> </td>
        </tr>
    </c:forEach>
</table>

<h2>Master List of all teachers and their assigned subject</h2>     
<sql:query var="rs" dataSource="${database}">
    SELECT * FROM class_sub_teach where class_sec ="<%=hidden %>";
</sql:query>    
<table border="2" width="100%">
    <tr>
        <td><b>Class</b></td>
        <td><b>Subject</b></td>
         <td><b>Teacher ID</b></td>
    </tr>
    
    <c:forEach var="class_sub_teach" items="${rs.rows}">
        <tr>
            <td> <c:out value="${class_sub_teach.class_sec}"/> </td>
            <td> <c:out value="${class_sub_teach.subject}"/> </td>
            <td> <c:out value="${class_sub_teach.teacher_id}"/> </td>
        </tr>
    </c:forEach>
</table>

<form action="welcome" method="get">
	<input type="submit" value="home page"/>
</form>

</body>
</html>