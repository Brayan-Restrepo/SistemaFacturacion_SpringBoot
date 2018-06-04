package com.udemy.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "facturas_items")
public class ItemFactura implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer cantidad;
	private Long factura_id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="producto_id")
	private Producto producto;
	
	/**
	 * Metodo personalizado para calcular el valor del producto
	 * @return
	 */
	public Double calcularImporte() {
		return this.cantidad.doubleValue() * producto.getPrecio();
	}
	
	public Long getFactura_id() {
		return factura_id;
	}

	public void setFactura_id(Long factura_id) {
		this.factura_id = factura_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
		
	private static final long serialVersionUID = 1L;
}
