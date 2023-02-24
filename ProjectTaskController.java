package com.accenture.codingtest.springbootcodingtest.controller;

public class ProjectTaskController {
	@Autowired
	private ProjectApi projectapi;
	
	@Autowired
	private TaskApi taskapi;
	
	@Autowired
	private UserApi userapi;
	
	//User Module Start
	
	@GetMapping("index")
     public ModelAndView showindexPage() {
  	   return new ModelAndView("showindexPage");
     }
     @GetMapping("userPage")
     public ModelAndView openUserMenuPage() {
    	 return new ModelAndView("UserHomePage");
     }
     @GetMapping("user")
 	public ModelAndView openRegisterEntryPage() {
    	 UserDTO user=new UserDTO();
 		   ModelAndView mv=new ModelAndView("NewUserEntryPage");
 		   mv.addObject("userRecord",user);
 		   return mv;
 	}
 	@PostMapping("user")
 	   public ModelAndView saveUser(UserDTO userdto) {
 		 userapi.saveUser(userdto);
 		   ModelAndView mv=new ModelAndView("showFinalMenuPage");
 		  mv.addObject("comment","new user added");
 		   	   return mv;
     }
 	 @GetMapping("allusers")
 	   public ModelAndView openUsersListPage() throws Exception {
 		   List<UserDTO> userList=userapi.getAllUsers();
 		   ModelAndView mv=new ModelAndView("ShowAllUsersPage");
 		   mv.addObject("userList",userList);
 		   return mv;
 	   }
 	@GetMapping("delete_user/{id}")
 	public ModelAndView deleteUser(@PathVariable int id)
 	{
   		userapi.deleteUser(id);
 		ModelAndView mv=new ModelAndView("redirect:/client/index;");
 		return mv;
 	}
 	 @GetMapping("loginPage")
 	public ModelAndView openUserLoginPage()
   	 {
   		 UserDTO user=new UserDTO();
 		   ModelAndView mv=new ModelAndView("UserLoginPage");
 		   mv.addObject("loginRecord",user);
 		   return mv;
   	 }
   
   	@PostMapping("login")
 	public ModelAndView userLogin(HttpSession session, @ModelAttribute("userRecord") UserDTO userDto) {
 		userapi.loginUser(userDto);
 		session.setAttribute("user", userDto);
 		ModelAndView mv = null;
 		try {
 			if (userDto != null) {
 				if (userDto.getEmail().equals("vaijuahire@gmail.com") && userDto.getPassword().equals("Vaiju06@")) {
 					mv = new ModelAndView("FlightHomePage");
 				} else {
 					mv = new ModelAndView("FlightHomePageshow");
 				}
 			} else {
 				((BindingResult) session).addError(new ObjectError("invalid", "Invalid Credentials!!!"));
 				mv = new ModelAndView("output3");
 				mv.addObject("comment", "Wrong User Name or Password");
 			}
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return mv;
 	}
 	@GetMapping("Logout")
 	public ModelAndView logoutUser(HttpSession session) {
 		session.invalidate();
 		ModelAndView mv = new ModelAndView("redirect:/client/index;");
 		mv.addObject("comment", "The User Has Been Successfully Logout");
 		return mv;
 	}
 	//User Module ends
 	
 	
 	 @GetMapping("projectMenu")
     public ModelAndView openProjectMenuPage()
 	 {
    	 return new ModelAndView("HomePage"); 	 
     }
 	@GetMapping("project")
	public ModelAndView openrojectEntryPage()
	{
 		int newId=projectapi.openProjectEntryPage();
 		Project project=new Project(newId);
		ModelAndView mv=new ModelAndView("ProjectEntryPage");
		mv.addObject("projectRecord",project);
		return mv;
	}
 	@PostMapping("project")
	public ModelAndView saveProject(Project project)
	{
		projectapi.saveProject(project);
		ModelAndView mv=new ModelAndView("redirect:/client/showProject");
		 mv.addObject("comment","new Project added");
		 return mv;
	}
 	@GetMapping("showProject")
	public ModelAndView openAllProjectsPage() 
	{
		List<Project> projectList = projectapi.getAllProjects(); 
		ModelAndView mv = new ModelAndView("ShowAllProjects"); 
		mv.addObject("ProjectList",projectList);
		return mv;
	}
 	@GetMapping("delete_project/{id}")
	public ModelAndView deleteproject(@PathVariable int id)
	{
		projectapi.deleteProject(id);
		ModelAndView mv=new ModelAndView("redirect:/client/allprojects");
		return mv;
	}
 	
 	@GetMapping("taskMenu")
    public ModelAndView openTaskMenuPage()
	 {
   	 return new ModelAndView("TaskHomePage"); 	 
    }
	@GetMapping("task")
	public ModelAndView openTaskEntryPage()
	{
		int newId=taskapi.openTaskEntryPage();
		Task task=new Task(newId);
		ModelAndView mv=new ModelAndView("TaskEntryPage");
		mv.addObject("taskRecord",task);
		return mv;
	}
	@PostMapping("task")
	public ModelAndView addTask(Task task)
	{
		taskApi.addTask(task);
		ModelAndView mv=new ModelAndView("redirect:/client/alltasks");
		 mv.addObject("comment","new Task added");
		 return mv;
	}
	@GetMapping("alltasks")
	public ModelAndView openAllTasksPage() 
	{
		List<Task> taskList = taskapi.getAllTasks(); 
		ModelAndView mv = new ModelAndView("ShowAllTasksPage"); 
		mv.addObject("taskList",taskList);
		return mv;
	}
	@GetMapping("delete_task/{id}")
	public ModelAndView deleteTask(@PathVariable int pnr)
	{
		taskapi.deleteTask(pnr);
		ModelAndView mv=new ModelAndView("redirect:/client/alltasks");
		return mv;
	}
 	
  	
}
