package com.ecommes.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "detalle_pedidos")
public class DetallePedido implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String numeroOrden;

	private Double valorProducto = 0D;

	@Column(nullable = false)
	private Integer cantidad;

	@Temporal(TemporalType.DATE)
	@Column(name = "create_at")
	private Date createAt;

	@PrePersist
	public void prePersit() {
		createAt = new Date();
	}
	

	@ManyToOne
	@JoinColumn(name = "codigo_producto", nullable = false , updatable = false)
	private Producto producto;

	/*
	@JoinTable(name = "rel_pedidos_productos", joinColumns = @JoinColumn(name = "FK_Producto", nullable = false), inverseJoinColumns = @JoinColumn(name = "FK_pedido"))

	@ManyToMany
	private List<Producto> productos;

	public void addProductos(Producto producto) {
		if (this.productos == null) {
			this.productos = new ArrayList<>();
		}
		this.productos.add(producto);
	}
	
	*/



	public DetallePedido() {
		
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(String numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public Double getValorProducto() {
		return valorProducto;
	}

	public void setValorProducto(Double valorProducto) {
		this.valorProducto = valorProducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	/*
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

*/
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	/*

	@Transient
	public Producto getProducto() {
		return this.pk.getProducto();
	}

	@Transient
	public Double getValorTotal() {
		return getProducto().getValortotal() * getCantidad();
	}
	
	
	*/

	

}
