package main.java.Utils;

import main.java.DataStructures.AvailableOptions;
import main.java.DataStructures.Rule;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XMLParser {

    private static final String FILENAME = "src/main/resources/knowledge_base.xml";

    private NodeList gamesKnowledgeBaseNodeList;
    private NodeList initialPremisesNodeList;
    private NodeList rulesNodeList;
    private NodeList spMpNodeList;
    private NodeList platformNodeList;
    private NodeList genreNodeList;
    private NodeList contentRatingNodeList;

    public void doGeneralSetup() {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(FILENAME));
            doc.getDocumentElement().normalize();

            gamesKnowledgeBaseNodeList = doc.getElementsByTagName("games_knowledge_base");

            for(int i = 0; i < gamesKnowledgeBaseNodeList.getLength(); i++) {
                initialPremisesNodeList = ((Element) gamesKnowledgeBaseNodeList.item(i)).getElementsByTagName("initial_premises");
                rulesNodeList = ((Element) gamesKnowledgeBaseNodeList.item(i)).getElementsByTagName("rules");
            }

        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public AvailableOptions getAvailableOptions(){
        AvailableOptions availableOptions;
        for(int i = 0; i < initialPremisesNodeList.getLength(); i++) {
            spMpNodeList = ((Element) gamesKnowledgeBaseNodeList.item(i)).getElementsByTagName("sp-mp");
            platformNodeList = ((Element) gamesKnowledgeBaseNodeList.item(i)).getElementsByTagName("platform");
            genreNodeList = ((Element) gamesKnowledgeBaseNodeList.item(i)).getElementsByTagName("genre");
            contentRatingNodeList = ((Element) gamesKnowledgeBaseNodeList.item(i)).getElementsByTagName("content_rating");
        }
        String[] availableSpMpOptions = spMpNodeList.item(0).getTextContent().replaceAll(" ", "").replaceAll("\n", "").split(",");
        String[] availablePlatformOptions = platformNodeList.item(0).getTextContent().replaceAll(" ", "").replaceAll("\n", "").split(",");
        String[] availableGenreOptions = genreNodeList.item(0).getTextContent().replaceAll(" ", "").replaceAll("\n", "").split(",");
        String[] availableContentRatingOptions = contentRatingNodeList.item(0).getTextContent().replaceAll(" ", "").replaceAll("\n", "").split(",");

        availableOptions = new AvailableOptions(availableSpMpOptions, availablePlatformOptions, availableGenreOptions, availableContentRatingOptions);

        return availableOptions;
    }
    public ArrayList<Rule> getRulesArrayList(){
        String[] ruleStringArray = rulesNodeList.item(0).getTextContent().replaceAll(" ", "").replaceAll("\n", "").split(",");
        ArrayList<Rule> rulesArrayList = new ArrayList<>();
        for(int i = 0; i < ruleStringArray.length; i = i + 5){
            rulesArrayList.add(new Rule(ruleStringArray[i], ruleStringArray[i + 1], ruleStringArray[i + 2], ruleStringArray[i + 3], ruleStringArray[i + 4]));
        }
        return rulesArrayList;
    }
}
