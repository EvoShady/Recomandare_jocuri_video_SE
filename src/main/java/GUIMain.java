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
    JLabel conclusionLabel = new JLabel("");

    XMLParser xmlParser;
    AvailableOptions availableOptions;
    BiMapConvertor biMapConvertor;
    JComboBox availableSpMpJComboBox;
    JComboBox availablePlatformJComboBox;
    JComboBox availableGenreJComboBox;
    JComboBox availableContentRatingJComboBox;

    public static void main(String[] args) {
        new GUIMain();
    }
    public GUIMain() {
        initializeUI();
    }

    public void initializeUI() {

        // Preparation logic
        xmlParser = new XMLParser();
        availableOptions = xmlParser.getAvailableOptions();
        biMapConvertor = new BiMapConvertor();
        availableOptions = biMapConvertor.knowledgeBaseToGuiFormat(availableOptions.smMp, availableOptions.platform, availableOptions.genre, availableOptions.contentRating);
        availableSpMpJComboBox =  new JComboBox(availableOptions.smMp);
        availablePlatformJComboBox =  new JComboBox(availableOptions.platform);
        availableGenreJComboBox =  new JComboBox(availableOptions.genre);
        availableContentRatingJComboBox =  new JComboBox(availableOptions.contentRating);

        // Category Panels
        spMpPanel.setBorder(BorderFactory.createTitledBorder("Tip"));
        spMpPanel.add(availableSpMpJComboBox);
        platformPanel.setBorder(BorderFactory.createTitledBorder("Platforma"));
        platformPanel.add(availablePlatformJComboBox);
        genrePanel.setBorder(BorderFactory.createTitledBorder("Gen"));
        genrePanel.add(availableGenreJComboBox);
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
        conclusionButton.addActionListener(e -> getConclusion());
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
        UserChoices userChoices = biMapConvertor.guiToKnowledgeBaseFormat(
                availableSpMpJComboBox.getSelectedItem().toString(),
                availablePlatformJComboBox.getSelectedItem().toString(),
                availableGenreJComboBox.getSelectedItem().toString(),
                availableContentRatingJComboBox.getSelectedItem().toString());

        ForwardChaining forwardChaining = new ForwardChaining(userChoices , xmlParser.getRulesArrayList());
        forwardChaining.doInference();
        conclusionLabel.setText(forwardChaining.getResultedRecommendations());

        conclusionPanel.add(conclusionLabel);
        conclusionPanel.setBorder(BorderFactory.createTitledBorder("Recommended games"));
        generalPanel.add(conclusionPanel);
        frame.pack();
    }
}
