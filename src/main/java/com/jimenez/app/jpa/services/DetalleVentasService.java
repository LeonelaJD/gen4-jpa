package com.jimenez.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jimenez.app.jpa.dao.IClientesDao;
import com.jimenez.app.jpa.dao.IDetalleVentasDao;
import com.jimenez.app.jpa.dao.IProductosDao;
import com.jimenez.app.jpa.dao.IVentasDao;
import com.jimenez.app.jpa.dtos.DetalleVentaDTO;
import com.jimenez.app.jpa.dtos.VentaDTO;
import com.jimenez.app.jpa.models.Cliente;
import com.jimenez.app.jpa.models.DetalleVenta;
import com.jimenez.app.jpa.models.Venta;

@Component
public class DetalleVentasService implements IService<DetalleVenta, DetalleVentaDTO>{ 

	//atributos
	@Autowired
	private IDetalleVentasDao detalleventasDao;
	
	//atributos
	@Autowired
	private IClientesDao clientesDao;
	
	//atributos
	@Autowired
	private IVentasDao ventasDao;
	
	@Autowired
	private IProductosDao productosDao;
	
	
	@Override
	public List<DetalleVenta> listar() {
		// TODO Auto-generated method stub
		List<DetalleVenta> detalleVentas = new ArrayList();
		detalleVentas = (List<DetalleVenta>) detalleventasDao.findAll();
		return detalleVentas;
		
	}

	@Override
	public Optional<DetalleVenta> getById(Long id) {
		// TODO Auto-generated method stub
		Optional<DetalleVenta> detalleVentas = detalleventasDao.findById(id);
		return detalleVentas;
		
	}

	@Override
	public void guardar(DetalleVentaDTO t) {
		// TODO Auto-generated method stub
		
		//conversion del DTO al modelo original
		this.detalleventasDao.save(convertirDTOaDetalleVenta (t));
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.detalleventasDao.deleteById(id);
		    
	}
	 
	//metodo que permite convertir el DTO al modelo original
	public DetalleVenta convertirDTOaDetalleVenta(DetalleVentaDTO detalleventadto) {
		DetalleVenta v = new DetalleVenta();
		v.setId(detalleventadto.getId());
		v.setCantidad(detalleventadto.getCantidad());
		v.setProducto(productosDao.findById(detalleventadto.getProducto()).get());
		v.setVenta(ventasDao.findById(detalleventadto.getVenta()).get()); 
		return v;
	} 
	
}
//v.setProducto(productosDao.findById(detallevdto.getProducto()).get());


