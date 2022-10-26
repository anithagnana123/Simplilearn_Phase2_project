<html>
<head>
  <title>simplilearn</title>
</head>

<body>
   <%
      String favLang="Java";
   
      Cookie[] theCookies =  request.getCookies();
      
      if(theCookies!=null){
    	  for(Cookie tempCookie :  theCookies){
    		  if("myApp.favoriteLanguage".equals(tempCookie.getName())){
    			  favLang = tempCookie.getValue();
    			  break;
    		  }
    	  }
      }
   %>

   <h3>Training portal</h3>
   <h4>New Books for <%= favLang %></h4>
   <ul>
        <li>Book1</li>
        <li>Book2</li>
   </ul>
   
    <h4>Latest News Report for <%= favLang %></h4>
   <ul>
        <li>Report1</li>
        <li>Report2</li>
   </ul>
   
    <h4>New Jobs for <%= favLang %></h4>
   <ul>
        <li>Job1</li>
        <li>Job2</li>
   </ul>
   
   <hr/>
   <a href="cookies-personalize-form.html">Personalize this Page</a>

</body>


</html>