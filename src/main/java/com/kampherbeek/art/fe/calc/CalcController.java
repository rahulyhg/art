package com.kampherbeek.art.fe.calc;


import com.kampherbeek.art.util.TextProvider;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;


@Component
public class CalcController {

    private JFrame calcFrame;
    private JPanel inputPanel;
    private JPanel resultPanel;


    private final TextProvider textProvider;
    private final CalcInputPanelCreator inputPanelCreator;
    @Autowired
    public CalcController(@NonNull CalcInputPanelCreator inputPanelCreator, @NonNull TextProvider textProvider) {
        this.inputPanelCreator = inputPanelCreator;
        this.textProvider = textProvider;
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

        calcFrame = new JFrame(textProvider.getText("CALC.TITLE"));
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

