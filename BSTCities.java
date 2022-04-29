import java.util.List;

public class BSTCities {

    // attributes
    private BSTCityNode root;
    private int nodeCount;


    // default constructor, initializes an empty tree
    public BSTCities()
    {
        root = null;
        nodeCount =0;
    }
    // if the tree is empty, sets the root, else inserts the node

    public void setRoot(City city) {
        // TODO Auto-generated method stub
        this.root = new BSTCityNode(city);
        
    }

    public BSTCityNode getRoot() {
        // TODO Auto-generated method stub
        return this.root;
    }

    public void insert(City city) {
        // TODO Auto-generated method stub
        root = insertHelp(root , city);
        nodeCount++;
    }

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
    public void remove(BSTCityNode node) {
        // TODO Auto-generated method stub
        
    }

    public BSTCityNode binSearch(BSTCityNode node, String cityName) {
        // TODO Auto-generated method stub
        if(node.getCity().getName().compareToIgnoreCase(cityName) == 0)
        {
            return node; 
        }
        else if(node.getCity().getName().compareToIgnoreCase(cityName) > 0)
        {
            return binSearch(node.getLeft(), cityName);
        }
        else if(node.getCity().getName().compareToIgnoreCase(cityName) < 0)
        {
            return binSearch(node.getRight(), cityName);
        }
        else return null;
    }

    public BSTCityNode getMax(BSTCityNode node) {
        if(node != null && node.getRight() != null){
            return getMax(node.getRight());
        }
        return node;
    }

    public BSTCityNode getMin(BSTCityNode node) {
        // TODO Auto-generated method stub
        if(node != null && node.getLeft() != null){
            return getMin(node.getLeft());
        }
        return node;
    }

    public List<BSTCityNode> postOrder() {
        // TODO Auto-generated method stub
        return null;
    }
    

    // helper print function
    private void printhelp(BSTCityNode rt) 
    {
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

    // another helper function to the to string
    private void printVisit(BSTCityNode rNode) 
    {
        out.append(rNode.toString() + "\n");
    }
}
