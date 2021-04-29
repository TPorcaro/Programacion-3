package ProgramacionIII.tp1;

import java.util.Iterator;

public class MyIterator implements Iterator<Integer>{

    protected Node cursor;
    public MyIterator(Node node){
        this.cursor = node;
    }
    public Integer get(){
        return cursor.getInfo();
    }
    public void move(){
        this.cursor = cursor.getNext();
    }
    @Override
    public boolean hasNext() {
        return cursor != null;
    }
    @Override
    public Integer next() {
        Integer value = cursor.getInfo();
        cursor = cursor.getNext();
        return value;
    }
}
