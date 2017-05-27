/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.domain.requests;

/**
 * Request without parameters. Action is fully defined by the accessed endpoint.
 */
public class GenericRequestNoPar implements Request {

	@Override
	public boolean isValid() {
		return true;
	}
}
