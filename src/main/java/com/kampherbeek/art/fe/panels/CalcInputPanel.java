/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.panels;

import com.kampherbeek.art.fe.calc.CalcInputEvent;
import com.kampherbeek.art.fe.calc.CalcInputListener;
import com.kampherbeek.art.fe.constants.GcConstants;
import com.kampherbeek.art.fe.controllers.CalcController;
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
public class CalcInputPanel extends JPanel {

    private final TextProvider textProvider;
    private final CalcInputListener listener;
    @Setter @Getter
    private CalcController controller;
    private JButton calcButton;
    private JLabel dateLabel;
    private JLabel timeLabel;
    private JLabel calendarLabel;
    private JLabel longitudeLabel;
    private JLabel latitudeLabel;
    private JRadioButton gregorianRadio;
    private JRadioButton julianRadio;
    private JTextField dateField;
    private JTextField timeField;
    private JTextField latitudeField;
    private JTextField longitudeField;

    @Autowired
    public CalcInputPanel(@NonNull TextProvider textProvider,
                          @NonNull CalcInputListener listener) {
        this.textProvider = textProvider;
        this.listener = listener;
        defineComponents();
        layoutComponents();
        defineActions();
    }


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
        ButtonGroup calendarGroup = new ButtonGroup();
        calendarGroup.add(julianRadio);
        calendarGroup.add(gregorianRadio);
        calcButton = new JButton(textProvider.getText("CALC.BTN.CALC"));
    }

    private void defineActions() {
        calcButton.addActionListener(createActionListener());
    }

    private ActionListener createActionListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dateText = dateField.getText();
                String timeText = timeField.getText();
                String latitudeText = latitudeField.getText();
                String longitudeText = longitudeField.getText();
                CalcInputEvent event = new CalcInputEvent(this, dateText, timeText, latitudeText, longitudeText,
                        controller.getResultPanel());
                if (listener != null) {
                    listener.calcInputEventOccurred(event);
                }
            }
        };
    }

    private void layoutComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridy = 0;
        gc.weightx = GcConstants.M.getValue();

        // date
        gc.gridx = 0;
        gc.weighty = GcConstants.S.getValue();
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(dateLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateField, gc);

        // time
        gc.gridx = 0;
        gc.gridy++;
        gc.weighty = GcConstants.S.getValue();
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(timeLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(timeField, gc);

        // calendar
        gc.gridx = 0;
        gc.gridy++;
        gc.weighty = GcConstants.XS.getValue();
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(calendarLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(gregorianRadio, gc);

        // calendar 2nd line
        gc.gridy++;
        gc.weighty = GcConstants.XS.getValue();
        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(julianRadio, gc);

        // latitude
        gc.gridx = 0;
        gc.gridy++;
        gc.weighty = GcConstants.S.getValue();
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(latitudeLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(latitudeField, gc);

        // longitude
        gc.gridx = 0;
        gc.gridy++;
        gc.weighty = GcConstants.S.getValue();
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(longitudeLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(longitudeField, gc);

        gc.gridy++;
        gc.weighty = GcConstants.M.getValue();
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 5, 0, 5);
        add(calcButton, gc);
    }


}


