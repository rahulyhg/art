/***********************************************************************************************************************
 *  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
 *  ART is open source.
 *  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 **********************************************************************************************************************/

package com.kampherbeek.art.be.handlers;


import com.kampherbeek.art.be.solvers.JdnrSolver;
import com.kampherbeek.art.domain.requests.JdnrRequest;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

public class JdnrHandler {

    private final JdnrSolver solver;

    @Autowired
    public JdnrHandler(@NonNull JdnrSolver solver) {
        this.solver = solver;
    }

    public double getJdnr(@NonNull JdnrRequest request) {
        return solver.calcJdnr(request.getDateDto(), request.getTimeDto());
    }

}
