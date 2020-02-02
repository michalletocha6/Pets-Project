<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michalletocha
  Date: 01.02.2020
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sing up</title>
    <%@ include file="/WEB-INF/views/html/header.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/views/html/navTop.jsp" %>
<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-25">
                <form:form modelAttribute="user"  class="padding-small text-center" method="post"
                           action="/register">
                    <h1 class="text-color-darker">Rejestracja</h1>
                    <div class="form-group">
                        <label>Nazwa użytkownika: </label>
                        <form:input path="username" cssClass="form-control" placeholder="podaj imię"/>
                        <form:errors path="username"/>
                    </div>
                    <div class="form-group">
                        <label>Email: </label>
                        <form:input path="email" cssClass="form-control" placeholder="podaj email" type="email"/>
                        <form:errors path="email"/>
                    </div>
                    <div class="form-group">
                        <label>Hasło: </label>
                        <form:input path="password" cssClass="form-control" placeholder="podaj hasło" type="password"/>
                        <form:errors path="password"/>
                    </div>
                    <div class="form-group">
                        <label>Powtórz hasło: </label>
                        <form:input path="repassword" cssClass="form-control" placeholder="podaj hasło"
                                    type="password"/>
                        <form:errors path="repassword"/>
                    </div>
                    <div class="form-group">
                        <label>Akceptuję warunki... </label>
                        <form:checkbox path="acceptRules"/>
                        <form:errors path="acceptRules"/>
                    </div>
<%--                    Password matching error, this returns errors of Object--%>
                    <form:errors path=""/>
                    <button class="btn btn-color rounded-0" type="submit">Zarejestruj</button>
                </form:form>
            </div>
        </div>
    </div>
</section>
<%@ include file="/WEB-INF/views/html/scripts.jsp" %>
</body>
</html>
