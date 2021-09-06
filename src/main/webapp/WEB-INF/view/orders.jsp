<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Заказы</title>
</head>

<body>
<h1>Заказы</h1>
<ul>
    <c:forEach items="${orders}" var="order">
        <li>
            <p>ID: <c:out value="${order.id}"/></p>
            <p>Дата: <c:out value="${order.date}"/></p>
            <p>Стоимость: <c:out value="${order.cost}"/></p>
        </li>
    </c:forEach>
</ul>
<a href="orders/add">Добавить заказ</a>
<br>
<a href="index">На главную</a>
</body>
</html>