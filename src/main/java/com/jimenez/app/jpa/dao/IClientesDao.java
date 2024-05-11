package com.jimenez.app.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.jimenez.app.jpa.models.Cliente;

public interface IClientesDao extends CrudRepository<Cliente, Long> { 
	


}
