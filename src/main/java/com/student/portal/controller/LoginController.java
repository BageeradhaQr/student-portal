/**
 * 
 */
package com.student.portal.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.portal.model.User;
import com.student.portal.service.UserService;
import com.student.portal.vo.RegistrationRequestVO;
import com.student.portal.vo.RegistrationResponseVO;
import com.student.portal.vo.StudentLoginRequestVO;
import com.student.portal.vo.StudentLoginResponseVO;

/**
 * @author Bageeradha
 *
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/profile")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/login")
	public StudentLoginResponseVO login(@RequestBody StudentLoginRequestVO requestVO){
		List<User> users = userService.getUsers();
		StudentLoginResponseVO studentLoginResponse = new StudentLoginResponseVO();
		if(!CollectionUtils.isEmpty(users)) {
			for (User user : users) {
				if(user.getEmail().equals(requestVO.getEmail())
						&& user.getPassword().equals(requestVO.getPassword())) {
					studentLoginResponse.setMessage("Sucess");
					studentLoginResponse.setFirstName(user.getFirstName());
					studentLoginResponse.setLastName(user.getLastName());
					break;
				}else {
					studentLoginResponse.setMessage("Failed");
				}
			}
		}
		return studentLoginResponse;
		
	}
	
	@PostMapping("/api/registerUser")
	public RegistrationResponseVO registerUser(@RequestBody RegistrationRequestVO requestVO) {
		RegistrationResponseVO registrationResponse = new RegistrationResponseVO();
		User user = new  User();
		BeanUtils.copyProperties(requestVO, user);
		userService.saveUser(user);
		registrationResponse.setMessage("Sucess");
		return registrationResponse;
		
	}

}
