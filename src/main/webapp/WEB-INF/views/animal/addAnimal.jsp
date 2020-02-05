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
                <h1 class="h3 mb-4 text-gray-800">Add Animal</h1>

                <form:form modelAttribute="animal" method="post">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputName4">Imię</label>
                            <form:input path="name" cssClass="form-control" id="inputName4" placeholder="Imię"/>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="inputType">Rodzaj</label>
                            <form:select path="type" id="inputType" class="form-control">
                                <option selected>Choose...</option>
                                <option value="Kot">Kot</option>
                                <option value="Pies">Pies</option>
                                <option value="Chomik">Chomik</option>
                                <option value="Wąż">Wąż</option>
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputBreed">Rasa</label>
                        <form:select path="breed" id="inputBreed" class="form-control">
                            <option selected>Choose...</option>
                            <option value="Kot">Kot</option>
                            <option value="Pies">Pies</option>
                            <option value="Chomik">Chomik</option>
                            <option value="Wąż">Wąż</option>
                        </form:select>
                    </div>
                    <div class="form-group">
                        <label for="inputAddress2">Address 2</label>
                        <input type="text" class="form-control" id="inputAddress2"
                               placeholder="Apartment, studio, or floor">
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputCity">City</label>
                            <input type="text" class="form-control" id="inputCity">
                        </div>
                        <div class="form-group col-md-4">
                            <label for="inputState">State</label>
                            <select id="inputState" class="form-control">
                                <option selected>Choose...</option>
                                <option>...</option>
                            </select>
                        </div>
                        <div class="form-group col-md-2">
                            <label for="inputZip">Zip</label>
                            <input type="text" class="form-control" id="inputZip">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" id="gridCheck">
                            <label class="form-check-label" for="gridCheck">
                                Check me out
                            </label>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Sign in</button>
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