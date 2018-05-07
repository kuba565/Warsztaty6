<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>message by ${message.sender.username}</title>
</head>
<body>
<a href="/">Homepage</a>
<a href="/user/logout">Logout</a>

<a href="/user/messages">messages</a>
<br>
<table>
    <tr>
        <td>message:</td>
        <td>by:</td>
        <td>date:</td>
        <td>to:</td>
    </tr>
    <%--@elvariable id="message" type="pl.coderslab.model.Message"--%>
    <tr>
        <td>${message.text}</td>
        <td>${message.sender.username}</td>
        <td>${message.created}</td>
        <td>${message.recipient.username}</td>
    </tr>
</table>
</body>
</html>
