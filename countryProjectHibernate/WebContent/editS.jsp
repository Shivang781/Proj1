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
<c:forEach var="p" items="${sessionScope.editlist}">

<c:set var="sname" value="${p.sname}"></c:set>

<c:set var="sdesc" value="${p.sdesc}"></c:set>

<c:set var="id" value="${p.id}"></c:set>
</c:forEach>
<form action="StateController?flag=update" method="post">
 Country
	<select name="cid">
		<option>Select</option>
		<c:forEach items="${sessionScope.ls}" var="p">
			<option value="${p.id }">${p.cname}</option>
		</c:forEach>
	</select>  
sname: <input type="text" name="sname" value="${sname}">
sdesc : <input type = "text" name="sdesc" value="${sdesc}">
<input type="hidden" value="${id}" name="id">
<input type = "submit"/>
</form>
</body>
</html>