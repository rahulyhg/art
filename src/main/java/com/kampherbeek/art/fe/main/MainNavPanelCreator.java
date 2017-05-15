package com.kampherbeek.art.fe.main;


import lombok.NonNull;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

@Component
public class MainNavPanelCreator {

    private JPanel navPanel;
    private JButton horoscopeBtn;
    private JButton cyclesBtn;
    private JButton statisticsBtn;
    private JButton calculatorsBtn;
    private JButton exitBtn;
    private MainNavigationListener listener;
    private ResourceBundle rb;

    public MainNavPanelCreator() {
        Locale.setDefault(new Locale("en", "US"));  // TODO use config for Locale
        rb = ResourceBundle.getBundle("art_common");
    }

    // TODO check possibilities to autowire listener, is currently an interface
    public JPanel constructPanel(@NonNull MainNavigationListener listener) {
        this.listener = listener;
        navPanel = new JPanel();
        horoscopeBtn = new JButton(rb.getString("GENERAL.BTN.HOROSCOPES"));
        cyclesBtn = new JButton(rb.getString("GENERAL.BTN.CYCLES"));
        statisticsBtn = new JButton(rb.getString("GENERAL.BTN.STATISTICS"));
        calculatorsBtn = new JButton(rb.getString("GENERAL.BTN.CALCULATORS"));
        exitBtn = new JButton(rb.getString("GENERAL.BTN.EXIT"));

        layoutComponents();
        defineActions();
        return navPanel;
    }


    private void defineActions() {
        horoscopeBtn.addActionListener(createActionListener("HOROSCOPES"));
        cyclesBtn.addActionListener(createActionListener("CYCLES"));
        statisticsBtn.addActionListener(createActionListener("STATISTICS"));
        calculatorsBtn.addActionListener(createActionListener("CALCULATORS"));
        exitBtn.addActionListener(createActionListener("EXIT"));

    }

    private ActionListener createActionListener(@NonNull final String btnType) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainNavigationEvent event = new MainNavigationEvent(navPanel, btnType);
                if (listener != null) {
                    listener.navigationEventOccurred(event);
                }
            }
        };
    }


    private void layoutComponents() {
        navPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridy = 0;
        gc.gridx = 0;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 5, 0, 5);
        navPanel.add(horoscopeBtn, gc);
        gc.gridy++;
        navPanel.add(cyclesBtn, gc);
        gc.gridy++;
        navPanel.add(statisticsBtn, gc);
        gc.gridy++;
        navPanel.add(calculatorsBtn, gc);
        gc.gridy++;
        gc.weighty = 1.0;
        navPanel.add(exitBtn, gc);
      }



}
