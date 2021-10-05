/**
 * 
 */
package com.test.demo.servicesExecutor;

import com.test.demo.services.MessageService;

/**
 * @author Harshal
 *
 *	-> Service executor class mapped via XML context "spring-beans.xml"
 */
public class XMLTypeExecutor implements ServiceExecutor {

	private MessageService service;
	
	/**
	 * if we want to use constructor setter; this needs to be used
	 * and accordingly changes needs to be done inside XML file.
	 * @param serv
	 */
	/*public XMLTypeExecutor(MessageService serv) {
		System.out.println("XMLTypeExecutor parameterized constructor called.");
		this.service = serv;
	}*/
	
	/**
	 * default constructor : when we don't want to use  
	 * service injection via constructor; this default needs to be used.
	 */
	public XMLTypeExecutor() {
		System.out.println("XMLTypeExecutor constructor called.");
	}
	
	// should be used only when constructor injection is not defined
	public void setService(MessageService srv) {
		System.out.println("XMLTypeExecutor mapped the service.");
		this.service = srv;
	}

	/**
	 * 
	 */
	public boolean executeService(String messageContent, String recipientAddress) {
		System.out.println("XMLTypeExecutor executed service.");
		return this.service.sendMessage(messageContent, recipientAddress);
	}

}
