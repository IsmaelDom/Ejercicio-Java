package com.ejercicioRecl.usuario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ejercicioRecl.direccion.model.Conexion;

public class UsuarioDAO {
	private Connection connection;
	Conexion miConexion=new Conexion();
	
	public UsuarioDAO() {
		connection = miConexion.getConnection();
	}

	public boolean validaUsuario(String nombre, String pass) {
		PreparedStatement statement=null;
		ResultSet result=null;
		boolean valido = false;

		String sql = "select * from usuario where estatus = 'A' and nombre = ? and pass = ?;";
		try {
			if (connection!=null) {
				statement=connection.prepareStatement(sql);
				statement.setString(1, nombre);
				statement.setString(2, pass);
				result=statement.executeQuery();
			
				if(result.next()){
					valido = true;
				}else {
					valido = false;
				}
				miConexion.desconectar();
			}
		} catch (Exception e) {
			valido = false;
			e.printStackTrace();
		}
		return valido;
	}
}
