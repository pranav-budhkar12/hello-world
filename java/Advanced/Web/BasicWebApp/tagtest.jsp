<%@ taglib prefix="b" uri="/WEB-INF/basic.tld"%>
<html>
	<head>
		<title>BasicWebApp-Welcome</title>
	</head>
	<body>
		<h1>
		 <b:colorText>Welcome Visitor ${param.user}</b:colorText>
		</h1>
		<b>Time on server: </b><b:now format="hh:mm:ss a"/>
		<br>
		<b>Number of ticks: </b>${ticks}
	</body>
</html>

