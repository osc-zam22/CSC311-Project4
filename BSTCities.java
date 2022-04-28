import java.util.List;

public class BSTCities {

    BSTCityNode root;

    public BSTCities(BSTCityNode city)
    {
        this.setRoot(city);
    }

    public void setRoot(BSTCityNode node) {
        // TODO Auto-generated method stub
        this.root = node;
        
    }

    public BSTCityNode getRoot() {
        // TODO Auto-generated method stub
        return this.root;
    }

    public void insert(BSTCityNode node) {
        // TODO Auto-generated method stub
        
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

    public BSTCityNode getMax() {
        // TODO Auto-generated method stub
        return null;
    }

    public BSTCityNode getMin() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<BSTCityNode> postOrder() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
