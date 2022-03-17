package main.java;

import javax.swing.*;
import java.awt.*;

public class GUIMain {

    JFrame frame = new JFrame();

    public static void main(String[] args) {
        new GUIMain();
    }
    public GUIMain() {
        initializeUI();
    }

    public void initializeUI() {

        // Main Frame
        JPanel generalPanel = new JPanel();
        generalPanel.setBorder(BorderFactory.createEmptyBorder(250, 250, 250, 250));

        generalPanel.add(new JLabel("Test"));

        frame.setTitle("Games Recommendation SE");
        ImageIcon logo = new ImageIcon("src/main/resources/logo.png");
        frame.setIconImage(logo.getImage());
        frame.add(generalPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
