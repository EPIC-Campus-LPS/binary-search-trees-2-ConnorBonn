import java.util.EmptyStackException;
import java.util.Stack;

public class BinarySearchTree<E extends Comparable<E>> {
    private TreeNode<E> root;
    private int countLeaf = 0;
    private int countNode = 0;
    private int height = 0;

    void add(E value) {
        //makes new node
        TreeNode<E> addedElement = new TreeNode<E>(value, null, null);
        //checks if the root exists
        if (root == null) {
            //changes the element to the root
            root = addedElement;
            countLeaf = 1;
        } else {
            //Creates a new node
            TreeNode<E> temp = root;
            while (true) {
                //checks if the new node is less than the current
                if (temp.getValue().compareTo(addedElement.getValue()) >= 0) {
                   //checks if the left child exists
                    if (temp.getLeftChild() == null) {
                        //sets new node as left child
                        temp.setLeftChild(addedElement);
                        //adds the new leaf to the count
                        countLeaf++;
                        //checks if the left child is the only child
                        if(temp.getLeftChild() != null && temp.getRightChild() == null){
                            //removes a leaf from the count
                            countLeaf--;
                        }
                        break;
                        //
                    } else {
                        //moves down the tree
                        temp = temp.getLeftChild();
                    }
                    //checks if the new node is more than the current
                } else if (temp.getValue().compareTo((addedElement.getValue())) < 0) {
                    //checks if the right child exists
                    if (temp.getRightChild() == null) {
                        //sets the new node as right child
                        temp.setRightChild(addedElement);
                        //add the new leaf to the count
                        countLeaf++;
                        //checks if the right child is the only child
                        if(temp.getRightChild() != null && temp.getLeftChild() == null){
                            //removes a leaf from the count
                            countLeaf--;
                        }
                        break;
                    } else {
                        //moves to the next node
                        temp = temp.getRightChild();
                    }
                }
            }
        }
        //increases the number of nodes
        countNode++;
    }

    boolean contains(E value) {
        //creates a stack
        Stack<TreeNode<E>> stack = new Stack<>();
        //makes a node for tracing
        TreeNode<E> current = root;
        //loops while current isn't null and the stack isn't empty
        while (current != null || !stack.isEmpty()) {
            //loops while current isn't null
            while (current != null) {
                //checks if current is equal to the value
                if(current.getValue() == value){
                    return true;
                }
                //pushes right children into the stack
                stack.push(current.getRightChild());
                //traces left subtree
                current = current.getLeftChild();
            }
            if (!stack.isEmpty()) {
                //makes the old right child equal to the current
                current = stack.pop();
            }
        }
        return false;
    }

    int countNodes() {
        //returns the total number of nodes
        return countNode;
    }

    int countLeafNodes() {
        //returns the number of leaf nodes
        return countLeaf;
    }


   /*     int getHeight() {
            return height;
        }
/*
    void printInorder() {
        Stack<TreeNode<E>> stack = new Stack<>();
        TreeNode<E> parent = root;
        TreeNode<E> current = parent.getLeftChild();
        while(){

        }

    }*/


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

