package com.mycompany.controllers;


import com.mycompany.daos.OradorDAO;
import com.mycompany.logica.Orador;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/api/EditarController")
public class EditarController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
        String id = req.getParameter("id");
        OradorDAO dao = new OradorDAO();
        //invocar el metodo obtenerPorId(id)
        Orador oradFromDb = dao.obtenerPorId(Long.valueOf(id));
        //Orador oradFromDb = new Orador(2L, "Hard", "Code", "mail@mail.com","tema", Timestamp.valueOf(LocalDateTime.now()));
        //guardar en el request el producto
        req.setAttribute("orador", oradFromDb);
        //ir a la siguiente pagina
        getServletContext().getRequestDispatcher("/editar.jsp").forward(req, resp);
        } catch(SQLException ex) {
            ex.printStackTrace(System.out);
        }
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
            Orador oraActualizado = new Orador(Long.valueOf(id), nombre, apellido, mail, tema,Timestamp.valueOf(LocalDateTime.now()));
            //Orador oraActualizado = new Orador(id, nombre, apellido, mail,tema,Timestamp.valueOf(LocalDateTime.now()));
            //Orador oraActualizado = new Orador(nombre,apellido,mail,tema);
            dao.actualizarOrador(oraActualizado);
            //ir a la siguiente pagina
            resp.sendRedirect(req.getContextPath()+"/api/ListadoController");
            }
}
