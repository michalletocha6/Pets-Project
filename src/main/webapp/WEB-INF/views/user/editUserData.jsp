<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michalletocha
  Date: 03.02.2020
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <%@ include file="/WEB-INF/views/html/headerMetaTags.jsp" %>

    <title>Pet Lovers - Edit profile</title>

    <%@ include file="/WEB-INF/views/html/headerLinks.jsp" %>

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <%@ include file="/WEB-INF/views/html/sidebar.jsp" %>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <%@ include file="/WEB-INF/views/html/topBar.jsp" %>

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <h1 class="h3 mb-4 text-gray-800">Edytuj profil</h1>

                <div class="row">

                    <div class="col-lg-6">

                        <!-- Circle Buttons -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Zmień zdjęcię profilu</h6>
                            </div>
                            <div class="card-body">
                                Currently image ... gdzies tu jest
<%--                                <form:form cssClass="user" method="post">--%>
<%--                                    <div class="form-group row">--%>
<%--                                        <div class="col-sm-12">--%>
<%--                                            <form:input path="photo" placeholder="Username" type="file"/>--%>
<%--                                            <span style="color: red"><form:errors path="photo"/></span>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                    <input class="btn btn-primary btn-user btn-block"--%>
<%--                                           type="submit" value="Zapisz zmiany">--%>
<%--                                </form:form>--%>
                            </div>
                        </div>

                        <!-- Brand Buttons -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Zmień hasło</h6>
                            </div>
                            <div class="card-body">
                                <p>Google and Facebook buttons are available featuring each company's respective brand
                                    color. They are used on the user login and registration pages.</p>
                                <p>You can create more custom buttons by adding a new color variable in the <code>_variables.scss</code>
                                    file and then using the Bootstrap button variant mixin to create a new style, as
                                    demonstrated in the <code>_buttons.scss</code> file.</p>
                                <a href="#" class="btn btn-google btn-block"><i class="fab fa-google fa-fw"></i>
                                    .btn-google</a>
                                <a href="#" class="btn btn-facebook btn-block"><i class="fab fa-facebook-f fa-fw"></i>
                                    .btn-facebook</a>

                            </div>
                        </div>

                    </div>

                    <div class="col-lg-6">

                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Zmień dane</h6>
                            </div>
                            <div class="card-body">
                                <form:form modelAttribute="appUser" cssClass="user" method="post">
                                    <div class="form-group row">
                                        <div class="col-sm-12">
                                            <form:input path="username" cssClass="form-control form-control-user"
                                                        id="exampleUserName" placeholder="Username"/>
                                                <%--id username nie wiem skad brane, tak było w temlatce--%>
                                            <span style="color: red"><form:errors path="username"/></span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <form:input path="email" cssClass="form-control form-control-user"
                                                    id="exampleInputEmail" placeholder="Email Address" type="email"/>
                                        <span style="color: red"><form:errors path="email"/></span>
                                    </div>
                                    <div class="form-group">
                                        <form:textarea path="description" placeholder="Description"/>
                                    </div>
                                    <input class="btn btn-primary btn-user btn-block"
                                           type="submit" value="Zapisz zmiany">
                                </form:form>
                            </div>
                        </div>

                    </div>

                </div>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; Your Website 2019</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="login.html">Logout</a>
            </div>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/views/html/scripts.jsp" %>

</body>

</html>

