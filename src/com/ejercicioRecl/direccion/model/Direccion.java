package com.ejercicioRecl.direccion.model;

public class Direccion {
	private int id_direccion;
	private String calle;
	private String no_exterior;
	private String codigo_postal;
	private String estado;
	private String referencia;
	private String estatus;
	
	/*public Direccion(int id_direccion, String calle, String no_exterior, String codigo_postal, String estado,
			String referencia, String estatus) {
		super();
		this.id_direccion = id_direccion;
		this.calle = calle;
		this.no_exterior = no_exterior;
		this.codigo_postal = codigo_postal;
		this.estado = estado;
		this.referencia = referencia;
		this.estatus = estatus;
	}*/
	
	public int getId_direccion() {
		return id_direccion;
	}
	public void setId_direccion(int id_direccion) {
		this.id_direccion = id_direccion;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNo_exterior() {
		return no_exterior;
	}
	public void setNo_exterior(String no_exterior) {
		this.no_exterior = no_exterior;
	}
	public String getCodigo_postal() {
		return codigo_postal;
	}
	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	@Override
	public String toString() {
		return "Direccion [id_direccion=" + id_direccion + ", calle=" + calle + ", no_exterior=" + no_exterior
				+ ", codigo_postal=" + codigo_postal + ", estado=" + estado + ", referencia=" + referencia
				+ ", estatus=" + estatus + "]";
	}
	
}
