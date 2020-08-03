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
@Table(name= "revisiones")
public class Revision implements Serializable{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Codigo;
	
	private String nombre;
	private String correo;
	private String comentario;
	private int estrellas;
	@Column(name = "cretate_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	


	public Long getCodigo() {
		return Codigo;
	}




	public void setCodigo(Long codigo) {
		Codigo = codigo;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getCorreo() {
		return correo;
	}




	public void setCorreo(String correo) {
		this.correo = correo;
	}




	public String getComentario() {
		return comentario;
	}




	public void setComentario(String comentario) {
		this.comentario = comentario;
	}




	public int getEstrellas() {
		return estrellas;
	}




	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
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
