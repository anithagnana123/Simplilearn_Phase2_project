
<%@ page import="java.util.Calendar"%>
<html>

<head>
  <title>builtin</title>
</head>

<body>

<h3>JSP implicit objects (9)</h3>

<% out.println("Today is " + (new java.util.Date()).toLocaleString()); %>

<br> <br>

<% out.println("Today is :" + Calendar.getInstance().getTime()); %>

<br> <br>

<% 
   /*
   String username = request.getParameter("username");
   out.println("Welcome " + username );
   */
   response.sendRedirect("http://www.simplilearn.com");
%>

</body>

</html>