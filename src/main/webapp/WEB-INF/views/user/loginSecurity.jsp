<%--
  Created by IntelliJ IDEA.
  User: michalletocha
  Date: 04.02.2020
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<%--<sec:authorize access="isAuthenticated()">--%>
<%--    <p>Zalogowany jako: <sec:authentication property="principal.username"/></p>--%>
<%--    <p>Posiada role: <sec:authentication property="principal.authorities"/></p>--%>
<%--</sec:authorize>--%>

</body>
</html>
