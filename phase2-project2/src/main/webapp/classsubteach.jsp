<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<html>
<head>
    <title>class-teach-sub-list</title>
</head>
<body>
    <sql:setDataSource 
    var="database" 
    driver="com.mysql.cj.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/learners_academy_test?allowPublicKeyRetrieval=true&useSSL=false"
     user="root"
     password="123456"
     />
     
<h2>Assign teacher to a class & subject</h2>     

<br> <br>

<form name="f1" method="get" action="#">
   
    <p>Enter the teacher ID </p>
    <p><input type="text" name="fr_teach_id"/></p>
  
    <sql:query var="rs" dataSource="${database}">
         SELECT * FROM class_subject;
    </sql:query>    
    
   <table>
      <tr>
        Standard :    
        <select name = "standard">
             <c:forEach var="class_standard" items="${rs.rows}">
                 <option> <c:out value="${class_standard.standard}"/> </option> 
             </c:forEach>
        </select>
      </tr>
    
  <br> <br>
      
      <tr>
        Section :    
        <select name = "section">
             <c:forEach var="class_sec" items="${rs.rows}">
                 <option> <c:out value="${class_sec.class_sec}"/> </option> 
             </c:forEach>
        </select>
      </tr>
      
   <br> <br>
    
     <tr>
        Subject :    
        <select name = "subject">
             <c:forEach var="class_sub" items="${rs.rows}">
                 <option> <c:out value="${class_sub.subject}"/> </option>
             </c:forEach>
        </select>
     </tr>
      
    <br> <br>    

    <tr>  
      <td><input type="submit" value="assign"/></td>
      <td><input type="hidden" name="operation" value="assignclasssub"/></td>  
    </tr>
    
</table>
</form>



 <%-- To display selected value from dropdown list. --%>
     <% 
                String s1 = request.getParameter("standard");
                if (s1 !=null)
                {
                    out.println("Selected standard is : "+s1);
                }
                
                String s2 = request.getParameter("standard");
                out.println("Selected subject is : " + s2);
      %>

    



<br> <br>
<form action="welcome" method="get">
	<input type="submit" value="home page"/>
</form>

</body>
</html>