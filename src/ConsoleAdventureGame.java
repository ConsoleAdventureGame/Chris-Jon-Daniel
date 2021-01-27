import java.util.Scanner;

public class ConsoleAdventureGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = "Player";
        Hero ourHero = new Hero();

        System.out.println("Would you lke to play?");

        String toPlay = scanner.nextLine();

        if(toPlay.equalsIgnoreCase("yes")){
            System.out.println("What is your name?");
            name = scanner.nextLine();

            ourHero.name = name;
            System.out.println("Hello " + ourHero.name +  "\nHealth is: " + ourHero.health);
        } else {
            System.out.println("Come back when you are ready.");
        }



    }


}
