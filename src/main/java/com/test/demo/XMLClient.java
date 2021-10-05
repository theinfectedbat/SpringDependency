/**
 * 
 */
package com.test.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.demo.servicesExecutor.ServiceExecutor;
import com.test.demo.servicesExecutor.XMLTypeExecutor;

/**
 * @author Harshal
 * 
 *	-> Steps happening as I can understand
 *
 *	1. All the given class / classes inside the XML file are initiated by application context.
 *
 *	2. While Step#1 is done, internal dependencies are pre-filled (provided in XML only).  
 *
 *	3. Just get required bean object via it's class type OR ID string and convert it if required.
 *
 *	4. Use the objects created in Step#3.
 */
public class XMLClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// XML file will behave as an injector class (that's why kept in folder instead of class path)
		AbstractApplicationContext context = new 
				ClassPathXmlApplicationContext("com/test/demo/servicesInjector/twitter-bean-injector.xml");
		
		// service consumer class; based on above context find a bean with given class type
		/*
		 * if getBean(CLASS_TYPE) is used; no need to type cast it.
		 */
		//XMLTypeExecutor service = context.getBean(XMLTypeExecutor.class);
		
		/*
		 * if getBean(String ID) is used; it will return "java.lang.Object" 
		 * type object which has to be type casted.
		 */
		ServiceExecutor service = (XMLTypeExecutor) context.getBean("myXMLApp");
		
		// execute the service
		service.executeService("Hi there...", "abc@gmail.com");
		
		// close context (not available with interface type ApplicationContext)
		context.close();
	}

}
