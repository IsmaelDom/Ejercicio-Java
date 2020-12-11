package com.ejercicioRecl.usuario.model;

public class Usuario {
	private int id_usuario;
	private String nombre;
	private String apellido;
	private String pass;
	private int direccion_id;
	private String estatus;
	
	public int getId_usuario() {
		return id_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getPass() {
		return pass;
	}
	public int getDireccion_id() {
		return direccion_id;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setDireccion_id(int direccion_id) {
		this.direccion_id = direccion_id;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellido=" + apellido + ", pass=" + pass
				+ ", direccion_id=" + direccion_id + ", estatus=" + estatus + "]";
	}
	
}
