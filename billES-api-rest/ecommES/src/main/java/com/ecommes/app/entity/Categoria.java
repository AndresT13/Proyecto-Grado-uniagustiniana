package com.ecommes.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="categorias")
public class Categoria implements Serializable {


	@Id
	@Column(name="codigo_categoria" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	
	private boolean visible;
	
	private int categoriaSuperior;
	
	
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;


	

	
	
	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}
	
	
	public Categoria() {
	
	}

	
	
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


	public boolean isVisible() {
		return visible;
	}


	public void setVisible(boolean visible) {
		this.visible = visible;
	}


	public int getCategoriaSuperior() {
		return categoriaSuperior;
	}


	public void setCategoriaSuperior(int categoriaSuperior) {
		this.categoriaSuperior = categoriaSuperior;
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
