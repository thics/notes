public class TreeNode<E> {
    
  private E data;
  private TreeNode<E> right;
  private TreeNode<E> left;

  public TreeNode( E d ) {
    data = d;
  }
  public String toString() {
    return "" + data;
  }
  public void setData( E c ) {
    data = c;
  }
  public void setRight( TreeNode<E> n ) {
    right = n;
  }
  public void setLeft( TreeNode<E> n) {
    left = n;
  }
  public E getData() {
    return data;
  }
  public TreeNode<E> getRight() {
    return right;
  }
  public TreeNode<E> getLeft() {
    return left;
  }
}
