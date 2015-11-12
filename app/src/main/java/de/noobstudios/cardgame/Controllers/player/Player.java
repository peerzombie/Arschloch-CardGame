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

package de.noobstudios.cardgame.Controllers.player;

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
    public static UUID getUUID() {
        return java.util.UUID.randomUUID();
    }
}
