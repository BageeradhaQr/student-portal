/**
 * 
 */
package com.student.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.portal.model.User;
import com.student.portal.repositry.UserRepository;

/**
 * @author Bageeradha
 *
 */
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	

}
