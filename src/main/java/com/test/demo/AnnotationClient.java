/**
 * 
 */
package com.test.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.test.demo.servicesExecutor.AnnotationExecutor;
import com.test.demo.servicesExecutor.DummyExecutor;
import com.test.demo.servicesExecutor.ServiceExecutor;
import com.test.demo.servicesInjector.EMailServiceInjector;

/**
 * @author Harshal
 *
 *	-> Steps happening as I can understand
 *	
 *	1. All the given class / classes with @Configuration tag initiated by application context and all are initiated.
 *
 *	2. Once such instance/s are in process; using the data present in @ComponentScan tag of configuration classes; all classes which 
 *		are annotated with @Component are loaded one by one and simultaneously for each class; Step#3 is performed.
 *
 *	3. If object loaded in Step#2 would have some dependency; that is fulfilled by the respective @Bean method with specific type 
 *		present inside the application context class in Step#1. This internal dependency is auto-wired by @Autowired annotation.
 *
 *	4. Once all the dependencies are fulfilled for all objects in Step#2; use those objects.
 *
 */
public class AnnotationClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// injector class type in arguments which will provide a service
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(EMailServiceInjector.class);

		// service consumer class; based on above context
		//System.out.println("##Specific beans will be retrieved now.##");
		ServiceExecutor service = context.getBean(AnnotationExecutor.class);
		DummyExecutor dServiceExecutor = context.getBean(DummyExecutor.class);

		// execute the service 1
		//System.out.println("##All objects & dependencies are resolved. Client will executeService() now.##");
		service.executeService("Hi there...", "abc@gmail.com");
		dServiceExecutor.executeDummyService();

		// close context (not available with interface type ApplicationContext)
		context.close();
	}

}
