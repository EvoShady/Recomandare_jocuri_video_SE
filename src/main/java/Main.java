package main.java;

import main.java.DataStructures.AvailableOptions;
import main.java.DataStructures.Rule;
import main.java.Utils.XMLParser;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Temporary parser use case
        XMLParser xmlParser = new XMLParser();
        xmlParser.doGeneralSetup();
        ArrayList<AvailableOptions> availableOptionsArrayList;
        AvailableOptions availableOptions = xmlParser.getAvailableOptions();
        System.out.println(availableOptions.toString());
        ArrayList<Rule> rulesArrayList = xmlParser.getRulesArrayList();
        for(int i = 0; i < rulesArrayList.size(); i++){
            System.out.println(rulesArrayList.get(i).toString() + "\n");
        }
    }
}
