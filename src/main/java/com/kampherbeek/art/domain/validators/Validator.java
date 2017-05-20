package com.kampherbeek.art.domain.validators;


import lombok.NonNull;

public interface Validator {

    boolean validate(@NonNull Object x);

}
