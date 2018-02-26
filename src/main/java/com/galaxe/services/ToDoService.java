package com.galaxe.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.galaxe.domain.ToDo;

@Service
public class ToDoService {
	
	Map<String,List<ToDo>> usersToDos = new HashMap<String,List<ToDo>>();

	@PostConstruct
	public void loadUserToDos(){
		List<ToDo> toDos = new ArrayList<ToDo>();
		ToDo toDo = new ToDo();
		toDo.setId("1");
		toDo.setDescription("House loan meeting with Alex at 8:30");
		toDo.setDone(false);
		toDos.add(toDo);
		
		usersToDos.put("1", toDos);
	}
	public List<ToDo> getUserToDos(String userId){
		return usersToDos.get(userId);
	}
	
	private Map<String,List<ToDo>> toDoMocker(){
		return usersToDos;
	}
	
	public String addUserToDos(String userId, ToDo toDo) {
		List<ToDo> toDos = toDoMocker().get(userId);
		toDos.add(toDo);
		return "Success";
	}
	
	public String updateUserToDos(String userId, ToDo toDo) {
		List<ToDo> toDos = toDoMocker().get(userId);
		for(ToDo toDoObj : toDos){
			if(toDoObj.getId().equals(toDo.getId())){
				toDoObj.setDescription(toDo.getDescription());
				toDoObj.setDone(toDo.getDone());
				return "Updated Success";
			}
		}
		return "No task found";
	}
}
