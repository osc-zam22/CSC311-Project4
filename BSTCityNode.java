public class BSTCityNode implements Node<City>{

    private City city;
    private Node<City> left, right;


    public BSTCityNode(City city){
        this.city = new City(city.getName() , city.getLongtitude() , city.getLatitude() , city.getPop());
        this.left = null;
        this.right = null;
    }

    @Override
    public void setLeft(Node<City> left) {
        // TODO Auto-generated method stub
        this.left = left;
    }

    @Override
    public void  setRight(Node<City> right) {
        // TODO Auto-generated method stub
        this.right = right;
    }

    @Override
    public Node<City> getLeft() {
        // TODO Auto-generated method stub
        return this.left;
    }

    @Override
    public Node<City> getRight() {
        // TODO Auto-generated method stub
        return this.right;
    }

    @Override
    public boolean isLeaf() {
        // TODO Auto-generated method stub
        if(this.left == null && this.right == null){
            return true;
        }
        return false;
    }

    
}
