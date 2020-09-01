package com.ecommes.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;



	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false, unique = true)
	private String refproducto;

	private int cantidad;

	private double valorneto;

	private double valortotal;

	@Column(name="byte_Foto", length = 1000)
	private byte[] img;

	private boolean visible;

	private boolean nuevo;

	private boolean recomendado;

	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	
	@OneToMany
	@JoinColumn(name ="codigo_marca")
	private List<Marca> marca;
	
	
	@OneToMany
	@JoinColumn(name = "codigo_categoria")
	private List<Categoria> categoria;
	
	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}

	public Producto() {

	}



	/*
	 * 
	 * public Usuario getUsuario() { return usuario; }
	 * 
	 * 
	 * 
	 * public void setUsuario(Usuario usuario) { this.usuario = usuario; }
	 */
		



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getRefproducto() {
		return refproducto;
	}

	public void setRefproducto(String refproducto) {
		this.refproducto = refproducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getValorneto() {
		return valorneto;
	}

	public void setValorneto(double valorneto) {
		this.valorneto = valorneto;
	}

	public double getValortotal() {
		return valortotal;
	}

	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
	}	


	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public List<Marca> getMarca() {
		return marca;
	}

	public void setMarca(List<Marca> marca) {
		this.marca = marca;
	}

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isNuevo() {
		return nuevo;
	}

	public void setNuevo(boolean nuevo) {
		this.nuevo = nuevo;
	}

	public boolean isRecomendado() {
		return recomendado;
	}

	public void setRecomendado(boolean recomendado) {
		this.recomendado = recomendado;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
