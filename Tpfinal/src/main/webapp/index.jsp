

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
     <%@include file="head.jsp" %>
    </head>
    <body>
         <%@include file="navbar.jsp" %>	
        <main class="border border-black rounded-4 text-center my-3">
            <div class="container">
                <section>
                    <a href="<%=request.getContextPath()%>/alta.jsp"><h1 class="titulo">ABM de oradores </h1></a>
                </section>
            </div>
        </main>
    </body>
</html>
