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


        // Game Variables //
        // Enemies variable, string array
        String[] enemies = {"Bat", "Ghoul", "Goblin", "Necromancer"};
        // Enemy Health Variable
        int maxEnemyHealth = 75;
        // Enemy Attack Damage Variable
        int enemyAttackDamage = 25;


        // Player Variables //
        int health = 100;
        int attackDamage = 50;
        int numHealthPotions = 4;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50; // 50 Percent chance to drop a health potion

        // Running Variable, game keeps running unless there is a condition for it to stop (while loop)
        boolean running = true;

        System.out.println("Welcome to the Dark Forest!");
        // GAME is the label of the while loop
        GAME:
        while (running) {
            System.out.println("----------------------");
            // Start Combat with Enemy, uses random generator, picks number from 1 to maxEnemyHealth variable, in this case 75
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            // Random enemy generated
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " appeared! #\n");
            //  # Ghoul has appeared! #

            // Give player options while enemy is alive
            while (enemyHealth > 0) {
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1 Attack");
                System.out.println("\t2 Drink Health Potion");
                System.out.println("\t3 Run!");

                // Get users input
                String input = in.nextLine();
                if (input.equals("1")) {
                    // generate random damage between 1 & 50
                    int damageDealt = rand.nextInt(attackDamage);
                    //  generate random damage taken
                    int damageTaken = rand.nextInt(enemyAttackDamage);
                    // Take the damage off
                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    // Attack print
                    System.out.println("\t>1 You attack " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t> You receive " + damageTaken);

                    // Health Low Print
                    if (health < 1) {
                        System.out.println("\t> You have taken too much damage to continue!");
                        break;
                    } else if(enemyHealth <= 0){
                        System.out.println(" # " + enemy + " was defeated! #");
                        if(rand.nextInt(100) < healthPotionDropChance) {
                            numHealthPotions++;
                            System.out.println(" # The " + enemy + " dropped a health potion. # ");
                            System.out.println(" # You have " + numHealthPotions + " health potion(s).");
                        }
                        break;
                    }
                    // Drink Health Potion //
                } else if (input.equals("2")) {
                    // check for health potion
                    if (numHealthPotions > 0) {
                        // Add to your health
                        health += healthPotionHealAmount;
                        // Take one health potion away
                        numHealthPotions--;
                        System.out.println("\t> YOu drink a health potion, +" + healthPotionHealAmount + "." + "\n\t> You now have " + health + " HP" + "\n\t> You have " +                            numHealthPotions + " Health potions left.\n");
                    } else {
                        // no health potions
                        System.out.println("\t> You have no health potions left, defeat enemies to try and recover one!");
                    }
                    // For running away //
                } else if (input.equals("3")) {
                    System.out.println("\t> You ran away from the " + enemy + "!");
//                    continue GAME; // goes back to start of loop (GAME) if running away is true
                    break;
                } else {
                    // If user enters something else
                    System.out.println("\tInvalid command.");
                }
            }


            // Health gets too low //
            if (health < 1) {
                System.out.println("You have been slain....");
                break;
            }

            System.out.println("----------------------");

            System.out.println(" # You have " + health + " HP left. #");
            // If enemy drops a health potion after being defeated (50% chance)

//            if(rand.nextInt(100) < healthPotionDropChance) {
//                numHealthPotions++;
//                System.out.println(" # The " + enemy + " dropped a health potion. # ");
//                System.out.println(" # You have " + numHealthPotions + " health potion(s).");
//            }

            System.out.println("----------------------");
            // Next Adventure Options
            System.out.println("What would you like to do?");
            System.out.println("1. Continue fighting.");
            System.out.println("2. Leave the Dark Forest.");

            // Run loop based on user's input
            String input = in.nextLine();
            // If player input is not 1 or 2
            while(!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid command!");
                input = in.nextLine();
            }
            // If player chooses 1 or 2
            if(input.equals("1")) {
                System.out.println("You continue further into the Forest.....");
            } else if(input.equals("2")) {
                System.out.println("You left the Dark Forest.");
                break;
            }
        }
        // Leaving Game
        System.out.println("#########################");
        System.out.println(" # THANKS FOR PLAYING! # ");
        System.out.println("#########################");
    }



//    // User Choice
//    public static void turn() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Welcome to the dungeon! A goblin has appeared!");
//
//        // enemy
//        goblin goblinOne = new goblin();
//
//
//        // Choices for User
//        System.out.println("What do you do?");
//        System.out.println("1 Attack");
//        System.out.println("2 Drink Potion");
//        System.out.println("3 Run Away");
//        int action = scanner.nextInt();
//
//        // Attack
//        if (action == 1) {
//            System.out.println("Attack!");
//            goblinOne.enemyHealth = goblinOne.enemyHealth - 10;
//            System.out.println("Enemy health is now " + goblinOne.enemyHealth);
//        }
//
//        // Drink Potion
//        else if (action == 2) {
//            System.out.println("Drink up");
//        }
//
//        // Escape
//        else if (action == 3) {
//            System.out.println("You ran away....");
//        } else {
//            System.out.println("Chose a number!");
//            turn();
//        }

        // Enemy Turn
//        enemyAttack();
    }

//    public static void enemyAttack() {
//
//    }



//}

