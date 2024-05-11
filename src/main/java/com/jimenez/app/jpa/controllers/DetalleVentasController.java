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

import com.jimenez.app.jpa.dtos.DetalleVentaDTO;
import com.jimenez.app.jpa.models.Cliente;
import com.jimenez.app.jpa.models.DetalleVenta;
import com.jimenez.app.jpa.services.IService;

@RestController
@RequestMapping ("/api/detalle/ventas")
@CrossOrigin(origins = "*") //es para solucionar por mientras 
public class DetalleVentasController {
	 
	@Autowired
	IService<DetalleVenta, DetalleVentaDTO> detalleVentasService;
	
	@PostMapping
	public Map<String, String> guardar( @RequestBody DetalleVentaDTO c){
		detalleVentasService.guardar(c);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Cliente guardado correctamente");
		return respuesta;
  
	}
	
	@GetMapping
	public List<DetalleVenta> listar(){
		return detalleVentasService.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public DetalleVenta obtenerPorId(@PathVariable(name = "id") Long id) {
		Optional<DetalleVenta> detalleVenta = detalleVentasService.getById(id);
		if(detalleVenta.isPresent()) {
			return detalleVenta.get();
		}
		else {
			return null;
		}
	}
	
	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar(@RequestParam(name = "D") Long id){
		detalleVentasService.eliminar(id);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Cliente eliminado correctamente");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String> actualizar(@RequestBody DetalleVentaDTO c,
			@PathVariable (name = "id") Long id)
	{
		Optional<DetalleVenta> detalleVenta = detalleVentasService.getById(id);
		if(detalleVenta.isPresent()) {
			c.setId(id);  
			detalleVentasService.guardar(c);
		}
		else {
			throw new RuntimeException("El cliente no existe en la BD");
		}
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Cliente actualizado correctamente");
		return respuesta;
	} 
	
	
}