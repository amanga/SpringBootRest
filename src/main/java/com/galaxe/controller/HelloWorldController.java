package com.galaxe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.galaxe.domain.ToDo;
import com.galaxe.services.ToDoService;

@RestController
@RequestMapping("/")
public class HelloWorldController {

	@Value("${com.galaxe.hello.message}")
	private String helloMssg;
	
	@Autowired
	private ToDoService toDoService;
	
	@RequestMapping( method=RequestMethod.GET)
	public String sayHello(){
		return helloMssg;
	}
	
	@RequestMapping(value = "/todo/{userId}", method = RequestMethod.GET)
	public List<ToDo> getToDo(@PathVariable String userId){
		return toDoService.getUserToDos(userId);
	}
	
	@RequestMapping(value = "/todo/{userId}", method = RequestMethod.POST)
	public String updateToDo(@PathVariable String userId, @RequestBody ToDo toDo){
		return toDoService.updateUserToDos(userId,toDo);
	}
	
	@RequestMapping(value = "/todo/{userId}", method = RequestMethod.PUT)
	public String addToDo(@PathVariable String userId, @RequestBody ToDo toDo){
		return toDoService.addUserToDos(userId,toDo);
	}
}
