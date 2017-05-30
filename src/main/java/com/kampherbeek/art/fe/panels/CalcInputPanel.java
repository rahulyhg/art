/*
  Copyright (C) 2017 Jan Kampherbeek (http://radixpro.org).
  ART is open source.
  Please check the file 'Copyright for ART' in the folder 'copyright' at the root of this distribution.
 */

package com.kampherbeek.art.fe.panels;

import com.kampherbeek.art.fe.buildingblocks.InfoLabel;
import com.kampherbeek.art.fe.events.CalcInputEvent;
import com.kampherbeek.art.fe.listeners.CalcInputListener;
import com.kampherbeek.art.fe.constants.GcConstants;
import com.kampherbeek.art.fe.constants.PanelConstants;
import com.kampherbeek.art.fe.controllers.CalcController;
import com.kampherbeek.art.util.TextProvider;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class CalcInputPanel extends JPanel {

    private final TextProvider textProvider;
    private final CalcInputListener listener;
    @Setter
    private CalcController controller;
    private JButton calcButton;
    private JLabel dateLabel;
    private JLabel dateInfoLabel;
    private JLabel timeLabel;
    private JLabel timeInfoLabel;
    private JLabel calendarLabel;
    private JLabel longitudeLabel;
    private JLabel longitudeInfoLabel;
    private JLabel latitudeLabel;
    private JLabel latitudeInfoLabel;
    private JRadioButton gregorianRadio;
    private JRadioButton julianRadio;
    private JTextField dateField;
    private JTextField timeField;
    private JTextField latitudeField;
    private JTextField longitudeField;
    private GridBagConstraints gc;

    @Autowired
    public CalcInputPanel(@NonNull TextProvider textProvider,
                          @NonNull CalcInputListener listener) {
        this.textProvider = textProvider;
        this.listener = listener;
        defineComponents();
        defineBorders();
        layoutComponents();
        defineActions();
    }


    private void defineComponents() {
        dateLabel = new JLabel(textProvider.getText("GENERAL.LBL.DATE"));
        dateInfoLabel = new InfoLabel(textProvider.getText("GENERAL.LBL.DATE.INFO"));
        timeLabel = new JLabel(textProvider.getText("GENERAL.LBL.TIME"));
        timeInfoLabel = new InfoLabel(textProvider.getText("GENERAL.LBL.TIME.INFO"));
        calendarLabel = new JLabel(textProvider.getText("GENERAL.LBL.CALENDAR"));
        longitudeLabel = new JLabel(textProvider.getText("GENERAL.LBL.LONGITUDE"));
        longitudeInfoLabel = new InfoLabel(textProvider.getText("GENERAL.LBL.LONGITUDE.INFO"));
        latitudeLabel = new JLabel(textProvider.getText("GENERAL.LBL.LATITUDE"));
        latitudeInfoLabel = new InfoLabel(textProvider.getText("GENERAL.LBL.LATITUDE.INFO"));
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
        calcButton = new JButton(textProvider.getText("CALC.BTN.JDNR"));
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
                boolean gregorian = gregorianRadio.isSelected();
                CalcInputEvent event = new CalcInputEvent(this, dateText, gregorian, timeText,
                        latitudeText, longitudeText, controller);
                if (listener != null) {
                    listener.calcInputEventOccurred(event);
                }
            }
        };
    }

    private void defineBorders() {
        String key = "CALC.TITLE.INPUTPANEL";
        Border innerBorder = BorderFactory.createTitledBorder(textProvider.getText(key));
        int size = PanelConstants.MEDIUM_BORDER_WIDTH.getSize();
        Border outerBorder = BorderFactory.createEmptyBorder(size, size, size, size);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
    }

    private void layoutComponents() {
        setLayout(new GridBagLayout());
        gc = new GridBagConstraints();
        gc.weightx = GcConstants.M.getValue();

        Insets standardInsets = new Insets(0, 5, 0, 5);
        int yAxis = 0;
        int fillNone = GridBagConstraints.NONE;
        int anchorLE = GridBagConstraints.LINE_END;
        int anchorLS = GridBagConstraints.LINE_START;
        double weightS = GcConstants.S.getValue();
        double weightXS = GcConstants.XS.getValue();
        double weightM = GcConstants.M.getValue();

        // date
        addToGc(0, yAxis, 1, weightS, fillNone, anchorLE, standardInsets, dateLabel);
        addToGc(1, yAxis, 1, weightS, fillNone, anchorLE, standardInsets, dateField);
        addToGc(0, ++yAxis, 2, weightXS, fillNone, anchorLE, standardInsets, dateInfoLabel);
        // time
        addToGc(0, ++yAxis, 1, weightS, fillNone, anchorLE, standardInsets, timeLabel);
        addToGc(1, yAxis, 1, weightS, fillNone, anchorLE, standardInsets, timeField);
        addToGc(0, ++yAxis, 2, weightXS, fillNone, anchorLE, standardInsets, timeInfoLabel);
        // calendar
        addToGc(0, ++yAxis, 1, weightXS, fillNone, anchorLE, standardInsets, calendarLabel);
        addToGc(1, yAxis, 1, weightXS, fillNone, anchorLS, standardInsets, gregorianRadio);
        addToGc(1, ++yAxis, 1, weightXS, fillNone, anchorLS, standardInsets, julianRadio);
        // latitude
        addToGc(0, ++yAxis, 1, weightS, fillNone, anchorLE, standardInsets, latitudeLabel);
        addToGc(1, yAxis, 1, weightS, fillNone, anchorLE, standardInsets, latitudeField);
        addToGc(0, ++yAxis, 2, weightXS, fillNone, anchorLE, standardInsets, latitudeInfoLabel);
        // longitude
        addToGc(0, ++yAxis, 1, weightS, fillNone, anchorLS, standardInsets, longitudeLabel);
        addToGc(1, yAxis, 1, weightS, fillNone, anchorLE, standardInsets, longitudeField);
        addToGc(0, ++yAxis, 2, weightXS, fillNone, anchorLE, standardInsets, longitudeInfoLabel);
        // button
        addToGc(0, ++yAxis, 1, weightM, fillNone, anchorLE, standardInsets, calcButton);
    }


    private void addToGc(int x, int y, int gridwidth, double weightY,
                         @NonNull int fill, @NonNull int anchor,
                         @NonNull Insets insets, @NonNull JComponent component) {
        gc.gridx = x;
        gc.gridy = y;
        gc.gridwidth = gridwidth;
        gc.weighty = weightY;
        gc.fill = fill;
        gc.anchor = anchor;
        gc.insets = insets;
        add(component, gc);
    }


}


