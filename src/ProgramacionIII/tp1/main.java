package ProgramacionIII.tp1;

import java.util.Iterator;

public class main {
    

    public static void main(String[] args) {
        MySimpleLinkedList intElements = new MySimpleLinkedList();
        Pila pilaInteger = new Pila();
        intElements.insertFront(11);
        intElements.insertFront(0);
        intElements.insertFront(2);
        intElements.insertFront(8);
        intElements.insertFront(7);
        intElements.insertFront(5);
        intElements.insertFront(2);
        intElements.insertFront(3);
        intElements.subSequenceByValue(10).printAll();;
        // pilaInteger.push(1);
        // pilaInteger.push(2);
        // pilaInteger.push(3);
        // pilaInteger.push(4);
        // pilaInteger.reverse();
        // System.out.println("Reversed");
    }
    
}
