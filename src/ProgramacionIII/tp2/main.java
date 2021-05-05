package ProgramacionIII.tp2;
public class main {
    
    public static void main(String[] args) {
        int[] arr = { 6,3,7,9,1,5,4};
        Tree arbol = new Tree(arr);

        // arbol.add(5);
        // arbol.add(6);
        // arbol.add(7);
        // arbol.add(15);
        // arbol.add(1);
        arbol.delete(7);
        arbol.printPreOrder();
        
    }
}
