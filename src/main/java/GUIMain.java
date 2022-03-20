package main.java;

import main.java.DataStructures.AvailableOptions;
import main.java.Utils.XMLParser;

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
        generalPanel.setBorder(BorderFactory.createEmptyBorder(150, 150, 150, 150));

        XMLParser xmlParser = new XMLParser();
        AvailableOptions availableOptions = xmlParser.getAvailableOptions();
        JComboBox availableSpMpJComboBox =  new JComboBox(availableOptions.smMp);
        JComboBox availablePlatformJComboBox =  new JComboBox(availableOptions.platform);
        JComboBox availableGenreJComboBox =  new JComboBox(availableOptions.genre);
        JComboBox availableContentRatingJComboBox =  new JComboBox(availableOptions.contentRating);

        generalPanel.add(availableSpMpJComboBox);
        generalPanel.add(availablePlatformJComboBox);
        generalPanel.add(availableGenreJComboBox);
        generalPanel.add(availableContentRatingJComboBox);

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
