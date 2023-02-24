package com.accenture.codingtest.springbootcodingtest.api;

import com.accenture.codingtest.springbootcodingtest.entity.User;

public interface TaskApi {
	@PostMapping("task")
	   public void saveTask(@RequestBody Task task);
	 @GetMapping("alltasks")
	 public List<Task> getAlltasks();
	 
	
	 @GetMapping("delete_task/{id}")
		public ModelAndView deleteTask(@PathVariable int id);
	 
	
}
