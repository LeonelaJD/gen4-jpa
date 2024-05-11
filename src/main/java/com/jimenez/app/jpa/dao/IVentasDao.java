package com.jimenez.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.jimenez.app.jpa.models.Cliente;
import com.jimenez.app.jpa.models.Venta;

public interface IVentasDao extends CrudRepository<Venta, Long> {
	


}
