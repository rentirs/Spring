<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Товары</title>
</head>

<body>
<h1>Товары</h1>
<ul>
    <c:forEach items="${products}" var="product">
        <li>
            <p>ID: <c:out value="${product.id}"/></p>
            <p>Наименование: <c:out value="${product.name}"/></p>
            <p>Цена: <c:out value="${product.price}"/></p>
        </li>
    </c:forEach>
</ul>
<a href="products/add">Добавить товар</a>
<br>
<a href="index">На главную</a>
</body>
</html>