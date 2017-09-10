<jsp:useBean id="uctr" class="basicwebapp.CounterBean" scope="session"/>
<jsp:useBean id="gctr" class="basicwebapp.CounterBean" scope="application"/>
<jsp:useBean id="calc" class="basicwebapp.CalculatorBean"/>
<jsp:setProperty name="uctr" property="step" value="1"/>
<jsp:setProperty name="calc" property="*"/>
<html>
	<head>
		<title>BasicWebApp-Welcome</title>
	</head>
	<body>
		<h1>Welcome Visitor ${param.user}</h1>
		<b>Number of requests: </b>${uctr.nextCount} / ${gctr.nextCount}
		<p>
			<form method="POST">
				<b>First Value</b><br>
				<input name="firstValue" value="${param.firstValue}">
				<br><br>
				<b>Second Value</b><br>
				<input name="secondValue" value="${param.secondValue}">
				<br><br>
				<input name="command" value="Add" type="submit">
				<input name="command" value="Sub" type="submit">
				<input name="command" value="Mul" type="submit">
				<input name="command" value="Div" type="submit">
			</form>
		</p>
		<b>Result = </b>${calc.result}
	</body>
</html>






