<%@ page import="java.util.*"%>
<%!
	String reverse(String text){
		StringBuffer buf = new StringBuffer(text);
		buf.reverse();
		return buf.toString();
	}
%>
<%
	String name = request.getParameter("user");
	if(name == null) name = "";
%>
<html>
	<head>
		<title>BasicWebApp-Welcome</title>
	</head>
	<body>
		<h1>Welcome Visitor <%=reverse(name)%></h1>
		<b>Time on server: </b><%=new Date()%>
	</body>
</html>

