package main.java;

import main.java.DataStructers.AvailableOptions;
import main.java.DataStructers.Rule;
import main.java.Utils.XMLParser;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Temporary parser use case
        XMLParser xmlParser = new XMLParser();
        xmlParser.doGeneralSetup();
        ArrayList<AvailableOptions> availableOptionsArrayList;
        ArrayList<Rule> rulesArrayList = xmlParser.getRulesArrayList();
        for(int i = 0; i < rulesArrayList.size(); i++){
            System.out.println(rulesArrayList.get(i).toString() + "\n");
        }
    }
}
