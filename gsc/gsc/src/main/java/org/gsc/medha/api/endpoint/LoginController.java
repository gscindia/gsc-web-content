package org.gsc.medha.api.endpoint;

import org.gsc.medha.dto.UserDto;
import org.gsc.medha.entity.User;
import org.gsc.medha.page.form.LoginForm;
import org.gsc.medha.repository.UserRepository;
import org.gsc.utility.GscSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	// @Autowired
	// private UserRepository userRepository; 
	
	// @PostMapping("/do-login")
	// @ResponseBody
	// public UserDto login(@RequestBody LoginForm form) throws Exception {
	// 	UserDto userDto = new UserDto();
		
	// 	User user =  userRepository.authenticate(form.getId(), GscSecurity.wrap(form.getPassword()));
	// 	if(null!= user) {
	// 		userDto.setName(user.getName());
	// 		//userDto.setAuthStatus("true");
	// 	}else {
	// 		//userDto.setAuthStatus("false");
	// 	}
		
	// 	return userDto;
	// }
}
