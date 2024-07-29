package com.practice.Controllers;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home() {
		return "Today is Tuesday";
	}
	
	@RequestMapping(value="/execute",method=RequestMethod.GET)
	public String execute() {
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey("first_bpmn_execute");
	
		String item = "Computer";
		
		instance.setVariable("itemName", item);
		
		instance.businessKey("execute-endpoint");
		
		instance.executeWithVariablesInReturn();
		
		return "BPMN has executed!";
	}
	
	@RequestMapping(value="/tasks", method=RequestMethod.GET)
	public String tasks() {
		
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey("tasks_execute");
		instance.executeWithVariablesInReturn();
		
		return "Task has executed";
	}
	

}
