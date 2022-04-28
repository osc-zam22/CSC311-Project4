import java.util.Scanner;
import java.io.*;

public class Main {
    // comment\

    public static Scanner KB = new Scanner(System.in);
    public static int choice;

    public static void main(String[] args) {
        File file = new File("LATowns.txt");
        Scanner sc;

        try {
            sc = new Scanner(file);
            while (sc.hasNextLine())
                System.out.println(sc.nextLine());

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        menue();
        choice = KB.nextInt();
        menueChoice(choice);
    }

    public static void menue() {
        System.out.printf("\n1. Display the information of all the cities\n2. Search a city\n3. Insert a city\n" +
                "4. Delete a city\n5. Update the population of a city\n6. Find the distance between two cities\n" +
                "7. Find nearby cities\n8. Exit the City Database\n");
    }

    public static void menueChoice(int choice) {
        while (choice < 1 || choice > 8) {
            System.out.println("Enter a Valid number.");
            menue();
            choice = KB.nextInt();
        }
        switch (choice) {
            case 1:
                menueFor1();
                choice = KB.nextInt();
                while (choice < 9 || choice > 11) {
                    System.out.println("Enter valid number");
                    choice = KB.nextInt();
                }
                choiceFor1(choice);
                break;
            case 2:
                menueFor2();
                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;
            default:
                break;
        }
    }

    public static void menueFor1() {
        System.out.printf("9. Display cities in the alphabetical order of names\n" +
                "10. Display cities in the ascending order of their population\n" +
                "11. Exit to top menu\n");
    }

    public static void choiceFor1(int choice) {
        switch (choice) {
            case 9:

                break;
            case 10:

                break;
            case 11:
                menue();
                choice = KB.nextInt();
                menueChoice(choice);
                break;
            default:
                break;
        }
    }

    public static void menueFor2() {
        System.out.printf("12. Search by Name\n" +
                "13. Search by Population Range\n" +
                "14. Exit to top menu\n");
    }

}