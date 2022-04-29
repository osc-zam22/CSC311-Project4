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
                String newCity = KB.next();
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
                menu();
                choice = KB.nextInt();
                menuChoice(choice, cities);
                break;
            case 4: // delete city
                System.out.println("Eneter the name of a city to delete.");
                String killCity = KB.next();
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
                menu();
                choice = KB.nextInt();
                menuChoice(choice, cities);
                break;
            case 5: // update pop of a city
                System.out.println("Enter name of city you want to update.");
                String cityName = KB.next();
                /*
                 * BSTCityNode result = cities.binSearch(BSTCities.getRoot(), cityName);
                 * 
                 * if (result == null) {
                 * System.out.println("City does not exist");
                 * } else {
                 * System.out.println(result);
                 */
                System.out.println("Enter new population");
                int newPop2 = KB.nextInt();
                /*
                 * result.setPop = newPop2;
                 * 
                 */
                menu();
                choice = KB.nextInt();
                menuChoice(choice, cities);
                break;
            case 6: // find distance between two cities
                System.out.println("Enter the name of the first city: ");
                String city1 = KB.next();
                /*
                 * BSTCityNode c1 = cities.binSearch(BSTCities.getRoot(), city1);
                 * while(c1 == null){
                 * System.out.println("City does not exist enter a valid city");
                 * city1 = KB.next();
                 * 
                 * c1 = cities.binSearch(BSTCities.getRoot(), city1);
                 * }
                 */
                System.out.println("Enter the name of the second city: ");
                String city2 = KB.next();
                /*
                 * BSTCityNode c2 = cities.binSearch(BSTCities.getRoot(), city2);
                 * 
                 * while(c2 == null){
                 * System.out.println("City does not exist enter a valid city");
                 * city2 = KB.next();
                 * 
                 * c2 = cities.binSearch(BSTCities.getRoot(), city2);
                 * }
                 * 
                 * System.out.println("The distance in km between the two cities are: ")
                 * System.out.println(cities.distance(cities, c1, c2));
                 */
                menu();
                choice = KB.nextInt();
                menuChoice(choice, cities);
                break;
            case 7: // find nearby cities
                System.out.println("Enter the name of the city: ");
                String cityNear = KB.next();

                /*
                 * BSTCityNode result = cities.binSearch(BSTCities.getRoot(), cityNear);
                 * 
                 * while(result == null){
                 * System.out.println("City does not exist enter a valid city");
                 * cityNear = KB.next();
                 * 
                 * result = cities.binSearch(BSTCities.getRoot(), cityNear);
                 * }
                 */

                System.out.println("Enter kilometer radius to search");
                double searchRad = KB.nextDouble();

                // System.out.println(cities.searchRad(cities, cityNear, searchRad));
                menu();
                choice = KB.nextInt();
                menuChoice(choice, cities);
                break;
            case 8: // exit
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public static void menuFor1() {
        System.out.printf("\n9. Display cities in the alphabetical order of names\n" +
                "10. Display cities in the ascending order of their population\n" +
                "11. Exit to top menu\n");
    }

    public static void choiceFor1(int choice, BSTCities cities) {
        switch (choice) {
            case 9: // print by a-z
                System.out.println(cities.toString());
                menu();
                choice = KB.nextInt();
                menuChoice(choice, cities);
                break;

            case 10: // print by pop

                menu();
                choice = KB.nextInt();
                menuChoice(choice, cities);
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
        System.out.printf("\n12. Search by Name\n" +
                "13. Search by Population Range\n" +
                "14. Exit to top menu\n");
    }

    public static void choiceFor2(int choice, BSTCities cities) {
        switch (choice) {
            case 12: // Search by name
                System.out.println("Enter city name to search");
                String cityName = KB.next();
                /*
                 * BSTCityNode result = cities.binSearch(BSTCities.getRoot(), cityName);
                 * 
                 * if (result == null) {
                 * System.out.println("City does not exist in  the records");
                 * } else {
                 * System.out.println(result);
                 * }
                 */
                menu();
                choice = KB.nextInt();
                menuChoice(choice, cities);
                break;

            case 13: // search by pop range
                System.out.println("Enter minimum range  of population to search for: ");
                int popMin = KB.nextInt();
                System.out.println("Enter maximum range of population to search for: ");
                int popMax = KB.nextInt();
                /*
                 * BSTCityNode result = cities.binSearch(BSTCities.getRoot(), popMin, popMax);
                 * 
                 * if (result == null) {
                 * System.out.println("City with population range does not exists");
                 * } else {
                 * System.out.println(result);
                 * }
                 */
                menu();
                choice = KB.nextInt();
                menuChoice(choice, cities);
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