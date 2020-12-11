package com.ejercicioRecl.direccion.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private Connection conn=null;
    private String bd="ktg";
    private String jdbcUsername="root";
    private String jdbcPassword="Dev_168";
    private String url="jdbc:mysql://localhost:3306/"+bd+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&use"
    		+ "LegacyDatetimeCode=false&serverTimezone=UTC";
    
    public Conexion() {
		try {
			//obtiene driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			/*System.out.println("Usuario: " + jdbcUsername);
			System.out.println("Pass: " + jdbcPassword);
			System.out.println("BD: " + bd);*/
			//obtiene conexion
			conn=DriverManager.getConnection(url,jdbcUsername, jdbcPassword);
			if (conn != null) {
				System.out.println("Conexión exitosa a la bd: " + bd);
			}
		}catch (ClassNotFoundException e) {
			System.out.println("Error ClassNotFoundException: " + e.getMessage() + " en la clase " + e.getClass());
		} catch (SQLException e) {
			System.out.println("Error SQLException: " + e.getMessage() + " en la clase " + e.getClass());
			e.printStackTrace();
		}
	}
     
    public void desconectar() throws SQLException {
        if (conn != null && !conn.isClosed()) {
        	conn=null;
            System.out.println("Se cerro la conexión");
        }
    }
 
	public Connection getConnection() {
		return conn;
	}  
 
}
