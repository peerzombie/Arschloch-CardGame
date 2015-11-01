package de.noobstudios.cardgame.Controllers;

import java.io.FileOutputStream;

public class SaveGameHandler {
    String savePath;
    public SaveGameHandler(String path) {
        savePath = path;
    }
    public boolean CheckSave() {
        return false;
    }
    public void WriteGameSave(Save save, FileOutputStream fos) {
        //TODO Create Writing Code

    }
    public void WriteGameSave(String savedAt, Card[] cardsOnTable, Card[] cardsInHand, Card[] cardsInStaple, Player[] playersInGame, FileOutputStream fos) {
        Save nSave = new Save();
        nSave.savedAt = savedAt;
        nSave.cardsOnTable = cardsOnTable;
        nSave.cardsInHand = cardsInHand;
        nSave.cardsInStaple = cardsInStaple;
        nSave.players = playersInGame;
        WriteGameSave(nSave, fos);
    }
    public Save LoadGameSave(String savedAt) {
        //TODO Create loading Code
        return new Save();
    }
    public void WritePlayerSave(Player p) {

    }
    public void WritePlayerSave(String playerName, String playerUUID) {
        Player p = new Player(playerName, playerUUID);
        WritePlayerSave(p);
    }
    public void LoadPlayerSave() {

    }
}
