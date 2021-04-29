package ProgramacionIII.tp1;

public class main {
    

    public static void main(String[] args) {
        MySimpleLinkedList intElements = new MySimpleLinkedList();
        System.out.println("Lista de entrada = [] Valor umbral: 10");
        subSequenceByValue(intElements, 10).printAll();;
        System.out.println("-------------------");
        intElements = new MySimpleLinkedList();
        intElements.insertBack(1);
        intElements.insertBack(2);
        intElements.insertBack(3);
        System.out.println("Lista de entrada = [1, 2, 3] Valor umbral: 10");
        subSequenceByValue(intElements, 10).printAll();;
        System.out.println("-------------------");
        intElements = new MySimpleLinkedList();
        intElements.insertBack(1);
        intElements.insertBack(2);
        intElements.insertBack(3);
        System.out.println("Lista de entrada = [1, 2, 3] Valor umbral: 2");
        subSequenceByValue(intElements, 2).printAll();;
        System.out.println("-------------------");
        intElements = new MySimpleLinkedList();
        intElements.insertBack(3);
        intElements.insertBack(5);
        intElements.insertBack(2);
        intElements.insertBack(7);
        intElements.insertBack(19);
        intElements.insertBack(14);
        intElements.insertBack(28);
        System.out.println("Lista de entrada = [3, 5, 2, 7, 19, 14, 28] Valor umbral: 10");
        subSequenceByValue(intElements, 10).printAll();;
        System.out.println("-------------------");
        intElements = new MySimpleLinkedList();
        intElements.insertBack(3);
        intElements.insertBack(5);
        intElements.insertBack(4);
        intElements.insertBack(2);
        intElements.insertBack(7);
        intElements.insertBack(15);
        intElements.insertBack(14);
        intElements.insertBack(28);
        System.out.println("Lista de entrada = [3, 5, 4, 2, 7, 15, 14, 28] Valor umbral: 15");
        subSequenceByValue(intElements, 15).printAll();;
        System.out.println("-------------------");
        
    }

    private static MySimpleLinkedList subSequenceByValue(MySimpleLinkedList newList, Integer threshold){
        MySimpleLinkedList returnList = new MySimpleLinkedList(); // Costo computacional es O(n con n siendo el size de la lista)
		MyIterator iterator = (MyIterator) newList.iterator();
		Integer value = 0;
		boolean valueHasRealValue = false;
		while(iterator.hasNext()){			
			if(value + iterator.get() > threshold){
				if(valueHasRealValue && value <= threshold){
					returnList.insertBack(value);
					value = 0;
					valueHasRealValue = false;
				}else{
					iterator.move();
				}	
			}else{
				value += iterator.get();
				valueHasRealValue = true;
				iterator.move();
			}
		}
		if(valueHasRealValue && value <= threshold){
			returnList.insertBack(value);
		}
		return returnList;
    }
    
}
