<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>  
<c:forEach var="p" items="${sessionScope.list}">

<c:set var="cname" value="${p.cname}"></c:set>

<c:set var="cdesc" value="${p.cdesc}"></c:set>

<c:set var="id" value="${p.id}"></c:set>
</c:forEach>
<form action="CountryController?flag=update" method="post">

fname : <input type="text" name="cname" value="${cname}">
lname : <input type = "text" name="cdesc" value="${cdesc}">
<input type="hidden" value="${id}" name="id">
<input type = "submit"/>
</form>
</body>
</html>