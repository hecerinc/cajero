package Entidades;
import java.sql.*;
import java.io.*;

public class Cuenta {
	// Statement stmt;
	// Connection conn;
	private String username = "root";
	private String password = "";
	private String url = "jdbc:mysql://localhost:3306/cajero";

	public Cuenta(){
		// Load the driver! 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {
			System.out.println("Cannot find the driver in the classpath!");
		}
		/*try(Connection connection = DriverManager.getConnection(url, username, password)) {
			// Esto ya no se necesita a partir de JDBC 4
			System.out.println("Loading driver...");

			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver loaded!");
			} catch (ClassNotFoundException e) {
				System.out.println("Cannot find the driver in the classpath!");
			}
			// stmt = conn.createStatement();
		}catch (SQLException e) { 
			System.out.println("Cannot connect to database server"); 
			e.printStackTrace();
		}*/
	}

	public boolean validar(int cuenta){
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			Statement stmt = conn.createStatement();
			stmt.executeQuery ("SELECT idcuenta FROM cuenta WHERE idcuenta = " + cuenta);
			ResultSet rs = stmt.getResultSet();

			if (rs.next()) { // Va al primer registro si lo hay
				int nCuenta = rs.getInt ("idcuenta");
				rs.close();
				return cuenta == nCuenta;
			}
			else 
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void agregar(int cuenta, String nombre, float saldo){
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			Statement stmt = conn.createStatement();
			String s = "INSERT INTO CUENTA (idcuenta, nombre, saldo)" + 
						" VALUES ("+ cuenta + " , '" + nombre + "', " + saldo + " )";
			System.out.println(s);
			stmt.executeUpdate(s);
		}catch (Exception e) { 
			System.out.println("Cannot update database" + e); 
		}
	}

	public void setSaldo(int cuenta, float saldo){
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			Statement stmt = conn.createStatement();			
			String s = "UPDATE cuenta SET saldo = " + saldo + " WHERE idcuenta = " + cuenta;
			stmt.executeUpdate(s);
		} catch (SQLException e) {
			System.out.println("Cannot execute disposicion()" + e);
			e.printStackTrace();
		}
	}

	public float getSaldo(int ncuenta){
		float saldo = 0.0f;

		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			Statement stmt = conn.createStatement();
			stmt.executeQuery ("SELECT saldo FROM cuenta WHERE idcuenta = " +ncuenta);
			ResultSet rs = stmt.getResultSet();
			rs.next(); // Va al registro ya validado
			saldo = rs.getFloat("saldo");
			rs.close();
			return saldo;
		} catch (SQLException e) {
			System.out.println("Cannot getSaldo()" + e);
			e.printStackTrace();
		}

		return saldo;
	}

}
