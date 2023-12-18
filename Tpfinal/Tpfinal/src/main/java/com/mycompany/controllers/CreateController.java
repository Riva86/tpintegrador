package com.mycompany.controllers;


import com.mycompany.daos.OradorDAO;
import com.mycompany.logica.Orador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/*HERENCIA*/
//Create Controller es hijo de :
@WebServlet("/CreateController")
public class CreateController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String mail = req.getParameter("mail");
		String tema = req.getParameter("tema");
		
		//crear ProductoDAO
		OradorDAO dao = new OradorDAO();
                
                Orador ora = new Orador(nombre, apellido, mail, tema);
		
		//ejecutar el metodo crearProducto(parametros...)
                
                try {
                    dao.insertarOrador(ora);
                } catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    ex.printStackTrace();
                }
		
		//ctrl+shit+o
		//ir a la siguiente pagina
		resp.sendRedirect(req.getContextPath()+"/api/ListadoController");
	}
}
