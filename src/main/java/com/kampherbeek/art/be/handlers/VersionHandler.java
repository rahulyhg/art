package com.kampherbeek.art.be.handlers;

import com.kampherbeek.art.be.solvers.VersionSolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;


/** 
 * Constructs a text with version information.
 */
@Component
public class VersionHandler {
	
	private final
    VersionSolver solver;
	@Getter
	private String version;

	@Autowired
	public VersionHandler(VersionSolver solver) {
		this.solver = solver;
		defineVersion();
	}
	
	private void defineVersion() {
		version = solver.getVersion();
	}
	
}
