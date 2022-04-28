
public class BSTCityNode{

    private City city;
    private BSTCityNode left, right;


    public BSTCityNode(City city){
        this.city = city;
        this.left = null;
        this.right = null;
    }

    
    public void setLeft(BSTCityNode left) {
        // TODO Auto-generated method stub
        this.left = left;
    }

   
    public void  setRight(BSTCityNode right) {
        // TODO Auto-generated method stub
        this.right = right;
    }

    
    public BSTCityNode getLeft() {
        // TODO Auto-generated method stub
        return this.left;
    }

    
    public BSTCityNode getRight() {
        // TODO Auto-generated method stub
        return this.right;
    }

    
    public boolean isLeaf() {
        // TODO Auto-generated method stub
        if(this.left == null && this.right == null){
            return true;
        }
        return false;
    }
    
    public void setCity(City city)
    {
        this.city = city;
    }
    public City getCity()
    {
        return this.city;
    }
    public String toString(){
        return city.toString();
    }
}
