package Ventas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Conexion {
	
public static void añadirProducto(int cantidad,String producto,double precio) throws SQLException {

	try {
		 // Cargar el controlador JDBC
       Class.forName("org.sqlite.JDBC");

       // Establecer la conexión a la base de datos
       String url ="jdbc:sqlite:src/conexion/conexion.db";
       String user = "root";
       String contraseña = "";
       Connection conexion = DriverManager.getConnection(url);
       
       //mete los valores en base de datos
	String consulta="insert into productos values('"+cantidad+"','"+producto+"','"+precio+"')";
	Statement statement=conexion.createStatement();
	statement.executeUpdate(consulta);
	
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Producto ya creado");
		Interface.modelo.removeRow(Interface.modelo.getRowCount()-1);
		
	}
}
public static void añadirVenta(String producto,int cantidad,double precio) throws SQLException {

	try {
		 // Cargar el controlador JDBC
       Class.forName("org.sqlite.JDBC");

       // Establecer la conexión a la base de datos
       String url ="jdbc:sqlite:src/conexion/conexion.db";
       String user = "root";
       String contraseña = "";
       Connection conexion = DriverManager.getConnection(url);
       
       //mete los valores en base de datos
	String consulta="insert into ventas values('"+producto+"','"+cantidad+"','"+precio+"')";
	Statement statement=conexion.createStatement();
	statement.executeUpdate(consulta);
	Interface.error.setVisible(false);
	
	} catch (Exception e) {
		Interface.error.setText("Ha sucedido un error intentalo de nuevo");
		Interface.error.setVisible(true);
		JOptionPane.showMessageDialog(null,"Venta ya añadidad");
		Interface.modeloVentas.removeRow(Interface.modeloVentas.getRowCount()-1);
		
	}
}
public static void eliminarTodosProducto() throws SQLException {
	try {
		 // Cargar el controlador JDBC
       Class.forName("org.sqlite.JDBC");

       // Establecer la conexión a la base de datos
       String url ="jdbc:sqlite:src/conexion/conexion.db";
       String user = "root";
       String contraseña = "";
       Connection conexion = DriverManager.getConnection(url);
       
       //mete los valores en base de datos
       String consulta="delete from productos";
	Statement statement=conexion.createStatement();
	statement.executeUpdate(consulta);
	
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ya esta vacia");
		
		
	}
}
public static void cargarTablaInven() throws SQLException {
	try {
		 // Cargar el controlador JDBC
       Class.forName("org.sqlite.JDBC");

       // Establecer la conexión a la base de datos
       String url ="jdbc:sqlite:src/conexion/conexion.db";
       String user = "root";
       String contraseña = "";
       Connection conexion = DriverManager.getConnection(url);
       
       //mete los valores en base de datos
	String consulta="select * from productos";
	Statement statement=conexion.createStatement();
	
	ResultSet resultText=statement.executeQuery(consulta);
	while(resultText.next()) {
		int cantidad=resultText.getInt("cantidad");
		String producto=resultText.getString("producto");
		double precio=resultText.getDouble("precio");
		Interface.modelo.addRow(new Object[] {cantidad,producto,precio});
	}
	} catch (Exception e) {
		System.out.println("Error carga tabla inventarios");
		
	}
}
public static void cargarTablaVentas() throws SQLException {
	try {
		 // Cargar el controlador JDBC
       Class.forName("org.sqlite.JDBC");

       // Establecer la conexión a la base de datos
       String url ="jdbc:sqlite:src/conexion/conexion.db";
       String user = "root";
       String contraseña = "";
       Connection conexion = DriverManager.getConnection(url);
       
       //mete los valores en base de datos
	String consulta="select * from ventas";
	Statement statement=conexion.createStatement();
	
	ResultSet resultText=statement.executeQuery(consulta);
	while(resultText.next()) {
		String producto=resultText.getString("producto");
		double precio=resultText.getDouble("precio");
		Interface.modeloVentas.addRow(new Object[] {producto,precio});
		
	}
	} catch (Exception e) {
		System.out.println("Error carga tabla ventas");
		
	}
}
public static void cargarTablaClientes() throws SQLException {
	try {
		 // Cargar el controlador JDBC
       Class.forName("org.sqlite.JDBC");

       // Establecer la conexión a la base de datos
       String url ="jdbc:sqlite:src/conexion/conexion.db";
       String user = "root";
       String contraseña = "";
       Connection conexion = DriverManager.getConnection(url);
       
       //mete los valores en base de datos
	String consulta="select producto from ventas";
	Statement statement=conexion.createStatement();
	
	ResultSet resultText=statement.executeQuery(consulta);
	while(resultText.next()) {
		String[] nombre= {"Lucia","Paco","Jordan","Sergio","Jorge"};
		int ls=nombre.length-1;
		int li=0;
		String producto=resultText.getString("producto");
		String nombre2=nombre[(int) (Math.random()*(ls-li+1)+1)];
		String correo=nombre2+"@gmail.com";
		Interface.modeloClientes.addRow(new Object[] {nombre2,producto,correo});
		System.out.println(nombre2+producto+correo);
	}
	} catch (Exception e) {
		System.out.println("Error carga tabla Clientes");
		
	}
}

public static void actualizarProducto(int cantidad,String producto,double precio) throws SQLException {
	try {
		 // Cargar el controlador JDBC
       Class.forName("org.sqlite.JDBC");

       // Establecer la conexión a la base de datos
       String url ="jdbc:sqlite:src/conexion/conexion.db";
       String user = "root";
       String contraseña = "";
       Connection conexion = DriverManager.getConnection(url);
       
       //mete los valores en base de datos
       String consulta="update productos set cantidad='"+cantidad+"',precio='"+precio+"' where producto='"+producto+"'";
		Statement statement=conexion.createStatement();
		statement.executeUpdate(consulta);
	} catch (Exception e) {
		
		System.out.println("error");
	}
}
public static void actualizarUsuario(String usuario,String password) throws SQLException {
	try {
		 // Cargar el controlador JDBC
       Class.forName("org.sqlite.JDBC");

       // Establecer la conexión a la base de datos
       String url ="jdbc:sqlite:src/conexion/conexion.db";
       String user = "root";
       String contraseña = "";
       Connection conexion = DriverManager.getConnection(url);
       
       //mete los valores en base de datos
       String consulta="update usuario set contraseña='"+password+"' where id_usuario='"+usuario+"'";
		Statement statement=conexion.createStatement();
		statement.executeUpdate(consulta);
	} catch (Exception e) {
		
		System.out.println("error");
	}
}

public static void eliminarProducto(Object producto) throws SQLException {
	try {
		 // Cargar el controlador JDBC
       Class.forName("org.sqlite.JDBC");

       // Establecer la conexión a la base de datos
       String url ="jdbc:sqlite:src/conexion/conexion.db";
       String user = "root";
       String contraseña = "";
       Connection conexion = DriverManager.getConnection(url);
       
       //mete los valores en base de datos
       String consulta="delete from productos where producto='"+ producto+"'";
		Statement statement=conexion.createStatement();
		statement.executeUpdate(consulta);
	} catch (Exception e) {
		
		System.out.println("error");
	}
}
public static void registroUsuario(String usuario,String password) throws SQLException {
	//Iniciar conexion con mysql
	try {
		 // Cargar el controlador JDBC
        Class.forName("org.sqlite.JDBC");

        // Establecer la conexión a la base de datos
        String url ="jdbc:sqlite:src/conexion/conexion.db";
        String user = "root";
        String contraseña = "";
        Connection conexion = DriverManager.getConnection(url);
        
        //mete los valores en base de datos
	String consulta="insert into usuarios values('"+usuario+"','"+password+"')";
	Statement statement=conexion.createStatement();
	statement.executeUpdate(consulta);
	} catch (Exception e) {
		System.out.println("Usuario duplicado");
	}
}

//compara los datos de la base e inicia sesion
public static boolean loginUsuario(String usuario,String password) {
	try {
		 // Cargar el controlador JDBC
       Class.forName("org.sqlite.JDBC");

       // Establecer la conexión a la base de datos
       String url ="jdbc:sqlite:src/conexion/conexion.db";
       String user = "root";
       String contraseña = "";
       Connection conexion = DriverManager.getConnection(url);
       
       //mete los valores en base de datos
	String consulta="select * from usuarios where id_usuario='"+usuario+"' and contraseña='"+password+"'";
	Statement statement=conexion.createStatement();
	statement.executeQuery(consulta);
	ResultSet resultSet=statement.executeQuery(consulta);
	String user1 = null;
	String password1 = null;
	
	//Recupera la informacion
	while(resultSet.next()) {
		user1=resultSet.getString("id_usuario");
		password1=resultSet.getString("contraseña");
		return true;
	}
	} catch (Exception e) {
		e.printStackTrace();
		
	}
	return false;
}

}
