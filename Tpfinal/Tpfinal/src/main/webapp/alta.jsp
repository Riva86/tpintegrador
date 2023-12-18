<%-- 
    Document   : alta
    Created on : 14/12/2023, 20:29:44
    Author     : viaje
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%@include file="head.jsp" %>
        <title>Alta oradores</title>
    </head>
    <body>
        <main>
            <!-- ACA VA EL NAVBAR  -->
            <%@include file="navbar.jsp" %>
            
            
            <div class="container my-4">
                <section class="border border-warning rounded-4 col-6 mx-auto text-center" style="background-color: rgb(42, 43, 43)"> 
                    <h1 class="text-center my-4" style="color: rgb(194, 194, 43);">Alta</h1>
                    <!--  JSP -->
                    <form class="form" method="post"
                        action="<%=request.getContextPath()%>/CreateController">
                        <div class="my-3 mx-3">
                          <input name="nombre"  type="text" class="form-control" id="nombreTextarea" placeholder="Nombre" maxlength="50">
                        </div>
                        <div class="my-3 mx-3">
                          <input name="apellido" type="text" class="form-control" id="apellidotextarea" placeholder="Apellido">
                        </div>
                        <div class="my-3 mx-3">
                          <input name="mail" type="text" class="form-control" id="mailTextarea" placeholder="Mail" maxlength="50">
                        </div>
                        <div class="my-3 mx-3">
                          <input name="tema" type="text" class="form-control" id="temaTextarea" maxlength="50" placeholder="tema">
                        </div>
                        <button class="btn btn-warning my-3">
                            Dar de alta
                        </button>
                    </form><s></s>
                </section>
            </div>
        </main>
                        <%@include file="footer.jsp" %>
    </body>
</html>
