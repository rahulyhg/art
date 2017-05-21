/***********************************************************************************************************************
 *  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
 *  ART is open source.
 *  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 **********************************************************************************************************************/

package com.kampherbeek.art.domain.dto;


/**
 * Interface for DTO's that have tried to be validated.
 */
public interface ValidatedDto {

    boolean isValid();

}
