package ProgramacionIII.tp2;
public class main {
    
    public static void main(String[] args) {
        int[] valoresIniciales = new int[] { 15, 4, 1, 25, 50, 6, 7, 20, 5, 30 };
        Tree miArbol = new Tree(valoresIniciales);

        System.out.println("Pre order");
        miArbol.printPreOrder();
        System.out.println("");
        System.out.println("MaxElement");
        System.out.println(miArbol.getMaxElement());
        System.out.println("getHeight");
        System.out.println(miArbol.getHeight());
        System.out.println("getLongestBranch");
        System.out.println(miArbol.getLongestBranch());
        System.out.println("getElemAtLevel(2)");
        System.out.println(miArbol.getElemAtLevel(2));
        System.out.println("getFrontera");
        System.out.println(miArbol.getFrontera());
        System.out.println("--------------");
        miArbol.add(23);
        miArbol.add(3);
        miArbol.delete(6);
        miArbol.delete(30);

        System.out.println("Pre order");
        miArbol.printPreOrder();
        System.out.println("");
        System.out.println("MaxElement");
        System.out.println(miArbol.getMaxElement());
        System.out.println("getHeight");
        System.out.println(miArbol.getHeight());
        System.out.println("getLongestBranch");
        System.out.println(miArbol.getLongestBranch());
        System.out.println("getElemAtLevel(2)");
        System.out.println(miArbol.getElemAtLevel(2));
        System.out.println("getFrontera");
        System.out.println(miArbol.getFrontera());
        System.out.println("--------------");

        miArbol.add(65);
        miArbol.delete(5);
        miArbol.delete(15);
        miArbol.add(55);

        System.out.println("Pre order");
        miArbol.printPreOrder();
        System.out.println("");
        System.out.println("MaxElement");
        System.out.println(miArbol.getMaxElement());
        System.out.println("getHeight");
        System.out.println(miArbol.getHeight());
        System.out.println("getLongestBranch");
        System.out.println(miArbol.getLongestBranch());
        System.out.println("getElemAtLevel(2)");
        System.out.println(miArbol.getElemAtLevel(2));
        System.out.println("getFrontera");
        System.out.println(miArbol.getFrontera());

    }
}
