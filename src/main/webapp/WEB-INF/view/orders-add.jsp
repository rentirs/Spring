<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <title>Добавление новго заказа</title>
</head>

<body>
<form:form modelAttribute="order" method="post">
    ID: <form:input path="id"/>
    <br>
    Дата: <form:input path="date"/>
    <br>
    Стоимость: <form:input path="cost"/>
    <br>
    <input type="submit" value="Сохранить">
</form:form>
</body>
</html>