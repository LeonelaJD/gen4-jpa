package com.jimenez.app.jpa.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jimenez.app.jpa.dtos.VentaDTO;
import com.jimenez.app.jpa.models.Cliente;
import com.jimenez.app.jpa.models.Venta;
import com.jimenez.app.jpa.services.IService;

@RestController
@RequestMapping ("/api/ventas") 
@CrossOrigin(origins = "*") //es para solucionar por mientras 
public class VentasController {
	     
	@Autowired
	IService<Venta, VentaDTO> ventasService;
	   
	@PostMapping
	public Map<String, String> guardar( @RequestBody VentaDTO c){
		ventasService.guardar(c);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Venta guardada correctamente");
		return respuesta;
    
	}
	
	@GetMapping
	public List<Venta> venta(){
		return ventasService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public Venta obtenerPorId(@PathVariable(name = "id") Long id) {
		Optional<Venta> venta = ventasService.getById(id);
		if(venta.isPresent()) {
			return venta.get();
		}
		else {
			return null;
		}
	}
	
	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar(@RequestParam(name = "D") Long id){
		ventasService.eliminar(id);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Venta eliminada correctamente");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody VentaDTO c,
			@PathVariable (name = "id") Long id)
	{
		Optional<Venta> venta = ventasService.getById(id);
		if(venta.isPresent()) {
			c.setId(id);  
			ventasService.guardar(c);
		}
		else {
			throw new RuntimeException("La venta no existe en la BD");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Venta actualizado correctamente");
		return respuesta;
	} 
	
	
}
