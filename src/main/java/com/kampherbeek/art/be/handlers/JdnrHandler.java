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
