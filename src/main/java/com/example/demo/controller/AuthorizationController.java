package com.example.demo.controller;

import java.util.Date;

import com.example.demo.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.security.UsuarioTO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/api/obtenerToken")
public class AuthorizationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtils jwtUtils;

	@GetMapping
	public String returnToken(@RequestBody UsuarioTO usurious) {
		System.out.println("BBB-BBB");
		this.authenticate(usurious.getNombre(), usurious.getPassword());
		return this.jwtUtils.generateJwtToken(null,usurious.getNombre());
	}

	private void authenticate(String usurious, String password) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usurious, password));
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

}
