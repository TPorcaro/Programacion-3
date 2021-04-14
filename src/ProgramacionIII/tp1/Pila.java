package ProgramacionIII.tp1;

public class Pila {
    
    public MySimpleLinkedList elems;
    
    public Pila() {
        this.elems= new MySimpleLinkedList();
    }

    public void push(Integer o){
        this.elems.insertFront(o);
    }
    public Integer pop(){
        return this.elems.extractFront();
    }
    public Integer top(){
        Integer tmp = this.elems.extractFront();
        this.elems.insertFront(tmp);
        return tmp;
    }
    public void reverse(){
        MySimpleLinkedList reverseElems = new MySimpleLinkedList();
        for (Integer intElements : reverseElems) {
            reverseElems.insertFront(intElements);
        }
        this.elems = reverseElems;
    }
}
