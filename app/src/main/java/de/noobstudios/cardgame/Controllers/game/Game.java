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

package de.noobstudios.cardgame.Controllers.game;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.noobstudios.cardgame.Controllers.player.Player;
import de.noobstudios.cardgame.Controllers.save.Save;
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
