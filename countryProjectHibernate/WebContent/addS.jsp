<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<body>
<form action="StateController?flag=insert" method="post">

	Country
	<select name="cid">
		<option>Select</option>
		<c:forEach items="${sessionScope.ls}" var="p">
			<option value="${p.id }">${p.cname}</option>
		</c:forEach>
	</select> state name:
	<input type="text" name="sname" /> state desc:
	<input type="text" name="sdesc" />
	<input type="submit" value="SUBMIT" />
	
</form>
	<a href="StateController?flag=search">search</a>

</body>
</html>