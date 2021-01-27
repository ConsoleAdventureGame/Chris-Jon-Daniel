import java.util.Scanner;


public class ConsoleAdventureGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables
        String name = "Player";
        Hero ourHero = new Hero();
        goblin goblinOne = new goblin();

        System.out.println("Would you lke to play?");

        String toPlay = scanner.nextLine();

        // Initialize Game
        if(toPlay.equalsIgnoreCase("yes")){
            System.out.println("What is your name?");
            name = scanner.nextLine();

            ourHero.name = name;
            System.out.println("Hello " + ourHero.name +  "\nHealth is: " + ourHero.health);
            turn();
        } else {
            System.out.println("Come back when you are ready.");
        }



    }

    // User Choice
    public static void turn() {
        Scanner scanner = new Scanner(System.in);
        // Choices for User
        System.out.println("What do you do?");
        System.out.println("1 Attack");
        System.out.println("2 Defend");
        System.out.println("3 Drink Potion");
        System.out.println("4 Run Away");
        int action = scanner.nextInt();

        // Attack
        if(action == 1) {
            System.out.println("Attack!");
        }
        // Defend
        else if(action == 2) {
            System.out.println("Defend");
        }
        // Drink Potion
        else if(action == 3) {
            System.out.println("Drink up");
        }
        // Escape
        else if(action == 4) {
            System.out.println("You ran away....");
        }
        else {
            System.out.println("Chose a number!");
            turn();
        }

    }
}
