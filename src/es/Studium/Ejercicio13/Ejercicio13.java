package es.Studium.Ejercicio13;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Ejercicio13
{
	static final String jdbc_driver = "com.mysql.jdbc.Driver";
	static final String db_url = "jdbc:mysql://localhost:3306/Tema7.Empresa?useSSL=false";
	static final String usuario = "root";
	static final String clave = "Studium.2019;";
	public static void main(String[] args)
	{
		Connection conexion = null;
		Statement statement = null;
		try
		{
			//Registro el Driver
			Class.forName("com.mysql.jdbc.Driver");
			//Abir la conexión
			System.out.println("Conectando a la Base de Datos...");
			conexion = DriverManager.getConnection(db_url, usuario, clave);
			//Crear la base de datos
			System.out.println("Creando Base de Datos...");
			statement = conexion.createStatement();
			String sql = "CREATE DATABASE Prueba CHARACTER SET utf8 COLLATE utf8_spanish2_ci";
			statement.executeUpdate(sql);
			System.out.println("Base de Datos creada correctamente...");
		}
		catch(SQLException se)
		{
			//Errores del JDBC
			se.printStackTrace();
		}
		catch(Exception e)
		{
			//Captura error para Class.forName
			e.printStackTrace();
		}
		finally
		{
			//Cerrar statement y la conexión a la base de datos
			try
			{
				if(statement!=null)
				{
					statement.close();
				}
			}
			catch(SQLException se2){}
			try
			{
				if(conexion!=null)
				{
					conexion.close();
				}
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
	}
}