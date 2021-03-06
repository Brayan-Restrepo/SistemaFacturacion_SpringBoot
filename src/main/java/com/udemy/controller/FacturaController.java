package com.udemy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.udemy.models.entity.Cliente;
import com.udemy.models.entity.Factura;
import com.udemy.models.service.IClienteService;

@Controller
@RequestMapping("/factura")
//SessionAttributes("factura") -> factura es la variable que se pasa al formulario (metodo crear)
// se destrulle cuando se guarda
@SessionAttributes("factura")
public class FacturaController {

	@Autowired
	private IClienteService clienteServie;
	
	@GetMapping("/form/{clienteId}")
	public String crear(@PathVariable(value="clienteId") Long clienteId, Map<String, Object> model, RedirectAttributes flash ) {
		
		Cliente cliente = this.clienteServie.findOne(clienteId);
		if(cliente == null) {
			flash.addFlashAttribute("error", "La factura no existe en la base de datos!");
			return "redirect:/listar";
		}
		
		Factura factura = new Factura();
		factura.setCliente(cliente);

		model.put("factura", factura);
		model.put("titulo", "Crear Factura");
		
		return "factura/form";
	}
}
