package ProgramacionIII.tp1;

import java.util.Iterator;

public class MyDoubleIterator implements Iterator<Integer>{

    DoubleNode cursor;
    public MyDoubleIterator(DoubleNode cursor){
        this.cursor = cursor;
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
    public Integer previous(){
        Integer value = cursor.getInfo();
        cursor = cursor.getPrevious();
        return value;
    }
    public boolean hasPrevious() {
        return cursor != null;
    }
    public Integer get(){return cursor.getInfo();}
    public void moveNext(){cursor = cursor.getNext();}
    public void movePrevious(){cursor = cursor.getPrevious();}
    
}
