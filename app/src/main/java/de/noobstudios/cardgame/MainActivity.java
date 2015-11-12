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

package de.noobstudios.cardgame;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import de.noobstudios.cardgame.Controllers.game.Game;
import de.noobstudios.cardgame.Controllers.player.Player;
import de.noobstudios.cardgame.Controllers.player.PlayerInfoRequest;
import de.noobstudios.cardgame.Controllers.player.PlayerSaveData;
import de.noobstudios.cardgame.Controllers.save.SaveGameHandler;
import de.noobstudios.cardgame.Controllers.Types.CardTypes;
import de.noobstudios.cardgame.Controllers.Types.GameState;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter_console;
    ArrayAdapter<String> adapter_cards;
    ArrayAdapter<String> adapter_selectedCards;

    boolean clickTrue = false;
    Game g = new Game();
    boolean firstRun = true;
    String appFilesDir = "";
    File savepath;
    final String[] lang = new String[]{"English", "Deutsch"};
    public PlayerInfoRequest tmpUserRequest = new PlayerInfoRequest();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Currently not implemented (Will be the End Zug button)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //CM CODE BEGINS HERE
        appFilesDir = getFilesDir().getAbsolutePath();
        savepath = new File(appFilesDir + "\\sv.json");
        if (!PlayerSaveData.chkFirstRun(getSharedPreferences("player", 0))) {

        }
        else {
            getUsername();
        }
        //FIRSTRUN END
        adapter_console = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        adapter_cards = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        adapter_selectedCards = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        ListView lv1 = (ListView) findViewById(R.id.game_console);
        lv1.setAdapter(adapter_console);
        ListView lv2 = (ListView) findViewById(R.id.game_chooseCards);
        lv2.setAdapter(adapter_cards);
        ListView lv3 = (ListView) findViewById(R.id.game_selectedCards);
        lv3.setAdapter(adapter_selectedCards);
        TextView v;
        if (g.cState == GameState.Debug) {
            for (int i = 0; i < 10; ++i) {
                adapter_console.add("CON=" + i);
                adapter_cards.add("FNP=" + i);
                adapter_selectedCards.add("SEL=" + i);
            }
        }
        adapter_console.add("" + CardTypes.valueOf("PikSchwarz2"));
        //TODO Add UI
        //TODO Add Logic
        //TODO Add P2P
        //TODO Add Networking
        for (Account acc : getGACC()) {
            adapter_console.add( "TYPE=" + acc.type + " | NAME=" + acc.name + " | STR=" + acc.toString());
            adapter_console.add("SHAHASHOFUSERMAIL" + )
        }

    }
    public String getStrHash(String arg0) {
        try {
            MessageDigest dg = MessageDigest.getInstance("SHA-512");
            dg.update(arg0.getBytes());
            return new String(dg.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }
    public Account[] getGACC() {
        AccountManager manager = (AccountManager) getSystemService(ACCOUNT_SERVICE);
        Account[] list = manager.getAccountsByType("com.google");
        if (list.length > 0) {
            return list;
        }
        else return new Account[0];
    }


    private void FIRSTRUN(String UName) {
        Player p = new Player();
        //PlayerInfoRequest nfo = getUsername("GET USERNAME");
        p._guid = p.getUUID().toString();
        p._name = tmpUserRequest.playerName;


    }


    public void getUsername() {
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.prompt, (LinearLayout) findViewById(R.id.layout_root));
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);
        final EditText userInput = (EditText) promptsView
                .findViewById(R.id.editTextDialogUserInput);
        final Spinner cLanguage = (Spinner) promptsView.findViewById(R.id.prompt_langSpinn);
        ArrayAdapter<String> adaptLang = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        cLanguage.setAdapter(adaptLang);
        adaptLang.addAll(lang);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton(R.string.button_confirm,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // get user input and set it to result
                                // edit text
                                applyDataFromFIRSTRUN(userInput.getText().toString(), cLanguage.getSelectedItemPosition(), cLanguage.getSelectedItemId());
                            }
                        })
                .setNegativeButton(R.string.button_cancle,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }

    private void applyDataFromFIRSTRUN(String s, int selectedItemPosition, long selectedItemId) {
        tmpUserRequest = new PlayerInfoRequest(s, selectedItemPosition);
        adapter_console.add(lang[tmpUserRequest.languageIndexCode]);
        adapter_console.add(tmpUserRequest.playerName);
        PlayerSaveData save = new PlayerSaveData(getSharedPreferences("player", 0));
        if (save.readSave()._guid != null) save.writeSave(tmpUserRequest.playerName, Player.getUUID().toString(), 0);
        adapter_console.add(save.readSave()._guid);
        PlayerSaveData.wrtFirstRun(getSharedPreferences("player", 0), false);
    }


    //MENUE STUFF
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent ni = new Intent(this, SettingsActivity.class);
            startActivity(ni);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}