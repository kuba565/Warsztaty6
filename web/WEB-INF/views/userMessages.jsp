<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 03.05.18
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>${message.sender.username} - Messages</title>
</head>
<body>
<a href="/">Homepage</a>
<a href="/user/logout">Logout</a>
<br>

<table>

    <tr>
        <td>message:</td>
        <td>by:</td>
        <td>date:</td>
        <td>to:</td>
        <td>status:</td>
        <td>action</td>
    </tr>
    <%--@elvariable id="message" type="pl.coderslab.model.Message"--%>
    <c:forEach items="${messages}" var="message">
        <tr>
            <td>${message.text}</td>
            <td>${message.sender.username}</td>
            <td>${message.created}</td>
            <td>${message.recipient.username}</td>
            <td>
                <c:if test="${message.read==true}">message read</c:if>
                <c:if test="${message.read==false}">message unread</c:if>
            </td>
            <td><a href="messageInfo/${message.id}">info</a></td>
        </tr>
    </c:forEach>

</table>
<%--@elvariable id="message" type="pl.coderslab.model.Message"--%>
<form:form modelAttribute="message">
    <form:errors path="*"/>

    <label for="text">Message:</label>
    <form:textarea path="text"/>
    <br>
    <label for="text">to:</label>
    <form:input path="recipientString"/>

    <button type="submit">Send a message!</button>
</form:form>
</body>
</html>
