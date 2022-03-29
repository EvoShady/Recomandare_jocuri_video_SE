package main.java.Utils;

import com.google.common.collect.ImmutableBiMap;
import main.java.DataStructures.AvailableOptions;
import main.java.DataStructures.UserChoices;

public class BiMapConvertor {

    private ImmutableBiMap<Object, Object> knowledgeBaseAndGuiBiMap;

    private void createBiMap(){
        knowledgeBaseAndGuiBiMap = new ImmutableBiMap.Builder<>()
                .put("Singleplayer", "Prefera sa se joace un joc singur/a")
                .put("Multiplayer", "Prefera sa se joace online cu alte persoane")
                .put("PC", "Personal Computer")
                .put("Playstation", "Playstation")
                .put("XBox", "XBox")
                .put("Nintendo", "Nintendo")
                .put("Mobile", "Mobile")
                .put("VR", "Virtual Reality")
                .put("Roleplay","Un joc de rol in care jucătorul controlează acțiunile unui personaj")
                .put("Adventure","Jucatorul isi asuma rolul unui protagonist intr-o poveste interactivă condusa de explorare")
                .put("SandboxAdventure","Jucatorul este pus intr-o poveste ce necesita explorare si creativitate")
                .put("ActionAdventure","Jucatorul este pus intr-o poveste plina cu actiune si explorare")
                .put("ActionRoleplay","Jucatorul iti controleaza caracterul intr-o poveste de actiune")
                .put("Strategy","Joc in care abilitațile de luare a deciziilor au o mare importanta")
                .put("DigitalCollectibleCardGame","Joc de tip colectare de carti in format digital")
                .put("Platformer","Joc de tip sarit si fugit, de obicei pe platforme")
                .put("SurvivalHorror","Jucatorul trebuie sa supraviețuiasca in timp ce se lupta impotriva unor creaturi ce tin de supranatural")
                .put("FirstPersonShooter","Jucător tinteste si traieste acțiunea prin ochii protagonistului într-un spatiu tridimensional")
                .put("HackAndSlash","Jocul pune accentul pe lupta cu arme de apropiere")
                .put("MMORPG","Joc de rol in care interactiunea se poate face cu alti jucatori in mediul online")
                .put("Fighting","Joc care pune accentul pe bataie fara arme")
                .put("Shooter","Joc care pune accentul pe tintire si impuscaturi")
                .put("Sport","Jucatorul controleaza caracterul")
                .put("Racing","Jocul se bazeaza pe curse cu masini")
                .put("Puzzle","Jocul de tip puzzle")
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
