<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="CountryController?flag=insert" method="post">

Country name:<input type="text" name="cname"/>
Country desc:<input type="text" name="cdesc"/>
		<input type="submit" value="SUBMIT" />

</form>
	<a href="CountryController?flag=search">search</a>

</body>
</html>