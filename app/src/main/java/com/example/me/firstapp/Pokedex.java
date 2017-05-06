package com.example.me.firstapp;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Pokedex extends ListActivity {

    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView pokedex = getListView();
        SQLiteOpenHelper pokemonDatabaseHelper = new PokemonDatabaseHelper(this);
        db = pokemonDatabaseHelper.getReadableDatabase();
        cursor = db.query("POKEMON", new String[] {"_id", "name", "type", "display"}, null, null, null, null, null);
        SimpleCursorAdapter pokemonAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, new String[]{"display"}, new int[]{android.R.id.text1}, 0);
        pokedex.setAdapter(pokemonAdapter);
    }

    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id) {
        Intent intent = new Intent(Pokedex.this, PokemonActivity.class);
        intent.putExtra(PokemonActivity.EXTRA_POKENO, (int) id);
        startActivity(intent);
    }

    public void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }
}
