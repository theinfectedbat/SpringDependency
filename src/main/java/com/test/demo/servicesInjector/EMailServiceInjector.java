/**
 * 
 */
package com.test.demo.servicesInjector;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.test.demo.services.DummyService;
import com.test.demo.services.EMailService;
import com.test.demo.services.MessageService;

/**
 * @author Harshal
 *
 *	-> injector class : Autowire newly created EmailService with respective service executor.
 *
 *	-> service executor will have a mapping annotation (Autowire) to process this resource.
 */
@Configuration
@ComponentScan(value = "com.test.demo.servicesExecutor")
public class EMailServiceInjector {

	public EMailServiceInjector() {
		System.out.println("EMailServiceInjector constructor called.");
	}

	@Bean 
	public MessageService getMessageService() {
		System.out.println("EMailService instance will be created in EMailServiceInjector.");
		return new EMailService(); 
	}
	
	@Bean
	public DummyService getDummyService() {
		System.out.println("DummyService instance will be created in EMailServiceInjector.");
		return new DummyService();
	}
}
