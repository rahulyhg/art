/***********************************************************************************************************************
 *  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
 *  ART is open source.
 *  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 **********************************************************************************************************************/

package com.kampherbeek.art.fe.panelcreators;


import com.kampherbeek.art.fe.calc.CalcInputListener;
import com.kampherbeek.art.util.TextProvider;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class CalcInputPanelCreator {

    private JPanel inputPanel;
    private CalcInputListener listener;
    private JButton calcButton;
    private JLabel dateLabel;
    private JLabel timeLabel;
    private JLabel calendarLabel;
    private JLabel longitudeLabel;
    private JLabel latitudeLabel;
    private JRadioButton gregorianRadio;
    private JRadioButton julianRadio;
    private ButtonGroup calendarGroup;
    private JTextField dateField;
    private JTextField timeField;
    private JTextField latitudeField;
    private JTextField longitudeField;
    private final TextProvider textProvider;

    @Autowired
    public CalcInputPanelCreator(@NonNull TextProvider textProvider) {
        this.textProvider = textProvider;
        defineComponents();
    }


    public JPanel constructPanel(@NonNull CalcInputListener listener) {
            this.listener = listener;
            inputPanel = new JPanel();
            defineComponents();

            layoutComponents();
//            defineActions();
            return inputPanel;
        }


//    private void defineActions() {
//        horoscopeBtn.addActionListener(createActionListener("HOROSCOPES"));
//        cyclesBtn.addActionListener(createActionListener("CYCLES"));
//        statisticsBtn.addActionListener(createActionListener("STATISTICS"));
//        calculatorsBtn.addActionListener(createActionListener("CALCULATORS"));
//        exitBtn.addActionListener(createActionListener("EXIT"));
//
//    }

//    private ActionListener createActionListener(@NonNull final String btnType) {
//        return new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                MainNavigationEvent event = new MainNavigationEvent(navPanel, btnType);
//                if (listener != null) {
//                    listener.navigationEventOccurred(event);
//                }
//            }
//        };
//    }

    private void defineComponents() {
        dateLabel = new JLabel(textProvider.getText("GENERAL.LBL.DATE"));
        timeLabel = new JLabel(textProvider.getText("GENERAL.LBL.TIME"));
        calendarLabel = new JLabel(textProvider.getText("GENERAL.LBL.CALENDAR"));
        longitudeLabel = new JLabel(textProvider.getText("GENERAL.LBL.LONGITUDE"));
        latitudeLabel = new JLabel(textProvider.getText("GENERAL.LBL.LATITUDE"));
        dateField = new JTextField(10);
        timeField = new JTextField(10);
        latitudeField = new JTextField(10);
        longitudeField = new JTextField(10);
        gregorianRadio = new JRadioButton(textProvider.getText("GENERAL.RADIO.GREGORIAN"));
        julianRadio = new JRadioButton(textProvider.getText("GENERAL.RADIO.JULIAN"));
        gregorianRadio.setSelected(true);
        calendarGroup = new ButtonGroup();
        calendarGroup.add(julianRadio);
        calendarGroup.add(gregorianRadio);
        calcButton = new JButton(textProvider.getText("CALC.BTN.CALC"));
    }


    private void layoutComponents() {
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridy = 0;

        // date
        gc.gridx = 0;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        inputPanel.add(dateLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        inputPanel.add(dateField, gc);


        // time
        gc.gridx = 0;
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        inputPanel.add(timeLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        inputPanel.add(timeField, gc);

        // calendar
        gc.gridx = 0;
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.02;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        inputPanel.add(calendarLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        inputPanel.add(gregorianRadio, gc);

        // calendar 2nd line
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.02;
        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        inputPanel.add(julianRadio, gc);

        // latitude
        gc.gridx = 0;
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        inputPanel.add(latitudeLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        inputPanel.add(latitudeField, gc);

        // longitude
        gc.gridx = 0;
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        inputPanel.add(longitudeLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        inputPanel.add(longitudeField, gc);






        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 5, 0, 5);
        inputPanel.add(calcButton, gc);
    }


/*
    public void layoutComponents() {
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.gridy = 0;


        // first row
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(nameLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gc);


        // next row

        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(occupationLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(occupationField, gc);

        // next row
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(new JLabel("Age: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(ageList, gc);

        // next row
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(new JLabel("Employment: "), gc);


        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.2;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(empCombo, gc);

        // next row
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(new JLabel("US Citizen: "), gc);


        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.2;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(citizenCheck, gc);

        // next row
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(taxLabel, gc);


        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.2;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(taxField, gc);

        // next row
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 2.0;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(okBtn, gc);

    }
 */


}
