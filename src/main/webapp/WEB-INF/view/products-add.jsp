<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <title>Добавление нового товара в репозиторий</title>
</head>

<body>
<form:form modelAttribute="product" method="post">
    ID: <form:input path="id"/>
    <br>
    Наименование: <form:input path="name"/>
    <br>
    Цена: <form:input path="price"/>
    <br>
    <input type="submit" value="Сохранить">
</form:form>
</body>
</html>