package com.example.me.firstapp;

public class Pokemon {
    private int id;
    private String name;
    private String type;
    private int imgId;

    //pokemons in an array
    public static  final Pokemon[] pokemons = {
            new Pokemon(1, "bulbasaur", "grass", R.drawable.pokemon001),
            new Pokemon(4, "charmander", "fire", R.drawable.pokemon004),
            new Pokemon(7, "squirtle", "water", R.drawable.pokemon007),
            new Pokemon(25, "pikachu", "electric", R.drawable.pokemon025)
    };

    private Pokemon(int id, String name, String type, int imgId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.imgId = imgId;
    }

    public String getId() {
        return Helpers.leadingZeroes(this.id);
    }

    public String getName() {
        return Helpers.capitalize(this.name);
    }

    public String getType() {
        return Helpers.capitalize(this.type);
    }

    public int getImageId() {
        return this.imgId;
    }

    public String toString() {
        return Helpers.leadingZeroes(this.id) + Helpers.capitalize(this.name) + " of type " + this.type;
    }

}
