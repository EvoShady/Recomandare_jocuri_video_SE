import DataStructers.Rule;
import DataStructers.UserChoices;
import DataStructers.Games;

import java.util.ArrayList;

public class Forward_Chaining {
        private ArrayList<Games> gamesList;
        private ArrayList<Rule> ruleList;
        private ArrayList<UserChoices> userChoicesList;

        public ArrayList<Games> getGamesArrayList() {
                return gamesList;
        }

        public ArrayList<Rule> getRuleArrayList() {
                return ruleList;
        }

        public ArrayList<UserChoices> getUserChoicesArrayList() {
                return userChoicesList;
        }

        public Forward_Chaining (ArrayList<UserChoices> userChoicesArrayList)
        {
                this.userChoicesList = userChoicesArrayList;
        }

        public void Interference() {
                boolean skip1 = false, skip2 = false, skip3 = false, skip4 = false;

                for (int i = 0; i < ruleList.size(); i++) {
                        int conditionCount = 0;
                        for (int j = 0; j < userChoicesList.size(); j++) {
                                if (ruleList.get(i).getCondition1().equals(userChoicesList.get(j).toString()) && !skip1)
                                {
                                        System.out.println("Condition met");
                                        skip1 = true;
                                        conditionCount++;
                                        continue;
                                }
                                if (ruleList.get(i).getCondition2().equals(userChoicesList.get(j).toString()) && !skip2)
                                {
                                        System.out.println("Condition met");
                                        skip2 = true;
                                        conditionCount++;
                                        continue;
                                }
                                if (ruleList.get(i).getCondition3().equals(userChoicesList.get(j).toString()) && !skip3)
                                {
                                        System.out.println("Condition met");
                                        skip3 = true;
                                        conditionCount++;
                                        continue;
                                }
                                if (ruleList.get(i).getCondition4().equals(userChoicesList.get(j).toString()) && !skip4)
                                {
                                        System.out.println("Condition met");
                                        skip4 = true;
                                        conditionCount++;
                                }
                        }
                }
        }
}
