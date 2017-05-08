package com.example.me.firstapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PokemonActivity extends AppCompatActivity {

    public static final String EXTRA_POKENO = "pokeNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);

        int pokeNo = (int) getIntent().getExtras().get(PokemonActivity.EXTRA_POKENO);

        try {
            SQLiteOpenHelper pokemonDatabaseHelper = new PokemonDatabaseHelper(this);
            SQLiteDatabase db = pokemonDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("POKEMON", new String[] { "_id", "name", "type", "imgId" }, "_id = ?", new String[] {Integer.toString(pokeNo)}, null, null, null);
            if(cursor.moveToFirst()) {
                int _id = cursor.getInt(0);
                String nameText = cursor.getString(1);
                String typeText = cursor.getString(2);
                int imgId = cursor.getInt(3);

                ImageView img = (ImageView) findViewById(R.id.pokeImg);
                img.setImageResource(imgId);
                img.setContentDescription(nameText);
                img.getLayoutParams().height = 250;
                img.requestLayout();
                Log.e("img", Integer.toString(imgId));

                TextView name = (TextView) findViewById(R.id.pokename);
                name.setText(Helpers.leadingZeroes(_id) + " " + Helpers.capitalize(nameText));

                TextView type = (TextView) findViewById(R.id.poketype);
                type.setText("Type: " + Helpers.capitalize(typeText));
            }
            cursor.close();
            db.close();
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}
