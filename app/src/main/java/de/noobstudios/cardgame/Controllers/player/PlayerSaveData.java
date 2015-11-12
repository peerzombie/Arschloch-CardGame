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


import android.content.SharedPreferences;

import java.io.InputStream;

public class PlayerSaveData {
    private SharedPreferences player;

    public PlayerSaveData(SharedPreferences player) {
        this.player = player;
    }
    public static boolean chkFirstRun(SharedPreferences player) {
        boolean p;
        p = player.getBoolean("<-1>", true);
        return p;
    }
    //READ
    public Player readSave() {
        Player p = new Player();
        p._guid = readGUID();
        p._name = readName();
        p._PlayerNumber = readPlayerNum();
        return p;
    }
    private String readGUID() {
        String guid;
        guid = player.getString("<0>", "DEF_GUID_00000000000000000");
        return guid;
    }
    private String readName() {
        String name;
        name = player.getString("<1>", "DEF_NAME_NONAME");
        return name;
    }
    private int readPlayerNum() {
        int num;
        num = player.getInt("<2>", 0);
        return num;
    }
    //WRITE
    public static void wrtFirstRun(SharedPreferences prefs, boolean state) {
        SharedPreferences.Editor e= prefs.edit();
        e.putBoolean("<-1>", state);
        e.apply();
    }

    public void writeSave(String name, String GUID) {
        this.writeSave(name, GUID, 0);
    }
    public void writeSave(String name, String GUID, int playerNum) {
        writeGUID(GUID);
        writeName(name);
        writePlayerNum(playerNum);

    }

    private void writePlayerNum(int playerNum) {
        SharedPreferences.Editor edit = player.edit();
        edit.putInt("<2>", playerNum);
        edit.apply();
    }

    private void writeName(String name) {
        SharedPreferences.Editor edit = player.edit();
        edit.putString("<1>", name);
        edit.apply();
    }

    private void writeGUID(String guid) {
        SharedPreferences.Editor edit = player.edit();
        edit.putString("<0>", guid);
        edit.apply();
    }
}
