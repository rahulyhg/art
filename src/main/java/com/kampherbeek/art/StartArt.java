package com.kampherbeek.art;

import com.kampherbeek.art.fe.main.MainController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


/**
 * Starts Spring context and the main frame of Swing. 
 */
@ComponentScan(basePackages = "com.kampherbeek.art")
public class StartArt {  

	public static void main(String[] args) {  
        @SuppressWarnings("resource")   // context is closed after closing the application.
		ApplicationContext context = new AnnotationConfigApplicationContext(StartArt.class);
        StartArt app = context.getBean(StartArt.class);
        app.start();
	}  
	
	@Autowired
	private MainController mainController;
	private void start() {
		mainController.show();
	}
	
} 
