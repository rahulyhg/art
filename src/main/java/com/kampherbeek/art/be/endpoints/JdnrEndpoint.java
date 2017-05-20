package com.kampherbeek.art.be.endpoints;


import com.kampherbeek.art.be.handlers.JdnrHandler;
import com.kampherbeek.art.domain.requests.JdnrRequest;
import com.kampherbeek.art.domain.requests.Request;
import com.kampherbeek.art.domain.responses.JdnrResponse;
import com.kampherbeek.art.domain.responses.Response;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

public class JdnrEndpoint {

    private final JdnrHandler handler;

    @Autowired
    public JdnrEndpoint(@NonNull JdnrHandler handler) {
        this.handler = handler;
    }

    public Response handleRequest(Request request) {
        JdnrResponse response = new JdnrResponse();
        if (request instanceof JdnrRequest) {
            response.setJdnr(handler.getJdnr((JdnrRequest)request));
            response.setStatusText("OK");
        } else {
            response.setStatusText("ERROR");
        }
        return response;
    }

}
