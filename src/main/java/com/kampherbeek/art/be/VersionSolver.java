package com.kampherbeek.art.be;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@PropertySource("classpath:application.properties")
public class VersionSolver {

	@Getter
	@Value("${version}")
	private String version; 
	
}
