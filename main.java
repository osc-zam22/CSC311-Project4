import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

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

        } catch (FileNotFoundException e) {}
        // debugging code
        // System.out.println(cities.toString());
        menu();
        choice = KB.nextInt();
        menuChoice(choice, cities);
    }

    // funcion that displays the menu in the terminal
    public static void menu() {
        System.out.printf("\n1. Display the information of all the cities\n2. Search a city\n3. Insert a city\n" +
                "4. Delete a city\n5. Update the population of a city\n6. Find the distance between two cities\n" +
                "7. Find nearby cities\n8. Exit the City Database\n");
    }

    public static void menuChoice(int choice, BSTCities cities) {
        int newPop;
        BSTCityNode result;
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
                // prompts
                System.out.println("Please enter the name of the city you wish to insert.");
                String newCity = KB.next();

                // error check, checks if the the city exists, if so, breaks
                result = cities.binSearch(cities.getRoot(), newCity);
                if (result != null) {
                    System.out.println("City already exists");
                    menu();
                    choice = KB.nextInt();
                    menuChoice(choice, cities);
                    break;
                }
                System.out.println("Now enter the cities longitude coordinates.");
                double newLong = KB.nextDouble();
                System.out.println("Now enter the cities latitude coordinates.");
                double newLat = KB.nextDouble();
                System.out.println("Now enter the cities population density.");
                newPop = KB.nextInt();

                City temp = new City(newCity, newLong, newLat, newPop);
                cities.insert(temp);
                System.out.println("Updated database: \n" + cities.toString());

                menu();
                choice = KB.nextInt();
                menuChoice(choice, cities);
                break;
            case 4: // delete city
                // prompts user
                System.out.println("Enter the name of a city to delete.");
                String killCity = KB.next();
                 
                // checks if the city exists
                result = cities.remove(cities.getRoot(), killCity);
                 
                // error handling
                if (result == null) {
                System.out.println("City did not exist in  the records");
                }
                else{
                    System.out.println("City successfully removed, the new database is:\n" + cities.toString());
                }
                menu();
                choice = KB.nextInt();
                menuChoice(choice, cities);
                break;
            case 5: // update pop of a city
                System.out.println("Enter name of city you want to update.");
                String cityName = KB.next();
                
                // checks if the city exists
                result = cities.binSearch(cities.getRoot(), cityName);
                 
                // handles case where the city does not exist
                if (result == null) {
                    System.out.println("City does not exist");
                    break;
                } 
                
                // process of updating a city's population
                System.out.println(result); 
                System.out.println("Enter new population");
                newPop = KB.nextInt();
                
                // error handling, setPop method throws exception
                try {
                    result.getCity().setPop(newPop);
                } catch (Exception e) {
                    System.out.println("Not a valid population, must be equal to or greater than 0");
                }
                 
                
                menu();
                choice = KB.nextInt();
                menuChoice(choice, cities);
                break;
            case 6: // find distance between two cities
                System.out.println("Enter the name of the first city: ");
                String city1 = KB.next();
                
                BSTCityNode temp1 = cities.binSearch(cities.getRoot(), city1);

                //error checking
                while(temp1 == null){
                System.out.println("City does not exist enter a valid city");
                city1 = KB.next();
                 
                temp1 = cities.binSearch(cities.getRoot(), city1);
                }
                 
                System.out.println("Enter the name of the second city: ");
                String city2 = KB.next();
                
                BSTCityNode temp2 = cities.binSearch(cities.getRoot(), city2);
                //error checking
                while(temp2 == null){
                    System.out.println("City does not exist enter a valid city");
                    city2 = KB.next();
                
                    temp2 = cities.binSearch(cities.getRoot(), city2);
                }
                 
                System.out.println("The distance in km between the two cities are: ");
                System.out.println("The distance between these two cities in kilometers is : " + 
                                    City.distance(temp1.getCity(), temp2.getCity()) + " KM");
                
                menu();
                choice = KB.nextInt();
                menuChoice(choice, cities);
                break;
            case 7: // find nearby cities
                System.out.println("Enter the name of the city: ");
                String city = KB.next();

                
                result = cities.binSearch(cities.getRoot(), city);
                // error checking
                while(result == null){
                System.out.println("City does not exist enter a valid city");
                city = KB.next();
                
                result = cities.binSearch(cities.getRoot(), city);
                }
                 
                // accepts user input
                System.out.println("Enter kilometer radius to search");
                double radius = KB.nextDouble();
                // formatting
                System.out.printf("\nCities near a %f km radius are\n" + 
                        "==========================\n\n", radius);
                // makes function call to print cities
                cities.searchRad(cities.getRoot(), result.getCity(), radius);
                menu();
                choice = KB.nextInt();
                menuChoice(choice, cities);
                break;
            case 8: // exit
                System.out.println("Exiting program");
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public static void menuFor1() {
        System.out.printf("=====================================\n9. Display cities in the alphabetical order of names\n"
            + "10. Display cities in the ascending order of their population\n11. Exit to top menu\n");
    }

    public static void choiceFor1(int choice, BSTCities cities) {
        switch (choice) {
            case 9: // print by a-z
                // toString is in Order traversal by default
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
                
                 BSTCityNode result = cities.binSearch(cities.getRoot(), cityName);
                 
                 if (result == null) {
                 System.out.println("City does not exist in  the records");
                 } else {
                 System.out.println(result);
                 }
                 
                menu();
                choice = KB.nextInt();
                menuChoice(choice, cities);
                break;

            case 13: // search by pop range
                System.out.println("Enter minimum range  of population to search for: ");
                int popMin = KB.nextInt();
                System.out.println("Enter maximum range of population to search for: ");
                int popMax = KB.nextInt();
                cities.betweenThreshold(cities.getRoot() , popMin , popMax);
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