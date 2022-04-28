public abstract class Node <E> {
    private E object;

    private Node left, right;

    public abstract void setLeft(Node left);
    public abstract void setRight(Node right);
    public abstract Node getLeft();
    public abstract Node getRight();

}
