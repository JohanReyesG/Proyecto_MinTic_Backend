package co.edu.unbosque.ciclo3backGrupo7.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.ciclo3backGrupo7.dao.Detalle_ventasDAO;
import co.edu.unbosque.ciclo3backGrupo7.model.Detalle_ventas;

@RestController //esta es una clase REST
@RequestMapping("detalle_ventas")

public class Detalle_ventasAPI {
	@Autowired //inyecta la dependencia de todos los métodos del JPA para usuarioDAO
	private Detalle_ventasDAO detalle_ventasDAO;
	
      
	@PostMapping("/guardar")//Request convierte en un objeto Java desde un JSon
	public void guardar(@RequestBody Detalle_ventas detalle_ventas) {
		detalle_ventasDAO.save(detalle_ventas);
	}
	
	@GetMapping("/listar")
	public List<Detalle_ventas> listar(){
	return detalle_ventasDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		detalle_ventasDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Detalle_ventas detalle_ventas) {
		detalle_ventasDAO.save(detalle_ventas);
	}
	
}


