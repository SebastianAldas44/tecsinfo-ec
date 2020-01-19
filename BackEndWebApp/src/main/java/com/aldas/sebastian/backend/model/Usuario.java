package com.aldas.sebastian.backend.model;

public class Usuario {
	private String nombre;
	private String nick;
	private String clave;
	
	public Usuario() {
		
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNick() {
		return this.nick;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public String getClave() {
		return this.clave;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}
}
