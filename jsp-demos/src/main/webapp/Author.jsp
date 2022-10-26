<!DOCTYPE html>
<html lang="en">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<head>
   <title>Test</title>
</head>
<body>
    <form name="f1" method="get" action="#">
       <select name="clr">
           <option>Red</option>
           <option>Blue</option>   
           <option>Green</option>
           <option>Pink</option>
       </select>
     <input type="submit" name="submit" value="Select Color"/>
    </form>
    <%-- To display selected value from dropdown list. --%>
     <% 
                String s=request.getParameter("clr");
                if (s !=null)
                {
                    out.println("Selected Color is : "+s);
                }
      %>
</body>