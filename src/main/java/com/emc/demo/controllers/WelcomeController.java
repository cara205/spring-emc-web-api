package com.emc.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller gestiona peticions de vistes html
@Controller
public class WelcomeController {
	
	//inject via application.properties file
	@Value("${welcome.message}") 
	private String message;
	
	@GetMapping("/")
	public String mainWithParam() {
		return "index"; //View - El / redirecciona a index.html
	}
	
	/*
	 * Per comunicar del controlador a la vista ho fem amb un objecte model
	 * S'injecta automàticament al moment que cridem a hello
	 */
	@GetMapping("/hello")
	public String mainWithParam(
			@RequestParam(name="name",required=false,defaultValue="") String name, Model model) {

		//Afegim atributs clau valor al Model.
		if(name.equals("")) {
			model.addAttribute("message",message);
		}else {
			model.addAttribute("message",name);
		}
		
		//Ha de retornar el nom de la pàgina que carregarem.
		return "welcome";
	}

}
