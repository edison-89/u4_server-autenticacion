package com.example.demo.service;

import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.UsuarioEntidad;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioEntidad ue = new UsuarioEntidad();
		ue.setNombre("edison");
		ue.setPassword("$2a$12$xCrCUIpaLdTdIqmFsscfy.eXP4p/ymNoAJvMJMK2RwKu6xfBNRQUK");
		return new User(ue.getNombre(), ue.getPassword(), emptyList());
	}
}
