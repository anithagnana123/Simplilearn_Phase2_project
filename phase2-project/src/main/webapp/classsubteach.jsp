<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<html>
<head>
    <title>class-teach-sub-assign</title>
</head>
<body>
    <sql:setDataSource 
    var="database" 
    driver="com.mysql.cj.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/learners_academy?allowPublicKeyRetrieval=true&useSSL=false"
     user="root"
     password="123456"
     />
     
<h2>Assign teacher to a class and subject</h2>     

<br> <br>

<form name="f1" method="get" action="test">
   
  <table>
  
    <sql:query var="rs" dataSource="${database}">
         SELECT * FROM teacher order by teacher_id asc;
    </sql:query>       
    <tr>
        Teacher ID :    
        <select name = "teacher_id">
             <c:forEach var="teach_id" items="${rs.rows}">
                 <option> <c:out value="${teach_id.teacher_id}"/> </option> 
             </c:forEach>
        </select>
   </tr>
  
     <sql:query var="rs1" dataSource="${database}">
       SELECT * FROM class_info order by class_sec;
    </sql:query>       
    <tr>
        Class ID :    
        <select name = "class_sec">
             <c:forEach var="theclass_sec" items="${rs1.rows}">
                 <option> <c:out value="${theclass_sec.class_sec}"/> </option> 
             </c:forEach>
        </select>
    </tr>
  
    <sql:query var="rs2" dataSource="${database}">
         SELECT * FROM subject_info order by subject asc;
    </sql:query>       
    <tr>
        Subject :    
        <select name = "subject">
             <c:forEach var="subj" items="${rs2.rows}">
                 <option> <c:out value="${subj.subject}"/> </option> 
             </c:forEach>
        </select>
   </tr>
     
   <tr>  
      <td><input type="submit" value="assign"/></td>
      <td><input type="hidden" name="operation" value="classsubteach"/></td>  
   </tr>
       
  </table>
</form>
 
<br> <br>

<form action="welcome" method="get">
	<input type="submit" value="home page"/>
</form>

</body>
</html>