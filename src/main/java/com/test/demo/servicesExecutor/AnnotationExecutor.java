/**
 * 
 */
package com.test.demo.servicesExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.demo.services.MessageService;

/**
 * @author Harshal
 *
 *	-> This Autowiring mapping can be defined at constructor level OR setter method level.
 *
 *	-> @Autowire is expected with @Component : to know which entity needs to be mapped.
 */
@Component
public class AnnotationExecutor implements ServiceExecutor {

	private MessageService service;

	public AnnotationExecutor() {
		System.out.println("AnnotationExecutor constructor called.");
	}

	@Autowired
	public void setMessageService(MessageService srv) {
		System.out.println("AnnotationExecutor mapped the service.");
		this.service = srv;
	}

	/**
	 * 
	 */
	public boolean executeService(String messageContent, String recipientAddress) {
		System.out.println("AnnotationExecutor executed service.");
		return this.service.sendMessage(messageContent, recipientAddress);
	}

}
