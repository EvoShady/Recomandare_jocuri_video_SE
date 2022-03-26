package main.java;

import main.java.DataStructures.Rule;
import main.java.DataStructures.UserChoices;

import java.util.ArrayList;

public class ForwardChaining {
        private ArrayList<Rule> ruleList;
        private UserChoices userChoices;

        public ForwardChaining(UserChoices userChoices, ArrayList<Rule> ruleList)
        {
                this.userChoices = userChoices;
                this.ruleList = ruleList;
        }

        public void Interference() {

                for (int i = 0; i < ruleList.size(); i++) {
                        if (!ruleList.get(i).getCondition1().equals(userChoices.getSpMpChoice())) {
                                ruleList.remove(i);
                                i--;
                                continue;
                        }
                        if (!ruleList.get(i).getCondition2().equals(userChoices.getPlatformChoice())) {
                                ruleList.remove(i);
                                i--;
                                continue;
                        }
                        if (!ruleList.get(i).getCondition3().equals(userChoices.getGenreChoice())) {
                                ruleList.remove(i);
                                i--;
                                continue;
                        }
                        if (!ruleList.get(i).getCondition4().equals(userChoices.getContentRatingChoice())) {
                                ruleList.remove(i);
                                i--;
                                continue;
                        }
                }
        }

        public String getResultedRecommendations(){
                String temp = "";
                for(int i = 0; i < ruleList.size(); i++){
                        temp += ruleList.get(i).getConclusion() + " ";
                }
                if(temp.equals("")) {
                        return "No games found";
                }
                else {
                        return temp;
                }
        }
}
