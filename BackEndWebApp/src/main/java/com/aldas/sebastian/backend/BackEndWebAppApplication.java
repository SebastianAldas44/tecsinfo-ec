package com.aldas.sebastian.backend;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aldas.sebastian.backend.controller.ProductoController;
import com.aldas.sebastian.backend.controller.UsuarioController;
import com.aldas.sebastian.backend.model.Producto;
import com.aldas.sebastian.backend.model.Usuario;

@SpringBootApplication
@RestController
public class BackEndWebAppApplication {
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/usuarios")
	public List<Usuario> getUsuarios() {
		UsuarioController usuarioController = new UsuarioController();
		return usuarioController.getUsuarios();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/productos")
	public List<Producto> getProductos(){
		ProductoController productoController = new ProductoController();
		return productoController.getProductos();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/usuario")
	public Usuario getUsuario(@RequestBody Usuario u) {
		boolean existe = false;
		Usuario usuario = null;
		UsuarioController usuarioController = new UsuarioController();
		List<Usuario> usuarios = usuarioController.getUsuarios();			
		for(int i = 0; i < usuarios.size(); i++)
		{
			if(usuarios.get(i).getNick().equals(u.getNick()) && usuarios.get(i).getClave().equals(u.getClave())) {
				existe = true;
				usuario = usuarios.get(i);
				break;
			}
		}
		
		if(!existe)
		{
			usuario = new Usuario();
			usuario.setNombre("no_existe");
			usuario.setNick("no_existe");
			usuario.setClave("no_existe");
		}
		return usuario;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/producto")
	public Producto getProducto(
			@RequestParam(value = "codigo", defaultValue = "0")String codigo) {
		boolean existe = false;
		Producto producto = null;
		ProductoController productoController = new ProductoController();
		for (Producto p : productoController.getProductos()) {
			if(p.getCodigo() == Integer.parseInt(codigo))
			{
				existe = true;
				producto = p;
				break;
			}
		}
		
		if(!existe)
		{
			producto = new Producto();
			producto.setCodigo(0);
			producto.setDescripcion("no_existe");
			producto.setPrecio(0.0);
			producto.setCantidad(0);
			producto.setTotal(0.0);
		}
		return producto;
	}

	public static void main(String[] args) {
		SpringApplication.run(BackEndWebAppApplication.class, args);
	}

}
