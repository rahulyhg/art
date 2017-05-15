package com.kampherbeek.art.fe.calc;


import lombok.NonNull;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

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
    private JTextField dateField;
    private ResourceBundle rb;


    public CalcInputPanelCreator() {
        Locale.setDefault(new Locale("en", "US"));  // TODO use config for Locale
        rb = ResourceBundle.getBundle("art_common");
    }


    public JPanel constructPanel(@NonNull CalcInputListener listener) {
            this.listener = listener;
            inputPanel = new JPanel();
            defineTexts();
            dateField = new JTextField(10);

            calcButton = new JButton(rb.getString("CALC.BTN.CALC "));
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

    private void defineTexts() {
        dateLabel = new JLabel(rb.getString("GENERAL.LBL.DATE"));
        timeLabel = new JLabel(rb.getString("GENERAL.LBL.TIME"));
        calendarLabel = new JLabel(rb.getString("GENERAL.LBL.CALENDAR"));
        longitudeLabel = new JLabel(rb.getString("GENERAL.LBL.LONGITUDE"));
        latitudeLabel = new JLabel(rb.getString("GENERAL.LBL.LATITUDE"));
    }


    private void layoutComponents() {
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridy = 0;

        // first row
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


        gc.gridy++;
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
