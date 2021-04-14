package ProgramacionIII.tp1;

import java.util.Iterator;
public class MySimpleLinkedList implements Iterable<Integer>{
	
	protected Node first;
	protected int size;

	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}

	
	public void insertFront(Integer o) {
		// O(1) || en array es O(n)
		Node tmp = new Node(o,null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size++;
	}
	
	public Integer extractFront() {
		if(this.first != null){
			Integer firstValue = this.first.getInfo();
			this.first = this.first.getNext();
			this.size--;
			return firstValue;
		}
		return null;
	}

	public boolean isEmpty() {
		return this.first == null;
	}

	public int size() {
		// O(n = cantidad elem)
		int counter = 0;
		Node tempElem = this.first;
		while(tempElem != null){
			counter++;
			tempElem = tempElem.getNext();
		}
		return counter;
	}
	public int sizeLessExpensive() {
		return this.size();
	}
	public void print(){
		MyIterator iterator = new MyIterator(this.first);
		System.out.println(iterator.get());
	}
	
	public Integer get(int index) {
		if(index > -1 && index < this.size()){
			// O(n = cantidad de elementos) || en array es O(1)
			Node desiredNode= this.first;
			for (int i = 0; i < index; i++) {
				desiredNode = desiredNode.getNext();
			}
			return desiredNode.getInfo();
		}
		return null;
	}
	
	public Integer indexOf(Integer info){
		Node tmp = this.first;
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
		return new MyIterator(this.first);
	}

	public MySimpleLinkedList mergeCommonA(MySimpleLinkedList newList){
		// Ejercicio 6 a
		MySimpleLinkedList returnList = new MySimpleLinkedList();
		for (Integer myValue : this) {
			for (Integer newListValue : newList) {
				if(myValue == newListValue){
					returnList.insertFront(newListValue);                               
				}
			}
		}
		return returnList;
	}
	public MySimpleLinkedList mergeCommonB(MySimpleLinkedList newList){ // solo si las 2 listas estan ordenadas, implementar metodo de ordenamiento con costo O(n) o O(n.log.n)
		// Ejercicio 6 b
		MySimpleLinkedList returnList = new MySimpleLinkedList();
		for (Integer myValue : this) {
			if(searchValue(myValue, newList)){
				returnList.insertFront(myValue);
			}
		}
		return returnList;
	}
	public boolean searchValue(Integer o, MySimpleLinkedList list){
		for (Integer i : list) {
			if(i > o){
				return false;
			}else if (i == o){
				return true;
			}
		}
		return false;
	}

	public MySimpleLinkedList firstMinusSecond(MySimpleLinkedList secondList){
		// Ejercicio 7
		MySimpleLinkedList returnList = new MySimpleLinkedList();
		boolean isNotInSecond = true;
		for (Integer myValue : this) {
			isNotInSecond = true;
			for (Integer secondValue : secondList) {
				if(myValue == secondValue){
					isNotInSecond = false;
				}
			}
			if(isNotInSecond){
				returnList.insertFront(myValue);
			}
		}
		MySimpleLinkedList.reverseList(returnList);
		return returnList;
	}

	public static MySimpleLinkedList reverseList(MySimpleLinkedList newList){
		MySimpleLinkedList returnList = new MySimpleLinkedList();

		for (Integer o : newList) {
			returnList.insertFront(o);
		}
		return returnList;
	}
	public MySimpleLinkedList subSequenceByValue(Integer threshold){ // Ejercicio entregable
		MySimpleLinkedList returnList = new MySimpleLinkedList();
		MyIterator iterator = (MyIterator) this.iterator();
		Integer maxValue = 0;
		while(iterator.hasNext()){
			if(iterator.get() > threshold){
				returnList.insertFront(maxValue);
				iterator.move();
			}else{
				if(maxValue + iterator.get() > threshold){
					returnList.insertFront(maxValue);
					maxValue = 0;
				}else{
					maxValue += iterator.get();
					iterator.move();
				}
			}
		}
		return returnList;
	}
	public void printAll(){
		MyIterator iterator = (MyIterator) this.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());	
		}
	}
}
