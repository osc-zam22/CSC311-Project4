import java.util.Scanner;
import java.io.*;

public class Main {
    // comment\

    public static Scanner KB = new Scanner(System.in);
    public static int choice;

    public static void main(String[] args) {
        File file = new File("LATowns.txt");
        Scanner sc;
        BSTCities cities = new BSTCities();

        try {
            sc = new Scanner(file);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String name = sc.next();
                double latitude = sc.nextDouble();
                double longitude = sc.nextDouble();
                int population = sc.nextInt();
                City temp = new City(name, longitude, latitude, population);
                cities.insert(temp);
                // debugging code
                // System.out.println(temp.toString());
                // System.out.println("current tree" + cities.toString());

            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // debugging code
        // System.out.println(cities.toString());
        menu();
        choice = KB.nextInt();
        menuChoice(choice);
    }

    public static void menu() {
        System.out.printf("\n1. Display the information of all the cities\n2. Search a city\n3. Insert a city\n" +
                "4. Delete a city\n5. Update the population of a city\n6. Find the distance between two cities\n" +
                "7. Find nearby cities\n8. Exit the City Database\n");
    }

    public static void menuChoice(int choice) {
        while (choice < 1 || choice > 8) {
            System.out.println("Enter a Valid number.");
            menu();
            choice = KB.nextInt();
        }
        switch (choice) {
            case 1:
                menuFor1();
                choice = KB.nextInt();
                while (choice < 9 || choice > 11) {
                    System.out.println("Enter valid number");
                    choice = KB.nextInt();
                }
                choiceFor1(choice);
                break;
            case 2:
                menuFor2();
                choice = KB.nextInt();
                while (choice < 12 || choice > 14) {
                    System.out.println("Enter valid number");
                    choice = KB.nextInt();
                }
                choiceFor2(choice);
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

    public static void menuFor1() {
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
                menu();
                choice = KB.nextInt();
                menuChoice(choice);
                break;
            default:
                break;
        }
    }

    public static void menuFor2() {
        System.out.printf("12. Search by Name\n" +
                "13. Search by Population Range\n" +
                "14. Exit to top menu\n");
    }

    public static void choiceFor2(int choice) {
        switch (choice) {
            case 12:

                break;
            case 13:

                break;
            case 14:
                menu();
                choice = KB.nextInt();
                menuChoice(choice);
                break;
            default:
                break;
        }
    }

}