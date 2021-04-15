package ProgramacionIII.tp1;

import java.util.Iterator;

public class main {
    

    public static void main(String[] args) {
        MySimpleLinkedList intElements = new MySimpleLinkedList();
        intElements.insertFront(-1);
        intElements.insertFront(-1);
        intElements.insertFront(-1);
        intElements.insertFront(4);
        intElements.insertFront(-1);
        intElements.insertFront(0);
        intElements.insertFront(-1);
        intElements.insertFront(-1);
        // intElements2.mergeCommonA(intElements).printAll();
        intElements.subSequenceByValue(5).printAll();;
        // pilaInteger.push(1);
        // pilaInteger.push(2);
        // pilaInteger.push(3);
        // pilaInteger.push(4);
        // pilaInteger.reverse();
        // System.out.println("Reversed");
    }
    
}
