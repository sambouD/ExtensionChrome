package com.etensionChrome.etensionChrome.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	
	

	/**
	 * Page de base 
	 * @return
	 */
	@GetMapping("/")
	public String index() {

		return "index";
	}

}
