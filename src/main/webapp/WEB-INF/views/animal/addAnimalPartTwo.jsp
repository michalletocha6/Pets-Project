<%--
  Created by IntelliJ IDEA.
  User: michalletocha
  Date: 05.02.2020
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michalletocha
  Date: 05.02.2020
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <%@ include file="/WEB-INF/views/html/headerMetaTags.jsp" %>

    <title>Pet Lovers - Add Animal</title>

    <%@ include file="/WEB-INF/views/html/headerLinks.jsp" %>

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <%@ include file="/WEB-INF/views/html/sidebar.jsp" %>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Top Bar -->
            <%@ include file="/WEB-INF/views/html/topBar.jsp" %>
            <!-- End of Top Bar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <h1 class="h3 mb-4 text-gray-800">Add Animal 2 of 2</h1>

                <form:form modelAttribute="animal" method="post">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputType">Rasa</label>
                            <form:select path="type.breeds" cssClass="form-control" id="inputType">
                                <form:option value="" label="--Please Select--"/>
                                <form:options items="${breeds}" itemLabel="name" itemValue="id"/>
                            </form:select>
                            <span style="color: red"><form:errors path="type"/></span>
                        </div>
                    </div>
                        <div class="form-group col-md-6">
                            ZDJECIE TUTAJ BEDZIE DO WGRANIA
<%--                            <label for="inputName4">ZDJECIE TUTAJ BEDZIE DO WGRANIA</label>--%>
<%--                            <form:input path="name" cssClass="form-control" id="inputName4" placeholder="Imię"/>--%>
<%--                            <span style="color: red"><form:errors path="name"/></span>--%>
                        </div>
                    <div class="form-group col-md-12">
                        <span>Czy jest rasowy?</span>
                        <div class="custom-control custom-radio">
                            <input type="radio" class="custom-control-input" id="defaultChecked" name="defaultExampleRadios" checked>
                            <label class="custom-control-label" for="defaultChecked">Rasowy</label>
                            <label class="custom-control-label" for="defaultChecked">Rasowy z certyfikatem</label>
                            <label class="custom-control-label" for="defaultChecked">Mieszaniec</label>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Zapisz</button>
                </form:form>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <%@ include file="/WEB-INF/views/html/footer.jsp" %>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<%@ include file="/WEB-INF/views/html/scrollTop.jsp" %>

<!-- Logout Modal-->
<%@ include file="/WEB-INF/views/html/logout.jsp" %>

<%@ include file="/WEB-INF/views/html/scripts.jsp" %>

</body>

</html>