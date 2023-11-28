import java.util.EmptyStackException;
import java.util.Stack;

public class BinarySearchTree<E extends Comparable<E>> {
    private TreeNode<E> root;
    private int countNode = 0;

    void add(E value) {
        //makes new node
        TreeNode<E> addedElement = new TreeNode<E>(value, null, null);
        if (root == null) {
            root = addedElement;
        } else {
            TreeNode<E> temp = root;
            while (temp.getRightChild() != null && temp.getLeftChild() != null) {
                if (temp.getValue().compareTo(addedElement.getValue()) <= 0) {
                    if (temp.getLeftChild() == null) {
                        temp.setLeftChild(addedElement);
                    } else {
                        temp = temp.getLeftChild();
                    }
                    if (temp.getRightChild() == null) {
                        temp.setRightChild(addedElement);
                    } else {
                        temp = temp.getRightChild();
                    }
                }
            }
        }
        countNode++;
    }

    /* boolean contains(E value) {

    }

    int countNodes() {
        return countNode;
    }

    int countLeafNodes() {

    }

    int getHeight() {

    }

    void printInorder() {

    }
*/
    void printPreorder() {
        Stack<TreeNode<E>> stack = new Stack<>();
        TreeNode<E> current = root;
        if (root == null) {
            throw new EmptyStackException();
        } else {
            while (current != null || !stack.isEmpty()) {
                while (current != null) {
                    System.out.println(root);
                    if(current.getLeftChild() != null){
                        System.out.println(current.getLeftChild());
                        current = current.getLeftChild();
                    }
                    else if(current.getRightChild() != null){
                        System.out.println(current.getRightChild());
                        current = current.getRightChild();
                    }
                    else{


                    }
                }
            }
        }
    }
  /*  void printPostorder() {

    }

    E delete(E value) {
        countNode--;
        return value;
    }*/
}
