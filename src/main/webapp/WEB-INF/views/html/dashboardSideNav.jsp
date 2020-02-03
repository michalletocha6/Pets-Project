<%--
  Created by IntelliJ IDEA.
  User: michalletocha
  Date: 03.02.2020
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="nav flex-column long-bg">
    <li class="nav-item">
        <a class="nav-link" href='<c:url value = "/profile"/>'>
            <span>Podgląd profilu</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href='<c:url value = "/profile/animals"/>'>
            <span>Zwierzaki</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href='<c:url value = "/profile/edit"/>'>
            <span>Edytuj dane</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href='<c:url value = "/profile/editPassword"/>'>
            <span>Zmiana hasła</span>
            <i class="fas fa-angle-right"></i>
        </a>
    </li>
    <c:if test="${user.admin == 1}">
        <li class="nav-item">
            <a class="nav-link" href="/app/users">
                <span>Użytkownicy</span>
                <i class="fas fa-angle-right"></i>
            </a>
        </li>
    </c:if>
</ul>
