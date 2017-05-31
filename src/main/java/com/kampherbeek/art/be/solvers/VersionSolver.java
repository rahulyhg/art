/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.be.solvers;


import com.kampherbeek.art.config.Settings;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
public class VersionSolver {

	@Getter
	private String version;

	@Autowired
	public VersionSolver(@NonNull Settings settings) {
		this.version = settings.getVersion();
	}
}
