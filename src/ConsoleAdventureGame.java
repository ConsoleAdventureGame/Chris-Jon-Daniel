import java.util.Scanner;

public class ConsoleAdventureGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = "Player";

        System.out.println("Would you lke to play?");

        String toPlay = scanner.nextLine();

        if(toPlay.equals("yes")){
            System.out.println("What is your name?");
            name = scanner.nextLine();

            System.out.println(name);
        } else {
            System.out.println("Come back when you are");
        }



    }


}
