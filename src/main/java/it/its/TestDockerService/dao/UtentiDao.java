package it.its.TestDockerService.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Entity
@Table(name = "utenti")
@Data
public class UtentiDao implements UserDetails{
	
	@Id
	@Column(name = "id")
	private int id ;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "passw")
	private String password;
	
	@Column(name = "ruolo")
	private String ruolo;

	public List<String> getRoles(){
		List<String> roles = new ArrayList<String>();
		roles.add("ADMIN");
		return roles;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getRoles().stream().map(SimpleGrantedAuthority::new).collect(toList());
	}
	@Override
	public String getUsername() {
		return this.username; 
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	
}
