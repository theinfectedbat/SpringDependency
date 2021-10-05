/**
 * 
 */
package com.test.demo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.test.demo.services.MessageService;

/**
 * @author Harshal
 *
 *	-> Create a Dummy injector implementation for this class by providing annotations.
 *
 *	-> Create a dummy message service by providing custom implementation in this class only.
 */
@Configuration
@ComponentScan(value = "com.test.demo.servicesExecutor")
public class AppTest {

	private AnnotationConfigApplicationContext context = null;

	@Bean
	public MessageService getMessageService() {
		return new MessageService() {
			
		
			public boolean sendMessage(String messageContent, String recipientAddress) {
				System.out.println("Test message called.");
				return true;
			}
		};
	}

	@Before
	public void setUp() throws Exception{
		context = new AnnotationConfigApplicationContext(AppTest.class);
	}

	@After
	public void tearDown() throws Exception{
		context.close();
	}

	@Test
	public void test1() {
		MessageService service = context.getBean(MessageService.class);
		Assert.assertTrue(service.sendMessage("Hi", "abc@gmail.com"));
	}
}
