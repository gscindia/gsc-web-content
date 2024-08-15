package org.gsc.web.page.controller;

import org.gsc.constant.GscConstants;
import org.gsc.medha.dto.UserDto;
import org.gsc.medha.entity.User;
import org.gsc.medha.page.form.LoginForm;
import org.gsc.medha.repository.UserRepository;
import org.gsc.utility.GscSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping(GscConstants.LOGIN_CONTROLLER_PATH)
public class LoginPageController {	 
	@Autowired
	private UserRepository userRepository; 

	@GetMapping(GscConstants.LOGIN_CONTROLLER_LOGIN_PATH)
	public String login() {
		return "auth";
	}

	@GetMapping(GscConstants.LOGIN_CONTROLLER_DO_LOGIN_PATH)	
	public String  login(LoginForm form) throws Exception {
		UserDto userDto = new UserDto();
		
		User user =  userRepository.authenticate(form.getId(), GscSecurity.wrap(form.getPassword()));
		if(null!= user) {
			userDto.setName(user.getName());
			//userDto.setAuthStatus("true");
		}else {
			//userDto.setAuthStatus("false");
		}
		
		return  "redirect:/medhasandhan";
	}
}
