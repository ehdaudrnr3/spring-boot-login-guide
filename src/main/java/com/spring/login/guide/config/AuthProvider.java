package com.spring.login.guide.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.spring.login.guide.models.User;
import com.spring.login.guide.service.UserService;

@Component
public class AuthProvider implements AuthenticationProvider {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		User user = userService.findUser(username);
		if(user == null) {
			throw new UsernameNotFoundException("not found user");
		}
		if(!passwordEncoder.matches(password, user.getPassword())) {
			throw new BadCredentialsException("not match");
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return new UsernamePasswordAuthenticationToken(username, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
