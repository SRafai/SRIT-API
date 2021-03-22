/*
package com.srit.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.srit.imetier.GestionVehiculeMetier;

@Service
public class AppUserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	GestionVehiculeMetier gvm;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return gvm.findUserByEmail(username);
	}

}
*/
