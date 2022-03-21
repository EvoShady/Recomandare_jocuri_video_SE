package main.java.Utils;

import com.google.common.collect.ImmutableBiMap;
import main.java.DataStructures.AvailableOptions;
import main.java.DataStructures.UserChoices;

public class BiMapConvertor {

    private ImmutableBiMap<Object, Object> knowledgeBaseAndGuiBiMap;

    public void createBiMap(){
        knowledgeBaseAndGuiBiMap = new ImmutableBiMap.Builder<>()
                .put("Singleplayer", "Prefera sa se joace un joc singur/a")
                .put("Multiplayer", "Prefera sa se joace online cu alte persoane")
                .put("PC", "Personal Computer")
                .put("Playstation", "Playstation")
                .put("XBox", "XBox")
                .put("Nintendo", "Nintendo")
                .put("Mobile", "Mobile")
                .put("VR", "Virtual Reality")
                .put("Action", "ActionTODO")
                .put("Adventure", "AdventureTODO")
                .put("Puzzle", "PuzzleTODO")
                .put("Role-playing", "Role-playingTODO")
                .put("Simulation", "SimulationTODO")
                .put("Strategy", "StrategyTODO")
                .put("Sport", "SportTODO")
                .put("Horror", "HorrorTODO")
                .put("BoardOrCard", "Board Or CardTODO")
                .put("Shooting", "ShootingTODO")
                .put("Sandbox", "SandboxTODO")
                .put("Educational", "EducationalTODO")
                .put("PEGI3+", "Peste 3 ani")
                .put("PEGI8+", "Peste 8 ani")
                .put("PEGI12+", "Peste 12 ani")
                .put("PEGI16+", "Peste 16 ani")
                .put("PEGI18+", "Peste 18 ani")
                .build();
    }

    public UserChoices guiToKnowledgeBaseFormat(String spMp, String platform, String genre, String contentRating){
        createBiMap();
        UserChoices userChoices = new UserChoices(
                (String) knowledgeBaseAndGuiBiMap.inverse().get(spMp),
                (String) knowledgeBaseAndGuiBiMap.inverse().get(platform),
                (String) knowledgeBaseAndGuiBiMap.inverse().get(genre),
                (String) knowledgeBaseAndGuiBiMap.inverse().get(contentRating)
        );
        return userChoices;
    }

    private String[] convertStringArrays(String[] strings){
        String[] tempStrings = new String[strings.length];
        for(int i = 0; i < strings.length; i++){
            tempStrings[i] = (String) knowledgeBaseAndGuiBiMap.get(strings[i]);
        }
        return tempStrings;
    }

    public AvailableOptions knowledgeBaseToGuiFormat(String[] smMp, String[] platform, String[] genre, String[] contentRating){
        createBiMap();
        String[] newSmMp = convertStringArrays(smMp),
                newPlatform = convertStringArrays(platform),
                newGenre = convertStringArrays(genre),
                newContentRating = convertStringArrays(contentRating);
        return new AvailableOptions(newSmMp, newPlatform, newGenre, newContentRating);
    }

}
