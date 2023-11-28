public class Main {
    public static void main(String [] args){
        BinarySearchTree bruh = new BinarySearchTree();
        bruh.add(5);
        bruh.add(10);
        bruh.add(3);
        bruh.add(8);
        bruh.add(2);
        bruh.add(9);
        printPreorder(bruh);
    }
}
