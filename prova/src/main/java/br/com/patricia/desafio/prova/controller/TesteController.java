package br.com.patricia.desafio.prova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TesteController {

	@RequestMapping("/")
	@ResponseBody
	public String Oi() {
		return "OI filho";
	}
}
