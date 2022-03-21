package main.java;

import main.java.DataStructures.AvailableOptions;
import main.java.DataStructures.UserChoices;
import main.java.Utils.XMLParser;
import main.java.Utils.BiMapConvertor;

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
        BiMapConvertor biMapConvertor = new BiMapConvertor();
        availableOptions = biMapConvertor.knowledgeBaseToGuiFormat(availableOptions.smMp, availableOptions.platform, availableOptions.genre, availableOptions.contentRating);
        JComboBox availableSpMpJComboBox =  new JComboBox(availableOptions.smMp);
        JComboBox availablePlatformJComboBox =  new JComboBox(availableOptions.platform);
        JComboBox availableGenreJComboBox =  new JComboBox(availableOptions.genre);
        JComboBox availableContentRatingJComboBox =  new JComboBox(availableOptions.contentRating);

        UserChoices userChoices = biMapConvertor.guiToKnowledgeBaseFormat(availableOptions.smMp[0], availableOptions.platform[3], availableOptions.genre[4], availableOptions.contentRating[2]);
        JComboBox temp = new JComboBox(new String[]{userChoices.getSpMpChoice(), userChoices.getPlatformChoice(), userChoices.getGenreChoice(), userChoices.getContentRatingChoice()});

        generalPanel.add(availableSpMpJComboBox);
        generalPanel.add(availablePlatformJComboBox);
        generalPanel.add(availableGenreJComboBox);
        generalPanel.add(availableContentRatingJComboBox);
        generalPanel.add(temp);

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
