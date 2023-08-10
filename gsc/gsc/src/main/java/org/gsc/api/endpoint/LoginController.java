package org.gsc.api.endpoint;

import org.gsc.api.dto.UserDto;
import org.gsc.medha.page.form.LoginForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	
	@PostMapping("/auth")
	@ResponseBody
	public UserDto login(@RequestBody LoginForm form) {
		UserDto user = new UserDto();
		user.setId(form.getId());
		user.setName(form.getPassword());
		return user;
	}
}
