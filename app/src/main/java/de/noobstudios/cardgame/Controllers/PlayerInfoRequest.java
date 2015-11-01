package de.noobstudios.cardgame.Controllers;

/**
 * Created by TheLazyAdmin on 28.10.2015.
 */
public class PlayerInfoRequest {
    public String playerName;
    public int languageIndexCode;
    public PlayerInfoRequest() {
        playerName = "noname";
        languageIndexCode = 0;
    };
    public PlayerInfoRequest(String pName, int index) {
        playerName = pName;
        languageIndexCode = index;
    }
}
