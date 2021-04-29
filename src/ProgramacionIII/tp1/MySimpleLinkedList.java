package ProgramacionIII.tp1;

import java.util.Iterator;
public class MySimpleLinkedList implements Iterable<Integer>{
	
	protected Node first;
	protected int size;
	protected Node last;
	public MySimpleLinkedList() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}

	
	public void insertFront(Integer o) {
		// O(1 es constante)
		Node tmp = new Node(o,null);
		if(this.size == 0){
			this.last = tmp;
		}
		tmp.setNext(this.first);
		this.first = tmp;
		this.size++;
	}
	
	public Integer extractFront() {
		// O(1 es constante)
		if(this.first != null){
			Integer firstValue = this.first.getInfo();
			this.first = this.first.getNext();
			if(this.size == 1){
				this.last = null;
			}
			this.size--;
			return firstValue;
		}
		return null;
	}
	public void insertBack(Integer o){
		// O(1 es constante)
		Node tmp = new Node(o, null);
		if(this.size == 0){
			this.first = tmp;
		}
		if(this.last != null){
			this.last.setNext(tmp);
		}
		this.last = tmp;
		this.size++;
	}

	public boolean isEmpty() {
		// O(1 es constante)
		return this.first == null;
	}

	public int size() {
		// O(n con n siendo la cantidad de elementos)... Size ineficiente, usar atributo size con costo O(1)
		int counter = 0;
		Node tempElem = this.first;
		while(tempElem != null){
			counter++;
			tempElem = tempElem.getNext();
		}
		return counter;
	}
	public int sizeLessExpensive() {
		// O(1 es constante)
		return this.size;
	}
	public void print(int n){
		// O(n con n siendo la cantidad de elementos)
		System.out.println(this.get(n));
	}
	
	public Integer get(int index) {
		// O(n con n siendo la cantidad de elementos)
		if(index > -1 && index < this.size){
			Node desiredNode= this.first;
			for (int i = 0; i < index; i++) {
				desiredNode = desiredNode.getNext();
			}
			return desiredNode.getInfo();
		}
		return null;
	}
	
	public Integer indexOf(Integer info){
		// O(n con n siendo la cantidad de elementos, en el peor de los casos)
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
		// O(1 es constante)
		return new MyIterator(this.first);
	}

	public MySimpleLinkedList mergeCommonA(MySimpleLinkedList newList){
		// Ejercicio 6 a O(n^2 con n siendo la cantidad de elementos)
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
	public MySimpleLinkedList mergeCommonB(MySimpleLinkedList newList){
		// Ejercicio 6 b O(n^2 con n siendo la cantidad de elementos)
		MySimpleLinkedList returnList = new MySimpleLinkedList();
		for (Integer myValue : this) {
			if(newList.searchValue(myValue)){
				returnList.insertFront(myValue);
			}
		}
		return returnList;
	}
	public boolean searchValue(Integer o){
		// O(n con n siendo la cantidad de elementos)
		for (Integer i : this) {
			if(i > o){
				return false;
			}else if (i == o){
				return true;
			}
		}
		return false;
	}

	public MySimpleLinkedList firstMinusSecond(MySimpleLinkedList secondList){
		// Ejercicio 7 O(n^2 con n siendo la cantidad de elementos) Incompleto se debe encargar la lista? falta mejorar en el mejor de los casos
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
		return returnList.reverseList();
	}

	public MySimpleLinkedList reverseList(){
		// O(n con n siendo la cantidad de elementos)
		MySimpleLinkedList returnList = new MySimpleLinkedList();
		for (Integer o : this) {
			returnList.insertFront(o);
		}
		return returnList;
	}
	public void printAll(){
		MyIterator iterator = (MyIterator) this.iterator();
		// O(n con n siendo la cantidad de elementos)
		while(iterator.hasNext()){
			System.out.println(iterator.next());	
		}
	}
}
