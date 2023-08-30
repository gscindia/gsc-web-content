package org.gsc.web.page.controller;

import org.gsc.medha.dto.UserDto;
import org.gsc.medha.page.form.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginPageController {
	@PostMapping("/login")
	public String login(@RequestBody LoginForm form) {
		UserDto user = new UserDto();
		user.setId(form.getId());
		user.setName(form.getPassword());
		return "home";
	}
}
