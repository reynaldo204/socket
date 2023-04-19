import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    /* crearemos 4 variables de tipo privadas y estaticas donde cargaremos lo que son los Driver de mysql
      el tipo de usuario y contraseña y la url que contendra el puerto y nombre de nuestra base de datos que en este caso
      registro*/
    private static String DRIVER ="com.mysql.jdbc.Driver";
    private static String USUARIO="root";
    private static String PASSWORD ="contraseña";
    private static String URL ="jdbc:mysql://localhost:3306/registro";
    // PreparedStatement preparedStatement;
    //ResultSet rs = null;
    /* Se creamos un metodom statico ya ue nos permite acceder si a las variables sin necesidad de instanciarlas */
    static {
        try {
            //Usaremos Class.forName() ya que nos sirve para que se ejecute en tiempo de ejecucion que
            // no se conoce en tiempo de compilacion y cargaremos el Driver
            Class.forName(DRIVER);

        }catch (ClassNotFoundException e){
            // se crea un mensaje por si sucede algun error inesperado
            JOptionPane.showMessageDialog(null, " Error en el DRIVER " + e);


        }
    }
    // Crearemos un metodo publico para poder acceder desde otras clases
    public Connection getConnection() {

        //se crea una conexion para poner los 3 parametros que son la url de la base de datos el usuario y la contraseña
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            JOptionPane.showMessageDialog(null, "Conexion exitosa");


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error en la conexion" + e);

        }
        return con;
    }
}
 /*preparedStatement = con.prepareStatement("SElECT dir_telf, dir_tipo_tel, dir_nombre, dir_direccion, dir_ciudad_id FROM personas JOIN ciudades ON dir_ciudad_id = ciud_id WHERE dir_telf =?");
            preparedStatement.setString(1,"310261");
            rs= preparedStatement.executeQuery();

            while (rs.next()){
                String id_tele = rs.getString(1);
                String idTipoTe = rs.getString(2);
                String idNombre = rs.getString(3);
                String idDireccion = rs.getString(4);
                int idCiudad = rs.getInt(5);

                System.out.println(" Telefono " + id_tele);
                System.out.println(" tipo " + idTipoTe);
                System.out.println(" Nombre " + idNombre);
                System.out.println(" Direccion " + idDireccion);
                System.out.println( " Ciudad "+ idCiudad);
            }*/