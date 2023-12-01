import java.util.EmptyStackException;
import java.util.Stack;

public class BinarySearchTree<E extends Comparable<E>> {
    private TreeNode<E> root;
    private int countLeaf = 0;
    private int countNode = 0;

    void add(E value) {
        //makes new node
        TreeNode<E> addedElement = new TreeNode<E>(value, null, null);
        if (root == null) {
            root = addedElement;
        } else {
            TreeNode<E> temp = root;
            while (true) {
                if (temp.getValue().compareTo(addedElement.getValue()) >= 0) {
                    if (temp.getLeftChild() == null) {
                        temp.setLeftChild(addedElement);
                        break;
                    } else {
                        temp = temp.getLeftChild();
                    }
                } else if (temp.getValue().compareTo((addedElement.getValue())) < 0) {
                    if (temp.getRightChild() == null) {
                        temp.setRightChild(addedElement);
                        break;
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
*/
    int countNodes() {
        return countNode;
    }

    int countLeafNodes() {
        Stack<TreeNode<E>> stack = new Stack<>();
        TreeNode<E> current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                if (current.getRightChild() == null && current.getLeftChild() == null) {
                    countLeaf++;
                } else {
                    stack.push(current.getRightChild());
                    current = current.getLeftChild();
                }
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
            }
        }
        return countLeaf;
    }

    /*
        int getHeight() {

        }
    */
    void printInorder() {
        Stack<TreeNode<E>> stack = new Stack<>();
        TreeNode<E> parent = root;
        TreeNode<E> current = root;
        while (parent.getLeftChild() != null) {

            if (current.getRightChild() != null && current.getLeftChild() == null) {
                System.out.println(current);
                parent = current;
                current = parent.getRightChild();
            } else if (current.getRightChild() == null && current.getLeftChild() == null) {
                System.out.println(current);
                System.out.println(parent);
            }
        }
    }

    public void printPreorder() {
        Stack<TreeNode<E>> stack = new Stack<>();
        TreeNode<E> current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                System.out.println(current.getValue());
                stack.push(current.getRightChild());
                current = current.getLeftChild();
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
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

