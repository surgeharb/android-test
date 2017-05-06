package com.example.me.firstapp;

import android.util.Log;

public class Pokemon {
    private int id;
    private String name;
    private String type;
    private int imgId;

    //pokemons in an array
    public static  final Pokemon[] pokemons = {
            new Pokemon(1, "bulbasaur", "grass", R.drawable.pokemon001bulbasaur),
            new Pokemon(4, "charmander", "fire", R.drawable.pokemon004charmander),
            new Pokemon(7, "squirtle", "water", R.drawable.pokemon007squirtle),
            new Pokemon(25, "pikachu", "electric", R.drawable.pokemon025pikachu)
    };

    private Pokemon(int id, String name, String type, int imgId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.imgId = imgId;
    }

    public String getId() {
        return leadingZeroes(this.id);
    }

    public String getName() {
        return capitalize(this.name);
    }

    public String getType() {
        return capitalize(this.type);
    }

    public int getImageId() {
        return this.imgId;
    }

    public String toString() {
        return leadingZeroes(this.id) + capitalize(this.name) + " of type " + this.type;
    }

    private String leadingZeroes(int number) {
        String temp = Integer.toString(number);
        if(temp.length() < 3) {
            int iterations = 3 - temp.length();
            for(int i = 0; i < iterations; i++) {
                temp = "0" + temp;
            }
        }
        return temp;
    }

    private String capitalize(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }
}
