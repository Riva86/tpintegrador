package com.mycompany.controllers;

import com.mycompany.daos.OradorDAO;
import com.mycompany.logica.Orador;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@WebServlet("/api/ListadoController")
public class ListadoController extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//creamos una instancia de OradorDAO
		OradorDAO dao = new OradorDAO();
		
		//invocar al metodo listarProductos()
                List<Orador> listado = null;
                try {
                    listado = dao.selectOradores();
                } catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    ex.printStackTrace(System.out);
                }
		
		
		//grabar el listado en el request para que lo vea la siguiente pagina
		req.setAttribute("listado", listado);
		
		//ir a la siguiente pagina
		getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
	}
}

