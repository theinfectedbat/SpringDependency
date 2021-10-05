/**
 * 
 */
package com.test.demo.servicesExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.demo.services.DummyService;

/**
 * @author Harshal
 *
 */
@Component
public class DummyExecutor {

	@Autowired
	private DummyService dummyService;
	
	public DummyExecutor() {
		System.out.println("DummyExecutor gets called because of @Component tag.");
	}
	
	public void executeDummyService() {
		System.out.println("executeDummyService() called.");
		dummyService.executeDummyService();
	}
}
