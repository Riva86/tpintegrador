<nav class="navbar navbar-expand-lg ">
            <div class="container-fluid">
                <img src="img\logoCACsinbloque.png" alt="Bootstrap" width="80" height="40">
                <a class="navbar-brand text-light mx-3" href="<%=request.getContextPath()%>/index.jsp">Codo a Codo</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link text-light" href="<%=request.getContextPath()%>/alta.jsp">Alta</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-light" href="<%=request.getContextPath()%>/api/ListadoController">Listado</a>
                        </li>
                    </ul>
                    
                </div>
            </div>
        </nav>	
