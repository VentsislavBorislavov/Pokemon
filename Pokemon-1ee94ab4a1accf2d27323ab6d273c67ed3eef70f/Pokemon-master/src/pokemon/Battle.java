package pokemon;

import java.util.Scanner;

public class Battle {
    private Player player = new Player("Player 1");
    private Enemy enemy = new Enemy("Enemy 1");
    private int round = 1;
    private TypeDamageModifier damageModifier = new TypeDamageModifier();
    private boolean win = false;
    private boolean loose = false;
    Scanner input = new Scanner(System.in);


    public Battle() {
        printBattlingPokemons();
    }

    public void printBattlingPokemons() {
        System.out.println(this.player.getPokemons()[1]);
        System.out.println(this.enemy.getEnemyPokemon());
        Start();
    }

    public void Start() {
        do {
            if (round % 2 != 0) {
                enemyAttackRound();
            } else {
                playerAttackRound();
            }

        }


        while (/*!win || !loose||*/ round<10);


    }

    public void playerAttackRound() {

        System.out.println("Player Atacking");
        round++;
        System.out.println(round);
        int choice ;
        System.out.println("Enter your choice: ");
        System.out.println("1 - Use "+player.getPokemons()[0].getName()+"'s "+player.getPokemons()[0].getAbilityList().get(0).getAbilityName() );
        System.out.println("2 - Use "+player.getPokemons()[0].getName()+"'s "+player.getPokemons()[0].getAbilityList().get(1).getAbilityName() );

        choice=input.nextInt()-1;
        System.out.println(player.getPlayerName() + "'s " +player.getPokemons()[0].getName() + " attacks " + enemy.getEnemyName() + "'s " +enemy.getEnemyPokemon().getName()+ " using " + player.getPokemons()[0].getAbilityList().get(choice).getAbilityName() + " dealing " + dealDamage(player.getPokemons()[0], choice,enemy.getEnemyPokemon() ) + " damage, leaving " + enemy.getEnemyName() + "'s " + enemy.getEnemyPokemon().getName() + " with " + enemy.getEnemyPokemon().health + " health.");

    }

    ;


    public void enemyAttackRound() {
        int randomEnemyAttack = getRandomEnemyAttack();

        System.out.println(enemy.getEnemyName() + "'s " + enemy.getEnemyPokemon().getName() + " attacks " + player.getPlayerName() + "'s " + player.getPokemons()[0].getName() + " using " + enemy.getEnemyPokemon().getAbilityList().get(randomEnemyAttack).getAbilityName() + " dealing " + dealDamage(enemy.getEnemyPokemon(), randomEnemyAttack, player.getPokemons()[0]) + " damage, leaving " + player.getPlayerName() + "'s " + player.getPokemons()[0].getName() + " with " + player.getPokemons()[0].health + " health.");
        System.out.println();
        round++;
        System.out.println(round);


    }


    public int getRandomEnemyAttack() {
        int whitchAttackToUse;

        if (1 + Math.random() * 2 < 2) {
            whitchAttackToUse = 0;
        } else {
            whitchAttackToUse = 1;
        }
        return whitchAttackToUse;

    }

    public double dealDamage(Pokemon attackingPokemon, int attackType, Pokemon defendingPokemon) {
        double damage = (attackingPokemon.abilityList.get(attackType).damage + (attackingPokemon.attack - defendingPokemon.defence)) * damageModifier.getDamageModifier(attackingPokemon.getType(), defendingPokemon.getType());
        System.out.println("Damage that the attack will deal = " + damage);
        defendingPokemon.health -= damage;
        System.out.println(defendingPokemon.getName()+"s health is "+defendingPokemon.health);
        //return defendingPokemon;
        return damage;
    }

}
