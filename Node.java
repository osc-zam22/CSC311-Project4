public interface Node <E> {
 
    public abstract void setLeft(Node<E> left);
    public abstract void setRight(Node<E> right);
    public abstract Node<E> getLeft();
    public abstract Node<E> getRight();
    public abstract boolean isLeaf();
}
