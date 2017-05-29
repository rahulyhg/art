/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.frames;

import com.kampherbeek.art.be.endpoints.VersionEndpoint;
import com.kampherbeek.art.domain.requests.GenericRequestNoPar;
import com.kampherbeek.art.domain.requests.Request;
import com.kampherbeek.art.domain.responses.VersionResponse;
import com.kampherbeek.art.fe.constants.FrameConstants;
import com.kampherbeek.art.fe.controllers.MainController;
import com.kampherbeek.art.fe.panels.MainInfoPanel;
import com.kampherbeek.art.fe.panels.MainNavPanel;
import com.kampherbeek.art.util.TextConstants;
import com.kampherbeek.art.util.TextProvider;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MainFrame extends JFrame {

    private final MainInfoPanel infoPanel;
    @Getter
    private final MainNavPanel navPanel;
    private final VersionEndpoint versionEndpoint;
    private final TextProvider textProvider;
    private MainController controller;

    public MainFrame(@NonNull MainInfoPanel infoPanel,
                     @NonNull MainNavPanel navPanel,
                     @NonNull VersionEndpoint versionEndpoint,
                     @NonNull TextProvider textProvider) {
        this.infoPanel = infoPanel;
        this.navPanel = navPanel;
        this.versionEndpoint = versionEndpoint;
        this.textProvider = textProvider;
        constructFrame();
    }


    public void constructFrame() {
        this.setTitle(createTitle());
        setLayout(new BorderLayout());
        add(navPanel, BorderLayout.WEST);
        add(infoPanel, BorderLayout.CENTER);
        setSize(FrameConstants.DEFAULT_WIDTH.getSize(), FrameConstants.DEFAULT_HEIGHT.getSize());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void setController(@NonNull MainController controller) {
        this.controller = controller;
        navPanel.setController(controller);
    }

    private String createTitle() {
        Request request = new GenericRequestNoPar();
        VersionResponse response = (VersionResponse)versionEndpoint.handleRequest(request);
        final String key = "GENERAL.TITLE";
        return textProvider.getText(key)
                + TextConstants.SPACE.getText() + TextConstants.DIVISON.getText() + TextConstants.SPACE.getText()
                + response.getVersion();
    }

}
