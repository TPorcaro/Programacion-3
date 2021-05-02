package ProgramacionIII.tp2;

import java.util.ArrayList;

public class main {
    
    public static void main(String[] args) {
        // int[] arr = { 4, 5, 6, 7, 15, 1 };
        Tree arbol = new Tree(4);

        arbol.add(5);
        arbol.add(6);
        arbol.add(7);
        arbol.add(15);
        arbol.add(1);

        ArrayList<Integer> list = arbol.getLongestBranch();
        for (Integer i : list) {
            System.out.println(i);
        }
        
    }
}
