package com.jimenez.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.jimenez.app.jpa.models.Cliente;
import com.jimenez.app.jpa.models.Producto;

public interface IProductosDao extends CrudRepository<Producto, Long>{

}
