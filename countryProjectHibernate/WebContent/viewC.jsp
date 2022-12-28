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

<table border="1px">
<tr>
<th>id</th>
<th>cname</th>
<th>cdesc</th>
<th>Delete</th>
<th>Update</th>
</tr>

<c:forEach var="p" items="${sessionScope.list}">
<tr>
<td>
${p.id}
</td>

<td>
${p.cname}
</td>

<td>
${p.cdesc}
</td>


<td>
<a href="CountryController?flag=delete&x=${p.id}">Delete</a>
</td>

<td>
<a href="CountryController?flag=edit&y=${p.id}">Edit</a>
</td>
</tr>



</c:forEach>

</table>
</body>
</html>