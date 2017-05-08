package com.example.me.firstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PokemonDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "POKEDEX";
    private static final int DB_VERSION = 1;

    PokemonDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        context.deleteDatabase(DB_NAME);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String addPokemonTable = "CREATE TABLE POKEMON ("
                + "_id INTEGER PRIMARY KEY,"
                + "name TEXT,"
                + "type TEXT,"
                + "imgId INTEGER,"
                + "display TEXT)";
        db.execSQL(addPokemonTable);
        insertPokemon(db, 0, "surge", "human", R.drawable.pokemon000);
        insertPokemon(db, 1, "bulbasaur", "grass", R.drawable.pokemon001);
        insertPokemon(db, 4, "charmander", "fire", R.drawable.pokemon004);
        insertPokemon(db, 7, "squirtle", "water", R.drawable.pokemon007);
        insertPokemon(db, 25, "pikachu", "electric", R.drawable.pokemon025);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    private static void insertPokemon(SQLiteDatabase db, int id, String name, String type, int imgId) {
        ContentValues pokemon = new ContentValues();
        pokemon.put("_id", id);
        pokemon.put("name", name);
        pokemon.put("type", type);
        pokemon.put("imgId", imgId);
        pokemon.put("display", Helpers.leadingZeroes(id) + " " + Helpers.capitalize(name) + " of type " + type);
        db.insert("POKEMON", null, pokemon);
    }

}
