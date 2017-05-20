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
