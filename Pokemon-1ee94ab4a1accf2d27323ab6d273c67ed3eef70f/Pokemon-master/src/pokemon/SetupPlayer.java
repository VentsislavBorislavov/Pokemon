package pokemon;

import java.util.Scanner;

public class SetupPlayer {
    Player player = new Player();
    PokemonsList pokemonsList = new PokemonsList();
    Scanner input = new Scanner(System.in);
    Pokemon[] pickedPokemons = new Pokemon[3];

    public SetupPlayer() {
        initPlayerName();
        initPlayerPokemons();
        getPlayerData();
    }

    public void getPlayerData() {
        System.out.println("Name - " + player.getPlayerName());
        System.out.println("Pokemon 1 - " + player.getPokemons()[0].getName());
        System.out.println("Pokemon 2 - " + player.getPokemons()[1].getName());
        System.out.println("Pokemon 3 - " + player.getPokemons()[2].getName());

    }

    public void initPlayerName() {
        String playerName;
        System.out.println("Enter your name");
        System.out.println();
        playerName = input.nextLine();
        player.setPlayerName(playerName);
    }

    public void initPlayerPokemons() {
        int pokemonsLeftToPick = 3;
        int choice;
        for (int i = 0; i < 3; i++) {
            System.out.println("Pick your Pokemons (" + pokemonsLeftToPick + " left):");
            System.out.println("1 - " + pokemonsList.bulbasaur.getName());
            System.out.println("2 - " + pokemonsList.squirtle.getName());
            System.out.println("3 - " + pokemonsList.pikachu.getName());
            System.out.println("4 - " + pokemonsList.diglett.getName());
            System.out.println("5 - " + pokemonsList.charmander.getName());
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    pickedPokemons[i] = pokemonsList.bulbasaur;
                    break;
                case 2:
                    pickedPokemons[i] = pokemonsList.squirtle;
                    break;
                case 3:
                    pickedPokemons[i] = pokemonsList.pikachu;
                    break;
                case 4:
                    pickedPokemons[i] = pokemonsList.diglett;
                    break;
                case 5:
                    pickedPokemons[i] = pokemonsList.charmander;
                    break;
                default:
                    System.out.println("Wrong Choice");
                    break;
            }
            pokemonsList = new PokemonsList();// if we want duplicate pokemons
            pokemonsLeftToPick--;
        }
        player.setPokemons(pickedPokemons);


    }
}
