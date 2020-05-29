package pokemon;

import java.util.Scanner;
import java.util.SortedMap;

public class Game {
    EnemyList enemyList = new EnemyList();
    SetupPlayer setupPlayerlayer = new SetupPlayer();
    Battle battle;
    PokemonHospital pokemonHospital = new PokemonHospital(setupPlayerlayer.player);
    int currentEnemy = 0;
    Scanner input = new Scanner(System.in);
    boolean end=false;
    public Game() {

            newBattle();
            afterBattleMenu();




    }
    public void newBattle(){
        battle = new Battle(enemyList.enemies[currentEnemy],setupPlayerlayer.player);
        if(battle.isWin()){

            currentEnemy++;
            if (currentEnemy>=enemyList.enemies.length){
                endGame();
            }

        }
        if(battle.isLoose()){
            System.exit(0);
        }

    }
    public void endGame(){
        System.out.println("You won the game.");
        System.out.println("Congratulations.");
        System.exit(0);
    }
    public void afterBattleMenu(){
        int choice;
        System.out.println("XXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("Choose what to do next:");
        System.out.println("1 - Heal all pokemons (cost 2 crystals, currently you have "+setupPlayerlayer.player.getCrystals()+")");
        System.out.println("2 - Next Battle");
        choice = input.nextInt();
        if (choice==1){
            pokemonHospital.healAllPokemons();
        }
        if(choice==2){
            newBattle();
        }


    }


}
