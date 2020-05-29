//package pokemon;
//
//import java.util.Scanner;
//
//public class Battle {
////    private Player player = new Player("Player 1");
//    private Enemy enemy = new Enemy("Enemy 1");
//    private int round = 1;
//    private TypeDamageModifier damageModifier = new TypeDamageModifier();
//    private boolean win = false;
//    private boolean loose = false;
//    private int playerCurrentlyActivePokemon=0;
//    Scanner input = new Scanner(System.in);
//
//
//    public Battle() {
//        printBattlingPokemons();
//    }
//
//    public void printBattlingPokemons() {
////        System.out.println(this.player.getPokemons()[playerCurrentlyActivePokemon]);
//        System.out.println(this.enemy.getEnemyPokemon());
//        Start();
//    }
//
//    public void Start() {
//        do {
//            if (round % 2 != 0) {
////                enemyAttackRound();
//            } else {
//                playerAttackRound();
//            }
//
//        }
//
//
//        while (/*!win || !loose||*/ round<10);
//
//
//    }
//
//    public void playerAttackRound() {
//
//        System.out.println("Player Atacking");
//        round++;
//        System.out.println(round);
//        int choice ;
//        System.out.println("Enter your choice: ");
////        System.out.println("1 - Use "+player.getPokemons()[playerCurrentlyActivePokemon].getName()+"'s "+player.getPokemons()[playerCurrentlyActivePokemon].getAbilityList().get(0).getAbilityName() );
////        System.out.println("2 - Use "+player.getPokemons()[playerCurrentlyActivePokemon].getName()+"'s "+player.getPokemons()[playerCurrentlyActivePokemon].getAbilityList().get(1).getAbilityName() );
//        System.out.println("3 - Swap Pokemons.");
//        choice=input.nextInt()-1;
//
//        if(choice==2){
////            changePokemon();
//        }else {
////        System.out.println(player.getPlayerName() + "'s " +player.getPokemons()[playerCurrentlyActivePokemon].getName() + " attacks " + enemy.getEnemyName() + "'s " +enemy.getEnemyPokemon().getName()+ " using " + player.getPokemons()[playerCurrentlyActivePokemon].getAbilityList().get(choice).getAbilityName() + " dealing " + dealDamage(player.getPokemons()[playerCurrentlyActivePokemon], choice,enemy.getEnemyPokemon() ) + " damage, leaving " + enemy.getEnemyName() + "'s " + enemy.getEnemyPokemon().getName() + " with " + enemy.getEnemyPokemon().health + " health.");}
//
//    }
//
//    ;
////    public void changePokemon(){
////        int avaiableOptions=1;
////        int pickedPokemonIndex;
////        for (int i = 0; i <player.getPokemons().length; i++) {
////            if(i != playerCurrentlyActivePokemon /*&& player.getPokemons()[i].getHealth()>0*/){
////                System.out.println(avaiableOptions+"- Swap with "+player.getPokemons()[i].getName());
////                avaiableOptions++;
////            }
////        }
////        pickedPokemonIndex=input.nextInt();
////        System.out.println("Swapped "+player.getPokemons()[playerCurrentlyActivePokemon].getName()+" with "+player.getPokemons()[pickedPokemonIndex].getName());
////        playerCurrentlyActivePokemon=pickedPokemonIndex;
//
////    }
//
////    public void enemyAttackRound() {
////        int randomEnemyAttack = getRandomEnemyAttack();
//
////        System.out.println(enemy.getEnemyName() + "'s " + enemy.getEnemyPokemon().getName() + " attacks " + player.getPlayerName() + "'s " + player.getPokemons()[playerCurrentlyActivePokemon].getName() + " using " + enemy.getEnemyPokemon().getAbilityList().get(randomEnemyAttack).getAbilityName() + " dealing " + dealDamage(enemy.getEnemyPokemon(), randomEnemyAttack, player.getPokemons()[playerCurrentlyActivePokemon]) + " damage, leaving " + player.getPlayerName() + "'s " + player.getPokemons()[playerCurrentlyActivePokemon].getName() + " with " + player.getPokemons()[playerCurrentlyActivePokemon].health + " health.");
////        System.out.println();
////        round++;
////        System.out.println(round);
//
//
////    }
//
//
////    public int getRandomEnemyAttack() {
////        int whitchAttackToUse;
//
////        if (1 + Math.random() * 2 < 2) {
////            whitchAttackToUse = 0;
////        } else {
////            whitchAttackToUse = 1;
////        }
////        return whitchAttackToUse;
//
////    }
//
////    public double dealDamage(Pokemon attackingPokemon, int attackType, Pokemon defendingPokemon) {
////        double damage = (attackingPokemon.abilityList.get(attackType).damage + (attackingPokemon.attack - defendingPokemon.defence)) * damageModifier.getDamageModifier(attackingPokemon.getType(), defendingPokemon.getType());
////        System.out.println("Damage that the attack will deal = " + damage);
////        defendingPokemon.health -= damage;
////        System.out.println(defendingPokemon.getName()+"s health is "+defendingPokemon.health);
////        //return defendingPokemon;
////        return damage;
////    }
//
//}}
