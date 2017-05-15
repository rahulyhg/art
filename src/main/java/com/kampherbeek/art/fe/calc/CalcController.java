package com.kampherbeek.art.fe.calc;


import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

import static java.util.Locale.setDefault;

@Component
public class CalcController {

    private JFrame calcFrame;
    private JPanel inputPanel;
    private JPanel resultPanel;
    private ResourceBundle rb;

    @Autowired
    private CalcInputPanelCreator inputPanelCreator;
    public CalcController(@NonNull CalcInputPanelCreator inputPanelCreator) {
        this.inputPanelCreator = inputPanelCreator;
        Locale.setDefault(new Locale("en", "US"));  // TODO use config for Locale
        rb = ResourceBundle.getBundle("art_common");
    }

    public void show() {
        constructFrame();

    }


    // TODO retrieve text from backend
    private void constructFrame() {
        if (inputPanel == null)  {
            inputPanel = inputPanelCreator.constructPanel(new CalcInputListener() {
                public void calcInputEventOccurred(CalcInputEvent event) {

                }
            });
        }

        calcFrame = new JFrame(rb.getString("CALC.TITLE"));
        layoutComponents();
        calcFrame.setSize(600,500);
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calcFrame.setVisible(true);

    }


    private void layoutComponents() {
        calcFrame.setLayout(new BorderLayout());
        calcFrame.add(inputPanel, BorderLayout.WEST);
//        mainFrame.add(infoPanel, BorderLayout.CENTER);
    }

}

