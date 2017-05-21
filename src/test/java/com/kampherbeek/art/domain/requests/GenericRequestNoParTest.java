/***********************************************************************************************************************
 *  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
 *  ART is open source.
 *  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 **********************************************************************************************************************/

package com.kampherbeek.art.domain.requests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class GenericRequestNoParTest {

    private GenericRequestNoPar request;

    @Before
    public void setUp() throws Exception {
        request = new GenericRequestNoPar();
    }

    @Test
    public void isValid() throws Exception {
        // as requst has no parameters, it should always be valid.
        assertTrue(request.isValid());
    }

}