package com.rms2307.testetripletech.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {
	
	@GetMapping
	public String teste() {
		return "REST OK-Pessoas";
	}

}
