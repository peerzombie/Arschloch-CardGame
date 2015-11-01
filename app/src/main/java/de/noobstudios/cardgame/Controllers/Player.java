package de.noobstudios.cardgame.Controllers;

import java.util.UUID;

public class Player {
    public String _name;
    public String _guid;
    public int _PlayerNumber;

    /**
     * @param playerName Name of Player
     * @param guid Random GUID ( get from Player.getUUID(); )
     */

    public Player() {
        this("noname", "noguid", 0);
    }
    public Player(String playerName, String guid) {
        this(playerName, guid, 0);
    }

    public Player(String playerName, String guid, int PlayerNumber) {
        _name = playerName;
        _guid = guid;
        _PlayerNumber = PlayerNumber;
    }
    public UUID getUUID() {
        return java.util.UUID.randomUUID();
    }
}
