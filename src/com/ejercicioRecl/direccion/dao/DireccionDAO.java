package com.ejercicioRecl.direccion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ejercicioRecl.direccion.model.Conexion;
import com.ejercicioRecl.direccion.model.Direccion;

public class DireccionDAO {
	
	public List<Direccion> listarDireccion(){
		List<Direccion> listaDir = new ArrayList<>();
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		connection=miConexion.getConnection();
		String sql = "select * from direccion where estatus = 'A'";
		System.out.println("Consulta ejecutada: " + sql.toString());
		try {
			if (connection!=null) {
				statement=connection.prepareStatement(sql);
				//statement.setString(1, id_direccion);
				result=statement.executeQuery();
				while(result.next()){
					Direccion dir = new Direccion();
					dir.setId_direccion(result.getInt("id_direccion"));
					dir.setCalle(result.getString("calle"));
					dir.setNo_exterior(result.getString("no_exterior"));
					dir.setCodigo_postal(result.getString("codigo_postal"));
					dir.setEstado(result.getString("estado"));
					dir.setReferencia(result.getString("referencia"));
					dir.setEstatus(result.getString("estatus"));
					listaDir.add(dir);
				}
				miConexion.desconectar();
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta: "+e.getMessage());
		}
		System.out.println("Clase DireccionDAO --> Direcciones: " + listaDir);
		return listaDir;
	}
}
