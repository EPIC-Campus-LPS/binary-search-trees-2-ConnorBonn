public class Main {
    public static void main(String [] args){
        BinarySearchTree tree = new BinarySearchTree();

        System.out.println(tree.contains(10));
        System.out.println(tree.countNodes());
        System.out.println(tree.countLeafNodes());
    }
}
