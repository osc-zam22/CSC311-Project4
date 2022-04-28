import java.util.Scanner;
import java.io.*;

public class Main{
    // comment
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
    }

    public static void menue(){
        System.out.printf("1. Display the information of all the cities\n2. Search a city\n3. Insert a city\n"+
        "4. Delete a city\n5. Update the population of a city\n6. Find the distance between two cities\n"+
        "7. Find nearby cities\n8. Exit the City Database\n");
    }

    public static void menueFor1(){
        System.out.printf("9. Display cities in the alphabetical order of names\n"+
        "10. Display cities in the ascending order of their population\n"+
        "11. Exit to top menu");
    }

    public static void menueFor2(){
        System.out.printf("12. Search by Name\n"+
        "13. Search by Population Range\n"+
        "14. Exit to top menu");
    }

}