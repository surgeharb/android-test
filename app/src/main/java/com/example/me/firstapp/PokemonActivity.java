package com.example.me.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PokemonActivity extends AppCompatActivity {

    public static final String EXTRA_POKENO = "pokeNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        int pokeNo = (int) getIntent().getExtras().get(PokemonActivity.EXTRA_POKENO);
        Pokemon pokemon = Pokemon.pokemons[pokeNo];

        ImageView img = (ImageView) findViewById(R.id.pokeImg);
        img.setImageResource(pokemon.getImageId());
        img.setContentDescription(pokemon.getName());
        img.getLayoutParams().height = 250;
        img.requestLayout();

        TextView name = (TextView) findViewById(R.id.pokename);
        name.setText(pokemon.getId() + " " + pokemon.getName());

        TextView type = (TextView) findViewById(R.id.poketype);
        type.setText(pokemon.getType());
    }
}
