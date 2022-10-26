<html>

<head>
  <title>Declaration</title>
</head>

<body>

<%!
    String makeItLower( String param){
	   return param.toLowerCase();
    }

%>

 Lower case "HELLO WORLD" :  <%= makeItLower("HELLO WORLD") %>

</body>

</html>