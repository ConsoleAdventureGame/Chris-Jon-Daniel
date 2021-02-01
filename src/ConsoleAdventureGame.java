//import java.util.Scanner;
//
//public class ConsoleAdventureGame {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // Variables
//        String name = "Player";
//        Hero ourHero = new Hero();
//        goblin goblinOne = new goblin();
//
//        System.out.println("Would you lke to play?");
//
//        String toPlay = scanner.nextLine();
//
//        // Initialize Game
//        if (toPlay.equalsIgnoreCase("yes")) {
//            System.out.println("What is your name?");
//            name = scanner.nextLine();
//
//            ourHero.name = name;
//            System.out.println("Hello " + ourHero.name + "\nHealth is: " + ourHero.health);
//            turn();
//        } else {
//            System.out.println("Come back when you are ready.");
//        }
//    }
//
//    // User Choice
//    public static void turn() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Welcome to the dungeon! A goblin has appeared!");
//
//        // enemy
//        goblin goblinOne = new goblin();
//
//        // Choices for User
//        System.out.println("What do you do?");
//        System.out.println("1 Attack");
//        System.out.println("2 Defend");
//        System.out.println("3 Drink Potion");
//        System.out.println("4 Run Away");
//        int action = scanner.nextInt();
//
//        // Attack
//        if (action == 1) {
//            System.out.println("Attack!");
//        }
//
//        // Defend
//        else if (action == 2) {
//            System.out.println("Defend");
//
//        }
//
//        // Drink Potion
//        else if (action == 3) {
//            System.out.println("Drink up");
//        }
//
//        // Escape
//        else if (action == 4) {
//            System.out.println("You ran away....");
//        } else {
//            System.out.println("Chose a number!");
//            turn();
//        }
//
//        // Enemy Turn
//
//
//    }
//
//}

import java.util.Random;
import java.util.Scanner;

public class ConsoleAdventureGame {
    public static void main(String[] args) {
        // System objects //
        Scanner in = new Scanner(System.in);
        // Random number object generator
        Random rand = new Random();

        // Player Variables //
        Hero player = new Hero();
        System.out.println("What is your name?");
        player.name = in.nextLine();


        // Running Variable, game keeps running unless there is a condition for it to stop (while loop)
        boolean running = true;

        System.out.println("♞ Welcome to the Swamp " + player.name + "! ♞");
        // GAME is the label of the while loop
//        GAME:
        while (running) {
            System.out.println("----------------------");
            // Start Combat with Enemy, uses random generator, picks number from 1 to maxEnemyHealth variable, in

            int enemySelector = rand.nextInt(5);
            Enemy enemy = null;
            int enemyHealth = 0;

            if(enemySelector == 1){
                enemy = new Donkey();
                enemyHealth = rand.nextInt(enemy.maxEnemyHealth) + 10;
            } else if(enemySelector == 2) {
                    enemy = new Cat();
                enemyHealth = rand.nextInt(enemy.maxEnemyHealth) + 20;
            } else if (enemySelector == 3){
                enemy = new Farquad();
                enemyHealth = rand.nextInt(enemy.maxEnemyHealth) + 5;
            } else if (enemySelector == 4){
                enemy = new Godmother();
                enemyHealth = rand.nextInt(enemy.maxEnemyHealth) + 10;
            } else {
                enemy = new Dragon();
                enemyHealth = rand.nextInt(enemy.maxEnemyHealth) + 40;
            }

//            String enemy = enemies[enemySelector];


            // Random enemy generated


//            int enemySelector = rand.nextInt(enemies.length);
//            String enemy = enemies[enemySelector];
//            String enemyAttack = enemyAttacks[enemySelector];


            System.out.println("\t# " + enemy.name + " appeared! #\n");
            //  # Ghoul has appeared! #

            // Give player options while enemy is alive
            while (enemyHealth > 0) {
                System.out.println("\tYour HP: " + player.health);
                System.out.println("\t" + enemy.name + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1 Attack");
                System.out.println("\t2 Drink Health Potion");
                System.out.println("\t3 Run!");

                // Get users input
                String input = in.nextLine();
                if (input.equals("1")) {
                    // generate random damage between 1 & 50
                    int damageDealt = rand.nextInt(player.attackDamage);
                    //  generate random damage taken
                    int damageTaken = rand.nextInt(enemy.enemyAttackDamage);
                    // Take the damage off
                    enemyHealth -= damageDealt;

                    // Attack print
                    System.out.println("\t>1 You attack " + enemy.name + " for " + damageDealt + " damage.");

                    if (enemyHealth <= 0) {
                        System.out.println(" # " + enemy.name + " was defeated! #");

                        if (rand.nextInt(100) < player.healthPotionDropChance) {
                            if (player.numHealthPotions < 4) {
                                player.numHealthPotions++;
                                System.out.println(" # The " + enemy.name + " dropped a health potion. # ");
                                System.out.println(" # You have " + player.numHealthPotions + " health potion(s).");
                            } else {
                                System.out.println(" # The " + enemy.name + " dropped a health potion. # ");
                                System.out.println(" # Your pack is full! # ");
                            }
                            if (rand.nextInt(100) < player.levelUpChance) {
                                player.attackDamage = player.attackDamage + 5;
                                System.out.println(" # You leveled up. # ");
                                System.out.println(" # Your base attack is  " + player.attackDamage);
                            }
                        }
                        break;
                    }
                    player.health -= damageTaken;
                    System.out.println("\t>" + enemy.name + " " + enemy.specialAttack + " you! You take " + damageTaken + " damage" +
                            "!");

                    // Health Low Print
                    if (player.health < 1) {

                        System.out.println("\t> You have taken too much damage to continue!");
                        break;
                    }
                    // Drink Health Potion //
                } else if (input.equals("2")) {
                    // check for health potion
                    if (player.health == 100) {
                        System.out.println("Your health is Full!");

                        int damageTaken = rand.nextInt(enemy.enemyAttackDamage);

                        player.health -= damageTaken;
                        System.out.println("\t>" + enemy.name + " " + enemy.specialAttack + " you! You take " + damageTaken + " damage" +
                                "!");
                        if (player.health < 1) {

                            System.out.println("\t> You have taken too much damage to continue!");
                            break;
                        }
                    } else if (player.numHealthPotions > 0) {
                        // Add to your health
                        int actualHeal = player.healthPotionHealAmount;
                        if (player.health + player.healthPotionHealAmount > 100) {
                            actualHeal = 100 - player.health;
                            player.health = 100;

                        } else {
                            player.health += player.healthPotionHealAmount;
                        }
                        // Take one health potion away
                        player.numHealthPotions--;
                        System.out.println("\t> You drink a health potion, +" + actualHeal + "." + "\n\t>" +
                                " You now have " + player.health + " HP" + "\n\t> You have " + player.numHealthPotions + " Health " +
                                "potions left.\n");


//                        ENEMY ATTACK
                        int damageTaken = rand.nextInt(enemy.enemyAttackDamage);

                        player.health -= damageTaken;
                        System.out.println("\t>" + enemy.name + " " + enemy.specialAttack + " you! You take " + damageTaken + " damage" +
                                "!");
                        if (player.health < 1) {

                            System.out.println("\t> You have taken too much damage to continue!");
                            break;
                        }
                    } else {
                        // no health potions
                        System.out.println("\t> You have no health potions left, defeat enemies to try and recover " +
                                "one!");
                    }
                    // For running away //
                } else if (input.equals("3")) {
                    System.out.println("\t> You ran away from the " + enemy.name + "!");
                    break;
                } else {
                    // If user enters something else
                    System.out.println("\tInvalid command.");
                }
            }


            // Health gets too low //
            if (player.health < 1) {
                System.out.println();
                System.out.println("             ,-'     `._ \n" +
                        "                 ,'           `.        ,-. \n" +
                        "               ,'               \\       ),.\\ \n" +
                        "     ,.       /                  \\     /(  \\; \n" +
                        "    /'\\\\     ,o.        ,ooooo.   \\  ,'  `-') \n" +
                        "    )) )`. d8P\"Y8.    ,8P\"\"\"\"\"Y8.  `'  .--\"' \n" +
                        "   (`-'   `Y'  `Y8    dP       `'     / \n" +
                        "    `----.(   __ `    ,' ,---.       ( \n" +
                        "           ),--.`.   (  ;,---.        ) \n" +
                        "          / \\O_,' )   \\  \\O_,'        | \n" +
                        "         ;  `-- ,'       `---'        | \n" +
                        "         |    -'         `.           | \n" +
                        "        _;    ,            )          : \n" +
                        "     _.'|     `.:._   ,.::\" `..       | \n" +
                        "  --'   |   .'     \"\"\"         `      |`. \n" +
                        "        |  :;      :   :     _.       |`.`.-'--. \n" +
                        "        |  ' .     :   :__.,'|/       |  \\ \n" +
                        "        `     \\--.__.-'|_|_|-/        /   ) \n" +
                        "         \\     \\_   `--^\"__,'        ,    | \n" +
                        "   -hrr- ;  `    `--^---'          ,'     | \n" +
                        "          \\  `                    /      / \n" +
                        "           \\   `    _ _          / \n" +
                        "            \\           `       / \n" +
                        "             \\           '    ,' \n" +
                        "              `.       ,   _,' \n" +
                        "                `-.___.---' ");
                System.out.println("#########################");
                System.out.println(" # You have been slain # ");
                System.out.println("#########################");
                System.out.println(" # This is my swamp # ");
                System.out.println("#########################");
                break;
            }

            System.out.println("----------------------");

            System.out.println(" # You have " + player.health + " HP left. #");


            System.out.println("----------------------");
            // Next Adventure Options
            System.out.println("What would you like to do?");
            System.out.println("1. Continue fighting.");
            System.out.println("2. Leave the Swamp.");

            // Run loop based on user's input
            String input = in.nextLine();
            // If player input is not 1 or 2
            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid command!");
                input = in.nextLine();
            }
            // If player chooses 1 or 2
            if (input.equals("1")) {
                System.out.println("You continue further into the Swamp.....");
            } else if (input.equals("2")) {
                System.out.println("You left the Swamp....");
                break;
            }
        }
        // Leaving Game
        System.out.println("#########################");
        System.out.println(" # THANKS FOR PLAYING! # ");
        System.out.println("#########################");
    }

}