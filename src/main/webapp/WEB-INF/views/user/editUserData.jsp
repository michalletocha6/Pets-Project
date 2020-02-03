<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michalletocha
  Date: 03.02.2020
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit data</title>
    <%@ include file="/WEB-INF/views/html/header.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/views/html/navTop.jsp" %>
<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <%@ include file="/WEB-INF/views/html/dashboardSideNav.jsp" %>

        <div class="m-4 p-3 width-medium text-color-darker">
            <div class="m-4 border-dashed view-height">
                <!-- fix action, method -->
                <!-- add name attribute for all inputs -->
                <form:form modelAttribute="user" action="/profile/edit" method="post">
                    <form:hidden path="id"/>
                    <div class="mt-4 ml-4 mr-4">
                        <div class="row border-bottom border-3">

                            <div class="col"><h3 class="color-header text-uppercase">Edytuj dane</h3></div>
                            <div class="col d-flex justify-content-end mb-2">
                                <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Zapisz
                                </button>
                            </div>
                        </div>

                        <table class="table borderless">
                            <tbody>
                            <tr class="d-flex">
                                <th scope="row" class="col-2"><h4>Nazwa użytkownika</h4></th>
                                <td class="col-7">
                                    <form:input cssClass="w-100 p-1" path="username"/>
                                    <form:errors path="username"/>
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2"><h4>Email</h4></th>
                                <td class="col-7">
                                    <form:input cssClass="w-100 p-1" path="email"/>
                                    <form:errors path="email"/>
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2"><h4>Opis profilu</h4></th>
                                <td class="col-3">
                                    <form:textarea cssClass="w-100 p-1" path="description"/>
                                    <form:errors path="description"/>
                                </td>
                            </tr>
<%--                            <tr class="d-flex">--%>
<%--                                <th scope="row" class="col-2"><h4>Zdjęcie profilu</h4></th>--%>
<%--                                <td class="col-3">--%>
<%--                                    <form:input cssClass="w-100 p-1" path="photo" type="file"/>--%>
<%--                                    <form:errors path="photo"/>--%>
<%--                                </td>--%>
<%--                            </tr>--%>
                            </tbody>
                        </table>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>
<%@ include file="/WEB-INF/views/html/scripts.jsp" %>
</body>
</html>
