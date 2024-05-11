package com.jimenez.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.jimenez.app.jpa.models.DetalleVenta;

public interface IDetalleVentasDao extends CrudRepository<DetalleVenta, Long>{

}
