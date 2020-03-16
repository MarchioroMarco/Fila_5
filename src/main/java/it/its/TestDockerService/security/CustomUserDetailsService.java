package it.its.TestDockerService.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import it.its.TestDockerService.dao.UtentiDao;
import it.its.TestDockerService.repository.UtentiRepository;



@Component
public class CustomUserDetailsService implements UserDetailsService {

    private UtentiRepository users;

    public CustomUserDetailsService(UtentiRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
    	Optional<UtentiDao> optional = this.users.findByName(username);
    	if(!optional.isPresent()) {
    		new UsernameNotFoundException("Username: " + username + " not found");
    	}
    	return optional.get();
    }
}