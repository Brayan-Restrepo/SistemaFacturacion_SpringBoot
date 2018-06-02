package com.udemy.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable{
	
	public Cliente() {
		this.facturas = new ArrayList<Factura>();
	}

	//Llave primaria auto incrementable
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * La diferencia entre @NotEmpty y @NotNull es que para los 
	 * String el @NotEmpty valida que el contenido sea mayor a 0
	 * es decir que no esta vacio el estrin. si el string esta vacion etonces no es null 
	 */
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellido;
		
	private String foto;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha;
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	/**
	 * actualiza, elimina, en cascada. cascade=CascadeType.AL
	 */
	@OneToMany(mappedBy="cliente", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Factura> facturas;
	
	/**
	 * @PrePersist
	 * Se llama este metodoo justo antes de hacer el persist
	 * antes de insertar
	 */
	@PrePersist
	@PreUpdate
	private void fecha() {
		this.createAt = new Date();
	}
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreateAt() {
		return createAt;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	
	public void setFactura(Factura factua) {
		this.facturas.add(factua);
	}
	
	private static final long serialVersionUID = 1L;
}
