package edu.mum;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	private final static String[] configFilesGatewayDemo = { "/app-context.xml" };

	public static void main(String[] args) {

		@SuppressWarnings({ "unused", "resource" })
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configFilesGatewayDemo, App.class);
	}
}
