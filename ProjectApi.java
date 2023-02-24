package com.accenture.codingtest.springbootcodingtest.api;

import com.accenture.codingtest.springbootcodingtest.entity.User;

public interface ProjectApi {
	@PostMapping("project")
	   public void saveProject(@RequestBody Project project);
	 @GetMapping("allprojects")
	 public List<User> getAllProjects();
	 
	
	 @GetMapping("delete_project/{id}")
		public ModelAndView deleteProject(@PathVariable int id);
	 @PostMapping("project")
	   public void saveTasksofProject(@RequestBody Project project);
}
