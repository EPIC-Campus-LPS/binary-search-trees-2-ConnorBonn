import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(4);
        tree.add(2);
        tree.add(1);
        tree.add(3);
        tree.add(6);
        tree.add(5);
        tree.add(7);
        tree.delete(4);
        tree.printPreorder();
    }
}
