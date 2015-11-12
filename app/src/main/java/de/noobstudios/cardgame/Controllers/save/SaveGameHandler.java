/*
 * Copyright (C) 2015 Peer Bölts
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package de.noobstudios.cardgame.Controllers.save;

import java.io.FileOutputStream;

import de.noobstudios.cardgame.Controllers.player.Player;
import de.noobstudios.cardgame.Controllers.game.Card;

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
