package com.jimenez.app.jpa.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//1
@Table(name= "jpa_ventas")
@Entity
public class Venta {
	//Atributos -> variables -> Caracteristicas
	
	//2
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ3")
	@SequenceGenerator(sequenceName = "customer_seq3", allocationSize = 1, name = "CUST_SEQ3")
	private Long id;
	 
	//2
	@Column(name = "fecha")
	private Date fecha; //importar de java util
	
	//2
	@Column(name = "subtotal")
	private Float subtotal;
	
	//2
	@Column(name = "descuento")
	private Float descuento;
	
	//2
	@Column(name = "forma_pago")
	private String formaPago;
	
	//3
	@JoinColumn(name = "cliente_id")
	@ManyToOne
	private Cliente cliente;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}

	public Float getDescuento() {
		return descuento;
	}

	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
