package main.java.DataStructures;

public class Rule {
    private String condition1, condition2, condition3, condition4, conclusion;

    public Rule(String condition1, String condition2, String condition3, String condition4, String result) {
        this.condition1 = condition1;
        this.condition2 = condition2;
        this.condition3 = condition3;
        this.condition4 = condition4;
        this.conclusion = result;
    }

    public String getCondition1() {
        return condition1;
    }

    public String getCondition2() {
        return condition2;
    }

    public String getCondition3() {
        return condition3;
    }

    public String getCondition4() {
        return condition4;
    }

    public String getConclusion() {
        return conclusion;
    }

    public String toString(){
        return "Condition 1: " + condition1 + "\nCondition 2: " + condition2 + "\nCondition 3: " + condition3 + "\nCondition 4: " + condition4 + "\nResult: " + conclusion;
    }
}
