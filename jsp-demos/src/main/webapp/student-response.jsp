<html>

<head>
   <title>Simplilearn</title>
</head>

<body>
   The student is confirmed : ${param.firstName}  ${param.lastName}

   <br> <br>
   The student country : ${param.country}
   
   <br> <br>
   The student's favorite programming language : 
   
   <ul>
       <%
          String[] languages = request.getParameterValues("favoriteLanguage");
          if(languages!= null){
        	  for(String s: languages){
        		  out.println("<li>" + s + "</li>");
        	  }
          }
         
         %>
   </ul>
       
</body>
</html>