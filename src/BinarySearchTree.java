import java.util.EmptyStackException;
import java.util.Stack;

public class BinarySearchTree<E extends Comparable<E>> {
    private TreeNode<E> root;
    private int countLeaf = 0;
    private int countNode = 0;

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
                if (current.getValue() == value) {
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
        Stack<TreeNode<E>> stack = new Stack<>();
        //makes a node for tracing
        TreeNode<E> current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                //checks if the node is a leaf
                if (current.getLeftChild() == null && current.getRightChild() == null) {
                    countLeaf++;
                }
                //pushes currents right child to the stack
                stack.push(current.getRightChild());
                //move current to the left
                current = current.getLeftChild();
            }
            if (!stack.isEmpty()) {
                //sets current to a node that had been pushed into the stack
                current = stack.pop();
            }
        }
        return countLeaf;
    }


    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(TreeNode<E> node) {
        if (node == null) {
            return -1;
        }
        if (node.getLeftChild() == null && node.getRightChild() == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
    }

    public void printInorder() {
        printInorder(root);
    }

    private void printInorder(TreeNode<E> root) {
        if (root == null)
            return;
        printInorder(root.getLeftChild());
        System.out.println(root.getValue());
        printInorder(root.getRightChild());
    }

    public void printPreorder() {
        printPreorder(root);
    }

    private void printPreorder(TreeNode<E> root) {
        if (root == null)
            return;
        System.out.println(root.getValue());
        printPreorder(root.getLeftChild());
        printPreorder(root.getRightChild());
    }

    public void printPostorder() {
        printPostorder(root);
    }

    private void printPostorder(TreeNode<E> root) {
        if (root == null)
            return;
        printPostorder(root.getLeftChild());
        printPostorder(root.getRightChild());
        System.out.println(root.getValue());
    }

    E delete(E value) {
        TreeNode<E> current = root;
        if (!contains(value)) {
            return null;
        } else if (root.getValue() == value) {
            if (root.getLeftChild() == null && root.getRightChild() != null) {
                root = root.getRightChild();
            } else {
                TreeNode<E> rightTree = root.getRightChild();
                root.setRightChild(null);
                root = root.getLeftChild();
                while (true) {
                    if (current.getRightChild() == null) {
                        //sets the new node as right child
                        current.setRightChild(rightTree);
                        break;
                    } else {
                        //moves to the next node
                        current = current.getRightChild();
                    }
                }
            }
            if (current.getLeftChild() == null && current.getRightChild() == null) {
                root = null;
                return null;
            }
        }
        else if(value != root.getValue()){
            TreeNode<E> parent = root;
            Stack<TreeNode<E>> stack = new Stack<>();
            while (current != value || !stack.isEmpty()) {
                while (current != value) {
                    if(root.getValue().compareTo(value) >= 0){
                        parent = root.getLeftChild();
                    }
                    else{
                        parent = root.getRightChild();
                    }
                    current = parent.getLeftChild();
                    if(current.getValue() == value){
                        if(current.getLeftChild() == null && current.getRightChild() != null){
                            parent.setLeftChild(current.getRightChild());
                        }
                        else if(current.getLeftChild() != null && current.getRightChild() == null){
                            parent.setLeftChild(current.getLeftChild());
                            current.getLeftChild().setRightChild(current.getRightChild());
                            current = current.getLeftChild();
                        }
                        else if(current.getLeftChild() == null && current.getLeftChild() == null){
                            current = null;
                        }
                    }
                    //pushes currents right child to the stack
                    stack.push(current.getRightChild());
                    //moves to the left
                    parent = parent.getLeftChild();
                    if(parent.getLeftChild() == null){
                        current = parent.getRightChild();
                    }
                    else {
                        current = parent.getLeftChild();
                    }
                }
                if (!stack.isEmpty()) {
                    //sets current to a node that had been pushed into the stack
                    current = stack.pop();
                }
            }
        }
        countNode--;
        return value;
    }
}

