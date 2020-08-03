package com.ecommes.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecommes.app.entity.Producto;
import com.ecommes.app.service.IProductoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ProductoController {

	@Autowired
	private IProductoService productoService;

	// método ´para listar productos
	@GetMapping("/productos")
	public List<Producto> producto() {
		return productoService.findAll();
	}

	// mostrar datos
	@GetMapping("/productos/{id}")
	public Producto Mostrar(@PathVariable Long id) {
		return productoService.findById(id);
	}

	// metodo para crear
	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto create(@RequestBody Producto producto) {
		// cliente.setCreateAt(new Date());
		return productoService.save(producto);
	}

	// método para update o modificar o actualizar
	@PutMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto update(@RequestBody Producto producto, @PathVariable Long id) {

		Producto productoActual = productoService.findById(id);

		productoActual.setRefproducto(producto.getRefproducto());
		productoActual.setNombre(producto.getNombre());
		productoActual.setCantidad(producto.getCantidad());
		productoActual.setValorneto(producto.getValorneto());
		productoActual.setValortotal(producto.getValortotal());
		productoActual.setImg(producto.getImg());
		productoActual.setVisible(producto.isNuevo());
		productoActual.setNuevo(producto.isNuevo());
		productoActual.setRecomendado(producto.isRecomendado());
		productoActual.setCreateAt(producto.getCreateAt());
		productoActual.setMarca(producto.getMarca());
		productoActual.setCategoria(producto.getCategoria());
		productoActual.setUsuario(producto.getUsuario());
		productoActual.setCategoria(producto.getCategoria());

		// con un service voy a persistir el objeto actual internamente va a hacer un
		// merge que va ha actualizar los datos y se traduce a un update en la base de
		// datos
		return productoService.save(productoActual);
	}

	// metodo para delete
	@DeleteMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		productoService.delete(id);
	}

}
