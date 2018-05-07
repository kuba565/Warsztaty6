<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 27.04.18
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/">Homepage</a>
<br>

<%--@elvariable id="user" type="pl.coderslab.model.User"--%>
<form:form modelAttribute="user">
    <form:errors path="*"/>

    <label for="username">Nazwa użytkownika</label>
    <br>
    <form:input path="username" id="username"/>
    <br>
    <label for="email">E-mail</label>
    <br>
    <form:input path="email" id="email"/>
    <br>
    <label for="password">Hasło</label>
    <br>
    <form:password path="password" id="password"/>
    <br>

    <button type="submit">Zarejestruj</button>
</form:form>
</body>
</html>
