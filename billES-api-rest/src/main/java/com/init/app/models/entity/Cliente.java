package com.init.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private String apellido;
	private String direcion;
	private String correo;

	@Column(length = 7)
	private int telefono;

	@Column(length = 10)
	private int celular;

	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	

	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public String getApellido() {
		return apellido;
	}





	public void setApellido(String apellido) {
		this.apellido = apellido;
	}





	public String getDirecion() {
		return direcion;
	}





	public void setDirecion(String direcion) {
		this.direcion = direcion;
	}





	public String getCorreo() {
		return correo;
	}





	public void setCorreo(String correo) {
		this.correo = correo;
	}





	public int getTelefono() {
		return telefono;
	}





	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}





	public int getCelular() {
		return celular;
	}





	public void setCelular(int celular) {
		this.celular = celular;
	}





	public Date getCreateAt() {
		return createAt;
	}





	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}





	public static long getSerialversionuid() {
		return serialVersionUID;
	}





	private static final long serialVersionUID = 1L;

}
