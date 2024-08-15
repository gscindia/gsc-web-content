package org.gsc.medha.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User implements UserDetails{
	@Id		
	String username;
	String name;
	String password;
	String role;
		
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = "ADMIN";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
	}
	
	
}
