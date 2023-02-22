/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;


public class Conexion {
    Connection con = null;
    
    public Connection getConexion() throws JRException, ClassNotFoundException, SQLException {
     try {
            con = DriverManager.getConnection("jdbc:sqlserver://172.20.0.60\\sqlexpress:1433;databaseName=siapv2", "userSIAP", "usry8876");
     } catch (Exception ex) {
              }
        return con;
    }
    
    public void cerrarConexion() throws SQLException {
        con.close();
    }
}
