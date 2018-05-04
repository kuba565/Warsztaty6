<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Controller</title>
</head>
<body>

<h1>Strona Główna</h1>
<c:if test="${sessionScope.loggedUser==null}">

    <a href="user/login">Login</a>
    <a href="user/registration">Register</a>

</c:if>
<c:if test="${sessionScope.loggedUser!=null}">
Witaj ${sessionScope.loggedUser}!
<a href="user/tweets">Twoje tweety</a>

<br>


    <%--@elvariable id="tweet" type="pl.coderslab.model.Tweet"--%>
<form:form modelAttribute="tweet">
    <form:errors path="*"/>

    <label for="text">Tweet:</label>
    <form:textarea path="text" id="text"/>
    <button type="submit">Tweet!</button>
</form:form>
<br>

<table>
    <tr>
        <td>tweetText</td>
        <td>created</td>
        <td>user</td>
        <td>action</td>
    </tr>
        <%--@elvariable id="tweet" type="pl.coderslab.model.Tweet"--%>
    <c:forEach items="${tweetsList}" var="tweet">
        <tr>
            <td>${tweet.text}</td>
            <td>${tweet.created}</td>
            <td>${tweet.user.username}</td>
            <td><a href="tweetInfo/${tweet.id}">info</a> </td>
        </tr>
    </c:forEach>
    </c:if>
</table>

</body>
</html>
