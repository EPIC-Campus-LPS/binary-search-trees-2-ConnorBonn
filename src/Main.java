public class Main {
    public static void main(String [] args){
        BinarySearchTree bruh = new BinarySearchTree();
        bruh.add(5);
        bruh.add(10);
        bruh.add(3);
        bruh.add(8);
        bruh.add(2);
        bruh.add(9);
        bruh.add(7);
        bruh.add(5);
        bruh.add(4);
        bruh.add(1);
        bruh.add(6);
        bruh.printPreorder();
        System.out.println(bruh.countNodes());
        System.out.println(bruh.countLeafNodes());
    }
}
