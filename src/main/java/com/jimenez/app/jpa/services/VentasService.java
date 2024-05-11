package com.jimenez.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jimenez.app.jpa.dao.IClientesDao;
import com.jimenez.app.jpa.dao.IProductosDao;
import com.jimenez.app.jpa.dao.IVentasDao;
import com.jimenez.app.jpa.dtos.VentaDTO;
import com.jimenez.app.jpa.models.Producto;
import com.jimenez.app.jpa.models.Venta;

@Component
public class VentasService implements IService<Venta, VentaDTO>{

		//atributos
		@Autowired
		private IVentasDao ventasDao;
		
		//atributos
		@Autowired
		private IClientesDao clientesDao;
		
		
		@Override
		public List<Venta> listar() {
			// TODO Auto-generated method stub
			List<Venta> ventas = new ArrayList();
			ventas = (List<Venta>) ventasDao.findAll();
			return ventas;
			
		}

		@Override
		public Optional<Venta> getById(Long id) {
			// TODO Auto-generated method stub
			Optional<Venta> venta = ventasDao.findById(id);
			return venta;
			
		}  

		@Override
		public void guardar(VentaDTO t) {
			// TODO Auto-generated method stub
		
			//conversion del DTO al modelo original
			this.ventasDao.save(convertirDTOaVenta(t));
			
		}

		@Override
		public void eliminar(Long id) {
			// TODO Auto-generated method stub
			this.ventasDao.deleteById(id);
			
		}
		
		//metodo que permite convertir el DTO al modelo original
		public Venta convertirDTOaVenta(VentaDTO ventadto) {
			Venta v = new Venta();
			v.setId(ventadto.getId());
			v.setFecha(ventadto.getFecha());
			v.setSubtotal(ventadto.getSubtotal());
			v.setDescuento(ventadto.getDescuento());
			v.setFormaPago(ventadto.getFormaPago());
			v.setCliente(clientesDao.findById(ventadto.getCliente()).get() );
			return v;
		}
		
	}