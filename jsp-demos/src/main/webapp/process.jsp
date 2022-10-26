<%@ page errorPage="error.jsp" %>

<%  

   String x = request.getParameter("param_number1");
   String y = request.getParameter("param_number2");
   
   int i = Integer.parseInt(x);
   int j = Integer.parseInt(y);
   
   int result  = i/j;
   
   out.println("The result of the division is " + result);
%>
