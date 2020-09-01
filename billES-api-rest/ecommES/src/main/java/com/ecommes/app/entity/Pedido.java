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
@Table(name = "pedidos")
public class Pedido implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "numero_pedido")
	private Long numeropedido;

	private String status;

	private Double subtotal = 0D;

	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}

	@OneToMany
	@JoinColumn(name = "codigo_detalle_pedido")
	private List<DetallePedido> detallePedido;

	public Pedido() {

	}
	
	
	
	

	public List<DetallePedido> getDetallePedido() {
		return detallePedido;
	}





	public void setDetallePedido(List<DetallePedido> detallePedido) {
		this.detallePedido = detallePedido;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeropedido() {
		return numeropedido;
	}

	public void setNumeropedido(Long numeropedido) {
		this.numeropedido = numeropedido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
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

	/*
	 * @Transient public Double getValorTotalOrden() { double total = 0D;
	 * List<DetallePedido> detalleProductos = getDetalleProductos(); for
	 * (DetallePedido dp : detalleProductos) { total += dp.getValorTotal(); }
	 * 
	 * return total; }
	 * 
	 */

	/*
	 * 
	 * public void setDetalleProductos(List<DetallePedido> detalleProductos) {
	 * this.detalleProductos = detalleProductos; }
	 * 
	 */

}
