<%-- 
    Document   : editar
    Created on : 14/12/2023, 20:24:01
    Author     : viaje
--%>

<%@page import="com.mycompany.logica.Orador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="head.jsp" %>
    </head>
    <body>
        <main>
            <!-- ACA VA EL NAVBAR  -->
            <%@include file="navbar.jsp" %>
            <div class="container">
                <section>
                    <% 
                        Orador orador = (Orador)request.getAttribute("orador");
                    %>
                    <h1>Editar orador</h1>
                    <!--  JSP -->
                    <form method="POST"
                            action="<%=request.getContextPath()%>/api/EditarController">
                            <input type="hidden" id="id" name="id" value="<%=orador.getId()%>">
                            
                            
                            
                            <div class="mb-3">
                              <label for="nombre" class="form-label">Nombre</label>
                              <input name="nombre"
                                    value="<%=orador.getNombre()%>"  
                                    type="text" class="form-control" id="exampleFormControlInput1" placeholder="Nombre" maxlength="50">
                            </div>

                            
                                    
                                    
                            <div class="mb-3">
                              <label for="apellido" class="form-label">Apellido</label>
                              <input name="apellido"
                                    value="<%=orador.getApellido()%>" 
                                    type="text" class="form-control" id="exampleFormControlInput1" placeholder="apellido" maxlength="50">
                            </div>
                            
                                    
                                    
                                    
                                    
                                    <div class="mb-3">
                                <label for="Mail" class="form-label">Mail</label>
                                <input value="<%=orador.getMail()%>" name="mail" type="text" class="form-control" id="hechoTextarea" placeholder="Mail" maxlength="50">
                            </div>
                            <div class="mb-3">
                              <label for="exampleFormControlTextarea1" class="form-label">Tema</label>
                              <input name="tema"
                                    
                                    value="<%=orador.getTema()%>" 
                                    type="text" class="form-control" id="exampleFormControlTextarea1" maxlength="50">
                            </div>
                            <button class="btn btn-warning">
                                Grabar
                            </button>
                    </form>
                </section>
            </div>
        </main>
           <%@include file="footer.jsp" %>                         
    </body>
</html>
