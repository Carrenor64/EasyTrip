package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Lugares;
import com.example.demo.domain.Rol;
import com.example.demo.domain.TipoIva;
import com.example.demo.domain.Usuario;
import com.example.demo.domain.Valoracion;
import com.example.demo.services.CategoriaServicelmplMen;
import com.example.demo.services.LugaresServiceImplMem;
import com.example.demo.services.UsuarioService;
import com.example.demo.services.ValoracionServiceImpl;

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}

	@Bean
	CommandLineRunner initData(LugaresServiceImplMem productosService, CategoriaServicelmplMen categoriaService, ValoracionServiceImpl valoracionServicio, UsuarioService usuarioService) {
		return args -> {
		
			categoriaService.add(new Categoria( "USA"));
			categoriaService.add(new Categoria("France"));
			usuarioService.add(new Usuario("manolo","22-12-2012", "1234", Rol.ADMIN));
			usuarioService.add(new Usuario("Antonio", "22-12-2022", "1234", Rol.USER));
			usuarioService.add(new Usuario("paco", "22-12-2012", "1234", Rol.MANAGER));
			productosService.add(new Lugares("New York", "Central Park", "Uno de los parques más grandes del mundo" , 0.00,  categoriaService.findByNombre("USA")));
			productosService.add(new Lugares("Paris", "Torre Eiffel", "Una de las atracciones mas impresionantes del mundo" , 20.00,  categoriaService.findByNombre("France")));
			productosService.add(new Lugares("New York", "Museo Historia Natural", "EL museo Más impresionante de NY" , 20.00,  categoriaService.findByNombre("USA")));
			// productosService.add(
			// 		new Lugares("harina", false, TipoIva.REDUCIDO, 5, categoriaService.findByNombre("harina")));
					valoracionServicio.add(new Valoracion(4,productosService.findByNombre("Central Park"), usuarioService.findByNombre("Antonio"), "puede ser mejor"));
		};

	}
}
