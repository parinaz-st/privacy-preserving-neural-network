package org.example.gui;

import org.example.MainBobApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionListener implements ActionListener {
    private MainBobApp app;

    public ButtonActionListener(MainBobApp app) {
        this.app = app;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == app.getStartServerButton()) {
            app.getServerManager().startServer();
        } else if (event.getSource() == app.getStopServerButton()) {
            app.getServerManager().stopServer();
        }
    }
}

