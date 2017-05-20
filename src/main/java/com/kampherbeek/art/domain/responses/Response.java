package com.kampherbeek.art.domain.responses;

import lombok.NonNull;

public interface Response {

    void setStatusText(@NonNull String statusText);
	@NonNull String getStatusText();
}
