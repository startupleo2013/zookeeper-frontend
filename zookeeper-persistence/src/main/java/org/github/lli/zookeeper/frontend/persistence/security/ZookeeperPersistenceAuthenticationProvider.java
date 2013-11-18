package org.github.lli.zookeeper.frontend.persistence.security;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/***
 * 
 * @author startupleo2013
 * 
 */
public class ZookeeperPersistenceAuthenticationProvider implements
		AuthenticationProvider {

	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		return new UsernamePasswordAuthenticationToken(
				authentication.getName(), authentication.getCredentials(),
				Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
	}

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
