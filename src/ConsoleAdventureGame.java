import java.util.Scanner;

public class ConsoleAdventureGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = "Player";
        Hero ourHero = new Hero();
        goblin goblinOne = new goblin();

        System.out.println("Would you lke to play?");

        String toPlay = scanner.nextLine();

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

    public static void turn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you do?");
        String action = scanner.nextLine();

        if(action.equalsIgnoreCase("run")){
            System.out.println("You ran away");
        }
    }


}
