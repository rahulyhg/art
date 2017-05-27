/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.domain.responses;

import lombok.NonNull;

public interface Response {

    void setStatusText(@NonNull String statusText);
	@NonNull String getStatusText();
}
