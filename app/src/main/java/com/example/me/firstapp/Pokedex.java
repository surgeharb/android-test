package com.example.me.firstapp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Pokedex extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView pokedex = getListView();
        ArrayAdapter<Pokemon> pokemonAdapter = new ArrayAdapter<Pokemon>(this, android.R.layout.simple_list_item_1, Pokemon.pokemons);
        pokedex.setAdapter(pokemonAdapter);
    }

    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id) {
        Intent intent = new Intent(Pokedex.this, PokemonActivity.class);
        intent.putExtra(PokemonActivity.EXTRA_POKENO, (int) id);
        startActivity(intent);
    }
}
