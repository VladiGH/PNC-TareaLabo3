package com.uca.capas.tareaLabo3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.tareaLabo3.domain.Product;

@Controller
public class MainController {
	private List<Product> productList = new ArrayList<Product>();
	
	@GetMapping("/compraProducto")
	public ModelAndView compra() {
		ModelAndView mav = new ModelAndView();
		
		productList.add(new Product(0,"100 Años de Soledad", "50"));
		productList.add(new Product(1, "Rayuela","25"));
		productList.add(new Product(2, "La Casa de los espíritus","35"));
		productList.add(new Product(3, "Divina Comedia", "50"));
		productList.add(new Product(4, "Ensayo sobre la ceguera","75"));
		
		mav.setViewName("index");
		mav.addObject("product", new Product());
		mav.addObject("productos", productList);
		return mav;
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product producto) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("nombre", productList.get(producto.getId()).getNombre());
		int cantidadProdLista = Integer.parseInt(productList.get(producto.getId()).getCantidad());
		int cantidadProd = Integer.parseInt(producto.getCantidad());
		if (cantidadProd <= cantidadProdLista && cantidadProd > 0) 
			mav.setViewName("compra");
		else 
			mav.setViewName("error");
		return mav;
	}
}
