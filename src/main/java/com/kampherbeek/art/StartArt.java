package com.kampherbeek.art;

import com.kampherbeek.art.fe.main.MainController;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


/**
 * Starts Spring context and the main frame of Swing. 
 */
@ComponentScan(basePackages = "com.kampherbeek.art")
@Component
public class StartArt {

	private final MainController mainController;
	@Autowired
	public StartArt(@NonNull final MainController mainController) {
		this.mainController = mainController;
	}

	public static void main(String[] args) {
        @SuppressWarnings("resource")   // context is closed after closing the application.
		ApplicationContext context = new AnnotationConfigApplicationContext(StartArt.class);
        StartArt app = context.getBean(StartArt.class);
        app.start();
	}  
	
	private void start() {
		mainController.show();
	}
	
} 
