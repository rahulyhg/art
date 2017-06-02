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

@Component
public class VersionSolver {

    private final Settings settings;

	@Autowired
	public VersionSolver(@NonNull Settings settings) {
	    this.settings = settings;
	}

    public String getVersion() {
	    return settings.getVersion();
    }

}
