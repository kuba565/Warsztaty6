<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 27.04.18
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--@elvariable id="user" type="pl.coderslab.model.User"--%>
<form:form modelAttribute="user">
    <form:errors path="*"/>

    <label for="username">Nazwa użytkownika</label>
    <form:input path="username" id="username"/>
    <label for="email">E-mail</label>
    <form:input path="email" id="email"/>

    <label for="password">Hasło</label>
    <form:password path="password" id="password"/>

    <button type="submit">Zarejestruj</button>
</form:form>
</body>
</html>
