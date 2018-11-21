package com.soft.bst;

public class Main {

    public static void main(String[] arg){
        BST<Integer> bst = new BST<>();
        int[] data = new int[]{46,43,32,48,51,28,29,69,75,39,45,49,47};
        for (int d: data){
            bst.add(d);
        }
        //System.out.println(bst);
        bst.remove(48);

        System.out.println("----------------------------------------");
        //System.out.println(bst);

        BTreePrinter.printNode(bst.root);
    }
}
