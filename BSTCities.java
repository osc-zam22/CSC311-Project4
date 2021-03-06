import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


// custom code, written from scratch
public class BSTCities {

    // attributes
    private BSTCityNode root;
    private int nodeCount;


    // default constructor, initializes an empty tree
    public BSTCities()
    {
        root = null;
        nodeCount = 0;
    }
    // sets the root of the tree
    public void setRoot(City city) {
        this.root = new BSTCityNode(city);
        
    }

    //returns the root of the tree
    public BSTCityNode getRoot() {
        return this.root;
    }

    // inserts a new node
    public void insert(City city) {
        root = insertHelp(root , city);
        nodeCount++;
    }

    // insert helper method(from provided code)
    private BSTCityNode insertHelp(BSTCityNode root, City city) {
        if(root== null){
            return new BSTCityNode(city);
        }
        if (root.getCity().compareTo(city) > 0)
            root.setLeft(insertHelp(root.getLeft(), city));
        else
            root.setRight(insertHelp(root.getRight(), city));
        return root;
    }

    // binary Search
    public BSTCityNode binSearch(BSTCityNode node, String cityName) {
        // base case
        if(node == null){
            return null;
        }
        else if(node.getCity().getName().compareToIgnoreCase(cityName) == 0)
        {
            return node; 
        }
        // recursive calls
        else if(node.getCity().getName().compareToIgnoreCase(cityName) > 0)
        {
            return binSearch(node.getLeft(), cityName);
        }
        else if(node.getCity().getName().compareToIgnoreCase(cityName) < 0)
        {
            return binSearch(node.getRight(), cityName);
        }
        // base case
        else return null;
    }

        // binary Search, overloaded to account for objects and for Strings
        public BSTCityNode binSearch(BSTCityNode node, City city) {
            // base case
            if(node == null){
                return null;
            }
            else if(node.getCity().getName().compareToIgnoreCase(city.getName()) == 0)
            {
                return node; 
            }
            // recursive calls
            else if(node.getCity().getName().compareToIgnoreCase(city.getName()) > 0)
            {
                return binSearch(node.getLeft(), city);
            }
            else if(node.getCity().getName().compareToIgnoreCase(city.getName()) < 0)
            {
                return binSearch(node.getRight(), city);
            }
            // base case
            else return null;
        }

    // recursive method to find and return the max node in the tree
    public BSTCityNode getMax(BSTCityNode node) {
        if(node != null && node.getRight() != null){
            return getMax(node.getRight());
        }
        return node;
    }

    // recursive method to find and return the min node in the tree
    public BSTCityNode getMin(BSTCityNode node) {
        if(node != null && node.getLeft() != null){
            return getMin(node.getLeft());
        }
        return node;
    }


    // helper print function, in Order traversal
    private void printhelp(BSTCityNode rt) 
    {
        // base case
        if (rt == null) 
            return;
        printhelp(rt.getLeft());
        printVisit(rt);
        printhelp(rt.getRight());
    }

    private StringBuffer out;

    // to string function
    public String toString() 
    {
        out = new StringBuffer(100);
        printhelp(root);
        return out.toString();
    }

    // another helper function for the to string
    private void printVisit(BSTCityNode rNode) 
    {
        out.append(rNode.toString() + "\n");
    }

    // returns all cities between a certain range in population pre order traversal
    public void betweenThreshold(BSTCityNode root , int lowerBound, int upperBound )
    {
        {
            // base case
            if(root == null)
            {
                return ;
            }
            // process node
            else if(root.getCity().getPop() >= lowerBound && root.getCity().getPop() <= upperBound)
            {
                System.out.print(root.toString() + "\n");
            }
            // process next nodes
            betweenThreshold(root.getLeft() , lowerBound, upperBound);
            betweenThreshold(root.getRight() , lowerBound, upperBound);
        } 
    }


    // remove function, design choice, removes the min
    // borrowed from provided code
    public BSTCityNode remove(BSTCityNode root , String name) 
    {
        BSTCityNode temp = this.binSearch(root, name);   // First find it
        if (temp != null) 
        {
            root = removehelp(root, name); // Now remove it
            nodeCount--;
        }
    return temp;
    }


    // remove helper function, design choice: removes the min
    // borrowed from provided code, uses binary search to find the min
    private BSTCityNode removehelp(BSTCityNode rt, String query) 
    {
        if (rt == null) 
            return null;
        if (rt.getCity().getName().compareTo(query) > 0)
            rt.setLeft(removehelp(rt.getLeft(), query));
        else if (rt.getCity().getName().compareTo(query) < 0)
            rt.setRight(removehelp(rt.getRight(), query));
        else 
        { // Found it
            if (rt.getLeft() == null) 
                return rt.getRight();
            else if (rt.getRight() == null) 
                return rt.getLeft();
            else 
            { // Two children
                BSTCityNode temp = getMin(rt.getRight());
                rt.setCity(temp.getCity());
                rt.setRight(deleteMin(rt.getRight()));
            }
        }
    return rt;
    }
    // deletes the min node
    private BSTCityNode deleteMin(BSTCityNode rt) 
    {
        if (rt.getLeft() == null) 
            return rt.getRight();
        rt.setLeft(deleteMin(rt.getLeft()));
        return rt;
    }


    // prints all cities in radius of a city that was passed
    public void searchRad(BSTCityNode node , City temp , double radius)
    {
    if(node == null){
        return;
    }
    // inOrder traversal to process nodes
    searchRad(node.getLeft(), temp, radius);
    if(!node.getCity().equals(temp) && City.distance(temp, node.getCity()) <= radius ){
        System.out.println(node.toString());
    }
    searchRad(node.getRight(), temp, radius);
    }


    public void sortedByPop(BSTCityNode node)
    {
        // initiates a list of Cities
        List<City> cityList = new ArrayList<City>();
        // inserts all Cities into the list
        sortedPopHelper(node, cityList);
        // sorts the lists
        quickSort(cityList, 0, cityList.size()-1);

        //iterator to iterate through the list
        Iterator<City> iter = cityList.iterator();
        // prints the list of Cities in order
        while(iter.hasNext())
        {
            System.out.println(iter.next().toString());
        }

    }

    // helper function, insertes all cities into the list
    private void sortedPopHelper(BSTCityNode node , List<City> list)
    {
        if(node == null){
            return;
        }
        list.add(node.getCity());
        sortedPopHelper(node.getLeft(), list);
        sortedPopHelper(node.getRight(), list);
    }

    // quick Sort algorithm, used to sort population
    private void quickSort(List<City> list , int low , int high)
    {
        if(low < high) 
        {
            int pivot = split(list , low , high);
            quickSort(list, low, pivot -1);
            quickSort(list, pivot +1, high);
        }
    }

    // helper function for quicksort, returns the index on where to split the array
    private int split(List<City> list , int low , int high)
    {
        int pivot = list.get(high).getPop();
        int i = low-1;
        for(int j = low ; j <= high -1 ; j++)
        {
            if(list.get(j).getPop() < pivot )
            {
                i++;
                Collections.swap(list, i, j);
            }
            
        }
        Collections.swap(list, i+1, high);
        return i+1;
    }
}
