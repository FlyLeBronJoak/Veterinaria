package codigo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DataBases {

    private Connection cn;
    private ResultSet rs;
    private PreparedStatement ps;
    private ResultSetMetaData rsm;
    DefaultTableModel dtm;

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/veterinaria", "root", "root");
        } catch (Exception e) {

        }
        return cn;
    }

    public void llenarTabla(JTable tabla) throws Exception {
        ps = getConexion().prepareStatement("select nombre,apellido,dni,telefono from cliente");
        rs = ps.executeQuery();
        rsm = rs.getMetaData();
        ArrayList<Object[]> datos = new ArrayList<>();
        while (rs.next()) {
            Object[] filas = new Object[rsm.getColumnCount()];
            for (int i = 0; i < filas.length; i++) {
                filas[i] = rs.getObject(i + 1);

            }
            datos.add(filas);
        }
        dtm = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < datos.size(); i++) {
            dtm.addRow(datos.get(i));
        }
    }

    public void llenarTabla1(JTable tabla) throws Exception {
        ps = getConexion().prepareStatement("select nombre,sexo,especie,raza,chip,fecha_nacimiento,propietario from mascota");
        rs = ps.executeQuery();
        rsm = rs.getMetaData();
        ArrayList<Object[]> datos = new ArrayList<>();
        while (rs.next()) {
            Object[] filas = new Object[rsm.getColumnCount()];
            for (int i = 0; i < filas.length; i++) {
                filas[i] = rs.getObject(i + 1);

            }
            datos.add(filas);
        }
        dtm = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < datos.size(); i++) {
            dtm.addRow(datos.get(i));
        }
    }

    public String llenarFotos(String string) throws Exception {
        ps = getConexion().prepareStatement("SELECT imagen FROM mascota WHERE nombre='" + string + "'");
        rs = ps.executeQuery();
        System.out.println(string);
        String resultado = null;
         rs.next();
        resultado =rs.getString(1);

        return resultado;
        
    }

    public void llenaTablaTienda(JTable tabla) throws Exception {
        ps = getConexion().prepareStatement("select cod_producto, cantidad, cliente, telefono, fecha_compra from tienda");
        rs = ps.executeQuery();
        rsm = rs.getMetaData();
        ArrayList<Object[]> datos = new ArrayList<>();
        while (rs.next()) {
            Object[] filas = new Object[rsm.getColumnCount()];
            for (int i = 0; i < filas.length; i++) {
                filas[i] = rs.getObject(i + 1);

            }
            datos.add(filas);
        }
        dtm = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < datos.size(); i++) {
            dtm.addRow(datos.get(i));
        }

    }

}

////////////////////

