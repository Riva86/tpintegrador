package com.mycompany.daos;

import com.mycompany.conexiones.Conexion;
import static com.mycompany.conexiones.Conexion.close;
import static com.mycompany.conexiones.Conexion.getConexion;
import com.mycompany.logica.Orador;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OradorDAO {

    static Logger logger = LoggerFactory.getLogger(OradorDAO.class);

    private static final String SQL_SELECT = "SELECT * FROM oradores";
    private static final String SQL_INSERT = "INSERT INTO oradores(nombre, apellido, mail, tema) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE oradores SET nombre = ?, apellido = ?, mail = ?, tema = ? WHERE ID_ORADOR = ?";
    private static final String SQL_DELETE = "DELETE FROM oradores WHERE ID_ORADOR = ?";

    public List<Orador> selectOradores() throws NullPointerException, ClassNotFoundException,
            InstantiationException, IllegalAccessException, IOException {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Orador orador = null;
        List<Orador> oradores = new ArrayList();
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        try {
            conn = getConexion();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_SELECT);

            while (rs.next()) {

                Long idOrador = rs.getLong(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String mail = rs.getString(4);
                String tema = rs.getString(5);
                Timestamp fechaAlta = rs.getTimestamp(6);

                orador = new Orador(idOrador, nombre, apellido, mail, tema, fechaAlta);
                oradores.add(orador);
            }

        } catch (SQLException | NullPointerException ex) {
            ex.printStackTrace(System.out);
            ex.getMessage();
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return oradores;
    }

    public int insertarOrador(Orador ora) throws NullPointerException, ClassNotFoundException,
            InstantiationException, IllegalAccessException, IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, ora.getNombre());
            stmt.setString(2, ora.getApellido());
            stmt.setString(3, ora.getMail());
            stmt.setString(4, ora.getTema());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                logger.info("Entro al finally-try");
                close(stmt);
                logger.info("despues de close stmt");
                close(conn);
                logger.info("despues de close conn");
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
        return registros;
    }

    public int actualizarOrador(Orador ora) throws IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, ora.getNombre());
            stmt.setString(2, ora.getApellido());
            stmt.setString(3, ora.getMail());
            stmt.setString(4, ora.getTema());
            stmt.setLong(5, ora.getId());
            registros = stmt.executeUpdate();
        } catch (SQLException | NullPointerException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException | NullPointerException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    public int eliminarOrador(Long i) throws IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setLong(1, i);
            registros = stmt.executeUpdate();
        } catch (SQLException | NullPointerException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException | NullPointerException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    /*public Orador obtenerPorId(Long id) throws IOException{
        String sql = "SELECT * FROM PRODUCTO WHERE ID=" + id;

        //Connection
        Connection con = Conexion.getConexion();

        Orador OraFromDb = null;

        //Statement
        try {
            Statement st = con.createStatement();

            //resultset
            ResultSet rs = st.executeQuery(sql);

            //VIENE UN SOLO REGISTRO!!!
            if (rs.next()) {//si existe, hay uno solo
                // rs > sacando los datos
                Long idOrador = rs.getLong(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String mail = rs.getString(4);
                String tema = rs.getString(5);
                Timestamp fechaAlta = rs.getTimestamp(6);

                //campos crear un objeto????
                OraFromDb = new Orador(idOrador, nombre, apellido, mail, tema, fechaAlta);
            }
        } catch (SQLException e) {
            // ERRORES
            e.printStackTrace();
        }
        return OraFromDb;
    }*/
    public Orador obtenerPorId(Long id) throws IOException, SQLException {
        String sql = "SELECT * FROM PRODUCTO WHERE ID=" + id;

        //Connection
        Connection con = Conexion.getConexion();

        Orador prodFromDb = null;

        //Statement
        try {
            Statement st = con.createStatement();

            //resultset
            ResultSet rs = st.executeQuery(sql);

            //VIENE UN SOLO REGISTRO!!!
            if (rs.next()) {//si existe, hay uno solo
                // rs > sacando los datos
                Long idOrador = rs.getLong(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String mail = rs.getString(4);
                String tema = rs.getString(5);
                Timestamp fechaAlta = rs.getTimestamp(6);

                //campos crear un objeto????
                prodFromDb = new Orador(idOrador, nombre, apellido, mail, tema, fechaAlta);
            }
        } catch (SQLException e) {
            // ERRORES
            e.printStackTrace();
        }
        return prodFromDb;
    }

}
