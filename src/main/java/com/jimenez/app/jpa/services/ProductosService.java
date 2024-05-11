package com.jimenez.app.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jimenez.app.jpa.dao.IProductosDao;
import com.jimenez.app.jpa.models.Producto;
@Component
public class ProductosService implements IService<Producto, Producto>{

	//atributos
		@Autowired
		private IProductosDao productosDao;
		
		
		@Override
		public List<Producto> listar() {
			// TODO Auto-generated method stub
			List<Producto> productos = new ArrayList();
			productos = (List<Producto>) productosDao.findAll();
			return productos;
			
		}

		@Override
		public Optional<Producto> getById(Long id) {
			// TODO Auto-generated method stub
			Optional<Producto> producto = productosDao.findById(id);
			return producto;
			
		}

		@Override
		public void guardar(Producto t) {
			// TODO Auto-generated method stub
			this.productosDao.save(t);
			
		}

		@Override
		public void eliminar(Long id) {
			// TODO Auto-generated method stub
			this.productosDao.deleteById(id);
			
		}
		
	}