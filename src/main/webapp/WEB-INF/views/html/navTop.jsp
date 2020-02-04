<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michalletocha
  Date: 01.02.2020
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${userSession==null}">
    <header class="page-header">
        <nav class="navbar navbar-expand-lg justify-content-around">
            <a href="/" class="navbar-brand main-logo">
                Pet <span>Lovers</span>
            </a>
            <ul class="nav nounderline text-uppercase">
                <li class="nav-item ml-4">
                    <a class="nav-link color-header" href="/login">zaloguj się</a>
                </li>
                <li class="nav-item ml-4">
                    <a class="nav-link" href="#about">o aplikacji</a>
                </li>
                <li class="nav-item ml-4">
                    <a class="nav-link disabled" href="recipes.html">Przepisy</a>
                </li>
                <li class="nav-item ml-4">
                    <a class="nav-link disabled" href="#contact">Kontakt</a>
                </li>
            </ul>
        </nav>
    </header>
</c:if>
<c:if test="${userSession!=null}">
    <header class="page-header">
        <nav class="navbar navbar-expand-lg justify-content-between">
            <a href="/" class="navbar-brand main-logo main-logo-smaller">
                Pet <span>Lovers</span>
            </a>
            <div class="d-flex justify-content-around">
                <a href="/profile"><h4 class="text-light mr-3">${sessionScope.userSession.username}</h4></a>
                <div class="circle-div text-center"><a href="/profile"><i class="fas fa-appUser icon-appUser"></i></a></div>
            </div>
        </nav>
    </header>
</c:if>