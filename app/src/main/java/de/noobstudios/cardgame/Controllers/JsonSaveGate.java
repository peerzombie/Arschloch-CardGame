package de.noobstudios.cardgame.Controllers;


import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import de.noobstudios.cardgame.Controllers.Types.SaveType;

public class JsonSaveGate {
    public List getSave(InputStream in, SaveType stype) throws IOException{
        JsonReader r = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readSaveArray(r, stype);
        }
        finally {
            r.close();
        }
    }

    private List readSaveArray(JsonReader r, SaveType stype) throws IOException {
        List save = new ArrayList();

        if (stype == SaveType.SavePlayer) {
            r.beginArray();
            while (r.hasNext()) {
                save.add(readPlayerSave(r));
            }
            r.endArray();
        }
        else if (stype == SaveType.SaveGame) {
            r.beginArray();
            while (r.hasNext()) {
                save.add(readGameSave(r));
            }
            r.endArray();
        }
        return save;
    }

    private Save readGameSave(JsonReader r) {



        return null;
    }

    private Player readPlayerSave(JsonReader r) {
        String guid = "";
        String name = "";


        return new Player(name, guid);
    }
}
/*
[
   {
     "id": 912345678901,
     "text": "How do I read JSON on Android?",
     "geo": null,
     "user": {
       "name": "android_newb",
       "followers_count": 41

   },
   {
     "id": 912345678902,
     "text": "@android_newb just use android.util.JsonReader!",
     "geo": [50.454722, -104.606667],
     "user": {
       "name": "jesse",
       "followers_count": 2
     }
   }
 ]}
##################################################################################
   public List readJsonStream(InputStream in) throws IOException {
     JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
     try {
       return readMessagesArray(reader);
      finally {
       reader.close();
     }
   }

   public List readMessagesArray(JsonReader reader) throws IOException {
     List messages = new ArrayList();

     reader.beginArray();
     while (reader.hasNext()) {
       messages.add(readMessage(reader));
     }
     reader.endArray();
     return messages;
   }

   public Message readMessage(JsonReader reader) throws IOException {
     long id = -1;
     String text = null;
     User user = null;
     List geo = null;

     reader.beginObject();
     while (reader.hasNext()) {
       String name = reader.nextName();
       if (name.equals("id")) {
         id = reader.nextLong();
       } else if (name.equals("text")) {
         text = reader.nextString();
       } else if (name.equals("geo") && reader.peek() != JsonToken.NULL) {
         geo = readDoublesArray(reader);
       } else if (name.equals("user")) {
         user = readUser(reader);
       } else {
         reader.skipValue();
       }
     }
     reader.endObject();
     return new Message(id, text, user, geo);
   }

   public List readDoublesArray(JsonReader reader) throws IOException {
     List doubles = new ArrayList();

     reader.beginArray();
     while (reader.hasNext()) {
       doubles.add(reader.nextDouble());
     }
     reader.endArray();
     return doubles;
   }

   public User readUser(JsonReader reader) throws IOException {
     String username = null;
     int followersCount = -1;

     reader.beginObject();
     while (reader.hasNext()) {
       String name = reader.nextName();
       if (name.equals("name")) {
         username = reader.nextString();
       } else if (name.equals("followers_count")) {
         followersCount = reader.nextInt();
       } else {
         reader.skipValue();
       }
     }
     reader.endObject();
     return new User(username, followersCount);
   }}
 */