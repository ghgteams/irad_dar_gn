package com.irad.dar.jwt;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.irad.dar.master.UserDao;


@Service
public class JWTUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		System.out.println("JWTUserDetailsService");
//		if ("gokul".equals(username)) {
//			return new User("gokul", "$2a$10$FmQ2HCC/CRx3Pia0.3Ll2.NDNpUESIXpbmnv9tWPUS5Tv7A3jih0y",
//					new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//	}

	public UserDao save(String username, String password) {
		System.out.println("SAVE"+username+password);
		UserDao newUser = new UserDao();
		newUser.setActive(true);
		newUser.setName(username);
		newUser.setUsername(username);
		newUser.setCreated_date(new Date());
		newUser.setPassword(password);
		//newUser.setPassword(bcryptEncoder.encode(password));
		return userDao.save(newUser);
	}
	
	@SuppressWarnings("unused")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("JWTUserDetailsService"+username);
		UserDao user = userDao.findByUsername(username);
		System.out.println("JWTUserDetailsService2"+user.getUsername());
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		String pass=bcryptEncoder.encode(user.getPassword());
		return new org.springframework.security.core.userdetails.User(user.getUsername(), pass,
				new ArrayList<>());
	}

//	public UserDao save(UserDTO user) {
//		UserDao newUser = new UserDao();
//		newUser.setUsername(user.getUsername());
//		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//		return userDao.save(newUser);
//	}
}
