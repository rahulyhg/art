/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.panels;

import com.kampherbeek.art.fe.controllers.MainController;
import com.kampherbeek.art.fe.main.MainNavigationEvent;
import com.kampherbeek.art.fe.main.MainNavigationListener;
import com.kampherbeek.art.util.TextProvider;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class MainNavPanel extends JPanel {

    private JButton chartsBtn;
    private JButton cyclesBtn;
    private JButton statisticsBtn;
    private JButton calculatorsBtn;
    private JButton exitBtn;
    private MainNavigationListener listener;
    @Getter
    @Setter
    private MainController controller;
    private final TextProvider textProvider;


    @Autowired
    public MainNavPanel(@NonNull TextProvider textProvider,
                        @NonNull MainNavigationListener listener) {
        this.textProvider = textProvider;
        this.listener = listener;
        defineComponents();
        layoutComponents();
        defineActions();
    }


    private void defineComponents() {
        chartsBtn = new JButton(textProvider.getText("GENERAL.BTN.HOROSCOPES"));
        cyclesBtn = new JButton(textProvider.getText("GENERAL.BTN.CYCLES"));
        statisticsBtn = new JButton(textProvider.getText("GENERAL.BTN.STATISTICS"));
        calculatorsBtn = new JButton(textProvider.getText("GENERAL.BTN.CALCULATORS"));
        exitBtn = new JButton(textProvider.getText("GENERAL.BTN.EXIT"));
    }

    private void layoutComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridy = 0;
        gc.gridx = 0;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 5, 0, 5);
        add(chartsBtn, gc);
        gc.gridy++;
        add(cyclesBtn, gc);
        gc.gridy++;
        add(statisticsBtn, gc);
        gc.gridy++;
        add(calculatorsBtn, gc);
        gc.gridy++;
        gc.weighty = 1.0;
        add(exitBtn, gc);
    }


    private void defineActions() {
        chartsBtn.addActionListener(createActionListener("HOROSCOPES", this));
        cyclesBtn.addActionListener(createActionListener("CYCLES", this));
        statisticsBtn.addActionListener(createActionListener("STATISTICS", this));
        calculatorsBtn.addActionListener(createActionListener("CALCULATORS", this));
        exitBtn.addActionListener(createActionListener("EXIT", this));

    }

    private ActionListener createActionListener(@NonNull final String btnType, @NonNull MainNavPanel navPanel) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainNavigationEvent event = new MainNavigationEvent(this, btnType, navPanel);
                if (listener != null) {
                    listener.navigationEventOccurred(event);
                }
            }
        };
    }

}


