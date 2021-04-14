package ProgramacionIII.tp1;

import java.util.Iterator;

public class MyDoubleLinkedList implements Iterable<Integer> {
    protected DoubleNode first;
    protected DoubleNode last;
    protected int size;

    public MyDoubleLinkedList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public void insertFront(Integer o){
        DoubleNode node = new DoubleNode(o, null, null);
        node.setNext(this.first);
        this.first.setPrevious(node);
        this.first = node;
        this.size++;
    }

    public Integer extractFront(){
        if(this.first == null){
            Integer firstValue = this.first.getInfo();
            this.first = this.first.getNext();
            this.first.setPrevious(null);
            this.size--;
            return firstValue;
        }
        return null;
    }
    public boolean isEmpty(){
        return this.first == null;
    }
    public int size(){
        int counter = 0;
        DoubleNode tempNode = this.first;
        while (tempNode != null) {
            counter++;
            tempNode = tempNode.getNext();
        }
        return counter;
    }
    public int sizeLessExpensive() {
		return this.size();
	}
    public Integer get(int index){
        if(index > -1 && index < this.size()){
			// O(n = cantidad de elementos) || en array es O(1)
			DoubleNode desiredNode = this.first;
			for (int i = 0; i < index; i++) {
				desiredNode = desiredNode.getNext();
			}
			return desiredNode.getInfo();
		}
		return null;
    }
    public void print(int n){
		System.out.println(this.get(n));
	}
    public Integer indexOf(Integer info){
		DoubleNode tmp = this.first;
		Integer index = 0;
		while(tmp != null){
			if(tmp.getInfo()==info){
				return index;
			}
			index++;
			tmp= tmp.getNext();
		}
		return -1;
	}

    @Override
    public Iterator<Integer> iterator() {
        return new MyDoubleIterator(this.first);
    }
    public Iterator<Integer> reverseIterator() {
        return new MyDoubleIterator(this.last);
    }
}
