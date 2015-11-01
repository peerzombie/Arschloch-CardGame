package de.noobstudios.cardgame.Controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.noobstudios.cardgame.Controllers.Types.GameState;

public class Game {
    public GameState cState;
    public Player[] players;
    public List<Card> cardsInStaple = new ArrayList<Card>();
    public List<Card> cardsInHand = new ArrayList<Card>();
    public List<Card> cardsOnTable = new ArrayList<Card>();

    public Game() {
        cState = GameState.Debug;
    }

    public Save toSave() {
        Save nSave = new Save();

        nSave.savedAt = String.valueOf(new Date().toString());
        nSave.cardsOnTable = cardsOnTable.toArray(new Card[cardsOnTable.size()]);
        nSave.cardsInHand = cardsInHand.toArray(new Card[cardsInHand.size()]);
        nSave.cardsInStaple = cardsInStaple.toArray(new Card[cardsInStaple.size()]);
        nSave.players = players;
        return nSave;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
