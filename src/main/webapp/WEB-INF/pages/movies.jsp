<%--
  Created by IntelliJ IDEA.
  User: maksymkozachuk
  Date: 2019-12-18
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Films</h2>
<table>
    <tr>
        <th>id</th>
        <th>title</th>
        <th>year</th>
        <th>genre</th>
        <th>watched</th>
        <th>action</th>
    </tr>
    <c:forEach var="movie" items="${moviesList}">
        <tr>
            <td>${movie.id}</td>
            <td>${movie.title}</td>
            <td>${movie.year}</td>
            <td>${movie.genre}</td>
            <td>${movie.watched}</td>
            <td>
                <a href="/edit/${movie.id}">edit</a>
                <a href="/delete/${movie.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new film</a>
</body>
</html>
