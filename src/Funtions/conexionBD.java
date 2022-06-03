package Funtions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexionBD {

    public String puerto = "3306";
    public String nomservidor = "localhost";
    public String db = "huellas";
    public String user = "root";
    public String pass = "";
    Connection conn = null;

    public Connection conectar() {
        try {
            String ruta = "jdbc:mysql://";
            String servidor = nomservidor + ":" + puerto + "/";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(ruta + servidor + db, user, pass);
            if (conn != null) {
                System.out.println("Conección a base de datos listo...");
            } else if (conn == null) {
                throw new SQLException();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,  ":"+e.getMessage());
 }catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null,":"+e.getMessage());
 }finally{
 return conn;
        }
    }

    public void desconectar() {
        conn = null;
        System.out.println("Desconexion a base de datos listo...");
    }
}
