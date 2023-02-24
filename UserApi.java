package com.accenture.codingtest.springbootcodingtest.api;

import com.accenture.codingtest.springbootcodingtest.entity.User;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

public interface UserApi {
	@PostMapping("user")
	   public void saveUser(@RequestBody User userdto);
	 @GetMapping("allusers")
	 public List<User> getAllUsers();
	 @GetMapping("loginPage")
		public ModelAndView openUserLoginPage();
	 @GetMapping("delete_user/{id}")
		public ModelAndView deleteUser(@PathVariable int id);
	 @PostMapping("login")
		public String loginUser(@RequestBody User user);
		
	
		@GetMapping("logout")
		public void logoutUser();

}
