package com.mycompany.controllers;


import com.mycompany.daos.OradorDAO;
import com.mycompany.logica.Orador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/api/EditarController")
public class EditarController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        OradorDAO dao = new OradorDAO();
        //invocar el metodo obtenerPorId(id)
        Orador oradFromDb = dao.obtenerPorId(Long.valueOf(id)); 
        //guardar en el request el producto
        req.setAttribute("orador", oradFromDb);
        //ir a la siguiente pagina
        getServletContext().getRequestDispatcher("/editar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            String nombre = req.getParameter("nombre");
            String apellido = req.getParameter("apellido");
            String mail = req.getParameter("mail");
            String tema = req.getParameter("tema");
            String id = req.getParameter("id");
            OradorDAO dao = new OradorDAO();

            //invocar actualizarProducto(params)
            Orador oraActualizado = new Orador(Long.valueOf(id), nombre, apellido, mail, tema);
            dao.actualizarOrador(oraActualizado);

            //ir a la siguiente pagina
            resp.sendRedirect(req.getContextPath()+"/api/ListadoController");
    }
}
