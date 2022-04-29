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
        menuChoice(choice, cities);
    }

    public static void menu() {
        System.out.printf("\n1. Display the information of all the cities\n2. Search a city\n3. Insert a city\n" +
                "4. Delete a city\n5. Update the population of a city\n6. Find the distance between two cities\n" +
                "7. Find nearby cities\n8. Exit the City Database\n");
    }

    public static void menuChoice(int choice, BSTCities cities) {
        while (choice < 1 || choice > 8) {
            System.out.println("Enter a Valid number.");
            menu();
            choice = KB.nextInt();
        }
        switch (choice) {
            case 1: // submenu1
                menuFor1();
                choice = KB.nextInt();
                while (choice < 9 || choice > 11) {
                    System.out.println("Enter valid number");
                    choice = KB.nextInt();
                }
                choiceFor1(choice, cities);
                break;
            case 2: // submenu2
                menuFor2();
                choice = KB.nextInt();
                while (choice < 12 || choice > 14) {
                    System.out.println("Enter valid number");
                    choice = KB.nextInt();
                }
                choiceFor2(choice, cities);
                break;
            case 3: // insert city
                System.out.println("Please enter the name of the city you wish to insert.");
                String newCity = KB.nextLine();
                System.out.println("Now enter the cities longitude coordinates.");
                double newLong = KB.nextDouble();
                System.out.println("Now enter the cities latitude coordinates.");
                double newLat = KB.nextDouble();
                System.out.println("Now enter the cities population density.");
                int newPop = KB.nextInt();

                City temp = new City(newCity, newLong, newLat, newPop);
                cities.insert(temp);
                /*
                 * BSTCityNode result = cities.binSearch(BSTCities.getRoot(), temp);
                 * 
                 * if (result != null) {
                 * System.out.println("City already exists");
                 * } else {
                 * cities.insert(temp);
                 * }
                 */
                break;
            case 4: // delete city
                System.out.println("Eneter the name of a city to delete.");
                String killCity = KB.nextLine();
                /*
                 * cities.remove(killCity);
                 * 
                 * BSTCityNode result = cities.binSearch(BSTCities.getRoot(), killCity);
                 * 
                 * if (result == null) {
                 * System.out.println("City does not exist in  the records");
                 * } else {
                 * cities.remove(killCity);
                 * }
                 */
                break;
            case 5: // update pop of a city

                break;
            case 6: // find distance between to cities

                break;
            case 7: // find nearby cities

                break;
            case 8:// exit
                System.exit(0);
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

    public static void choiceFor1(int choice, BSTCities cities) {
        switch (choice) {
            case 9: // print by a-z
                System.out.println(cities.toString());
                break;

            case 10: // print by pop

                break;

            case 11:
                menu();
                choice = KB.nextInt();
                menuChoice(choice, cities);
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

    public static void choiceFor2(int choice, BSTCities cities) {
        switch (choice) {
            case 12: // Search by name
                System.out.println("Enter city name to search");
                String cityName = KB.nextLine();
                /*
                 * BSTCityNode result = cities.binSearch(BSTCities.getRoot(), cityName);
                 * 
                 * if (result == null) {
                 * System.out.println("City does not exist in  the records");
                 * } else {
                 * System.out.println(result);
                 * }
                 */
                break;

            case 13: // search by pop
                System.out.println("Enter the number of population to search for: ");
                int popSearch = KB.nextInt();
                /*
                 * BSTCityNode result = cities.binSearch(BSTCities.getRoot(), popSearch);
                 * 
                 * if (result == null) {
                 * System.out.println("City with that population does not exist on record");
                 * } else {
                 * System.out.println(result);
                 * }
                 */
                break;

            case 14: // return to main
                menu();
                choice = KB.nextInt();
                menuChoice(choice, cities);
                break;

            default:
                break;
        }
    }

}