/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.be.handlers;

import com.kampherbeek.art.be.solvers.VersionSolver;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;


/** 
 * Constructs a text with version information.
 */
@Component
public class VersionHandler {
	
	@Getter
	private String version;

	@Autowired
	public VersionHandler(@NonNull VersionSolver solver) {
		version = solver.getVersion();
	}

}
