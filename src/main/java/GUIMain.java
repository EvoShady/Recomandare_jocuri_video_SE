package main.java;

import main.java.DataStructures.AvailableOptions;
import main.java.DataStructures.UserChoices;
import main.java.Utils.XMLParser;
import main.java.Utils.BiMapConvertor;

import javax.swing.*;
import java.awt.*;

public class GUIMain {

    JFrame frame = new JFrame();
    JPanel spMpPanel = new JPanel();
    JPanel platformPanel = new JPanel();
    JPanel genrePanel = new JPanel();
    JPanel contentRatingPanel = new JPanel();
    JPanel conclusionPanel = new JPanel();
    JPanel generalPanel = new JPanel();
    JPanel choicePanel = new JPanel();
    JLabel conclusionLabel = new JLabel("");;

    public static void main(String[] args) {
        new GUIMain();
    }
    public GUIMain() {
        initializeUI();
    }

    public void initializeUI() {

        // Preparation logic
        XMLParser xmlParser = new XMLParser();
        AvailableOptions availableOptions = xmlParser.getAvailableOptions();
        BiMapConvertor biMapConvertor = new BiMapConvertor();
        availableOptions = biMapConvertor.knowledgeBaseToGuiFormat(availableOptions.smMp, availableOptions.platform, availableOptions.genre, availableOptions.contentRating);
        JComboBox availableSpMpJComboBox =  new JComboBox(availableOptions.smMp);
        JComboBox availablePlatformJComboBox =  new JComboBox(availableOptions.platform);
        JComboBox availableGenreJComboBox =  new JComboBox(availableOptions.genre);
        JComboBox availableContentRatingJComboBox =  new JComboBox(availableOptions.contentRating);

        // SpMp Panel
        spMpPanel.setBorder(BorderFactory.createTitledBorder("Tip"));
        spMpPanel.add(availableSpMpJComboBox);

        // Platform Panel
        platformPanel.setBorder(BorderFactory.createTitledBorder("Platforma"));
        platformPanel.add(availablePlatformJComboBox);

        // Genre Panel
        genrePanel.setBorder(BorderFactory.createTitledBorder("Gen"));
        genrePanel.add(availableGenreJComboBox);

        // Content Rating Panel
        contentRatingPanel.setBorder(BorderFactory.createTitledBorder("Varsta"));
        contentRatingPanel.add(availableContentRatingJComboBox);

        // Choice Panel
        choicePanel.setLayout(new GridLayout(2, 2));

        choicePanel.add(spMpPanel);
        choicePanel.add(platformPanel);
        choicePanel.add(genrePanel);
        choicePanel.add(contentRatingPanel);

        // Button Panel
        JButton conclusionButton = new JButton("Search");
        conclusionButton.addActionListener(e-> getConclusion());
        JPanel conclusionButtonPanel = new JPanel();
        conclusionButtonPanel.add(conclusionButton);

        // General Panel
        generalPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        generalPanel.setLayout(new GridLayout(0, 1));
        generalPanel.add(choicePanel);
        generalPanel.add(conclusionButtonPanel);

        // Main Frame
        frame.setTitle("Games Recommendation SE");
        ImageIcon logo = new ImageIcon("src/main/resources/logo.png");
        frame.setIconImage(logo.getImage());
        frame.add(generalPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void getConclusion(){
        conclusionLabel.setText("Not implemented yet");

        conclusionPanel.add(conclusionLabel);
        conclusionPanel.setBorder(BorderFactory.createTitledBorder("Recommended games"));
        generalPanel.add(conclusionPanel);
        frame.pack();
    }
}
