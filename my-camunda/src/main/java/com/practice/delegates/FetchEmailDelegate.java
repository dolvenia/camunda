package com.practice.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class FetchEmailDelegate implements  JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
	
		
		System.out.println("Coming from FetchEmail Delegate");
		
		System.out.println("userIdInput inside FetchEmail delegate :: " + execution.getVariable("userIdInput"));
		
		execution.setVariable("userEmailIdFromDelegate", "kgadi@gmail.com");
		
	}

}
