package ProgramacionIII.tp2;

import java.util.ArrayList;

public class Tree {

    private Integer valor;
    private Tree izquierda;
    private Tree derecha;

    public Tree(Integer valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }

    public Tree(int[] newTree) {
        this.valor = newTree[0];
        for (int i = 1; i < newTree.length; i++) {
            this.add(newTree[i]);
        }
    }

    public Tree getIzquierda() {
        return this.izquierda;
    }
    public Tree getDerecha() {
        return this.derecha;
    }

    public void add(int newValue) {
        if (this.valor == null) {
            this.setValor(newValue);
        } else {
            if (newValue < this.valor) {
                if (this.izquierda == null)
                    this.izquierda = new Tree(newValue);
                else
                    this.izquierda.add(newValue);
            } else {
                if (this.derecha == null)
                    this.derecha = new Tree(newValue);
                else
                    this.derecha.add(newValue);
            }
        }
    }

    public void setValor(Integer value) {
        this.valor = value;
    }

    public ArrayList<Integer> getLongestBranch() { // Tiene costo computacional de O(n) siendo n la cantidad de arboles
        ArrayList<Integer> longestBranch = new ArrayList<Integer>();
        if (this.izquierda == null && this.derecha == null) {
            longestBranch.add(this.getRoot());
        } else {
            ArrayList<Integer> izquierda = new ArrayList<Integer>();
            ArrayList<Integer> derecha = new ArrayList<Integer>();
            if (this.izquierda != null) {
                izquierda.addAll(this.izquierda.getLongestBranch());
            }
            if (this.derecha != null) {
                derecha.addAll(this.derecha.getLongestBranch());
            }
            longestBranch.add(this.getRoot());
            if (izquierda.size() < derecha.size()) {
                longestBranch.addAll(derecha);
            } else {
                longestBranch.addAll(izquierda);
            }
        }
        return longestBranch;
    }

    public ArrayList<Integer> getFrontera() { // Tiene costo computacional O(n) siendo n la cantidad de arboles.
        ArrayList<Integer> frontera = new ArrayList<Integer>();
        if (this.izquierda == null && this.derecha == null) {
            frontera.add(this.getRoot());
        } else {
            if (this.izquierda != null) {
                frontera.addAll(this.izquierda.getFrontera());
            }
            if (this.derecha != null) {
                frontera.addAll(this.derecha.getFrontera());
            }
        }
        return frontera;
    }


    public ArrayList<Integer> getElemAtLevel(int level , int actualLevel) { // En el peor de los casos es de O(n) siendo n la cantidad de arboles, puede que nos hagan ir hasta la altura maxima
        ArrayList<Integer> elemsAtLevel = new ArrayList<Integer>();

        if (actualLevel == level) {
            elemsAtLevel.add(this.getRoot());
        } else {
            actualLevel++;
            if (this.izquierda != null) {
                elemsAtLevel.addAll(this.izquierda.getElemAtLevel(level, actualLevel));
            }
            if (this.derecha != null) {
                elemsAtLevel.addAll(this.derecha.getElemAtLevel(level, actualLevel));
            }
        }
        return elemsAtLevel;
    }

    public Integer getMaxElement() { // El costo computacional es de 0(n) siendo n la cantidad de arboles que haya entre la raiz y el arbol mas hacia la derecha (incluidos)
        if (this.getRoot() == null) {
            return null;
        }
        if(this.derecha == null){
            return this.getRoot();
        }
        return this.derecha.getMaxElement();
    }
    public boolean hasElem(Integer value) { // En el peor de los casos es O(n) siendo n la cantidad de arboles, puede ser que este en el ultimo nivel
        if (value == this.valor) {
            return true;
        } else {
            if (this.izquierda != null && value < this.valor) {
                return this.izquierda.hasElem(value);
            } else if (this.derecha != null && value > this.valor) {
                return this.derecha.hasElem(value);
            }
            return false;
        }
    }
    
    public void printPreOrder() {
        if (this.getRoot() == null) {
            return;
        }
        System.out.print(this.getRoot() + " ");
        if(this.izquierda != null)
            this.izquierda.printPreOrder();
        if(this.derecha != null)
            this.derecha.printPreOrder();
            if(this.izquierda == null && this.derecha == null)
                System.out.print("- ");
    }
    
    public void printInOrder() { // los 3 tienen costo computacional O(n) recorre una vez por "nodo" en mi caso por arbol
        if (this.getRoot() == null) {
            return;
        }
        if (this.izquierda != null)
        this.izquierda.printPreOrder();
        System.out.print(this.getRoot() + " ");
        if (this.derecha != null)
        this.derecha.printPreOrder();
    }
    
    public void printPostOrder() {
        if (this.getRoot() == null) {
            return;
        }
        if (this.izquierda != null)
        this.izquierda.printPreOrder();
        if (this.derecha != null)
        this.derecha.printPreOrder();
        System.out.print(this.getRoot() + " ");
    }
    
    public Integer getRoot() {
        return this.valor;
    }

    // Complejidad O(n) donde n es la cantidad de valores del arbol
    public int getHeight() {
        if (this.izquierda == null && this.derecha == null) { // Si soy una hoja
            return 0; // Soy chato, tengo altura 0
        } else {
            // Si tengo al menos un hijo
            int alturaIzq = 0;
            int alturaDer = 0;

            if (this.izquierda != null)
                alturaIzq = 1 + this.izquierda.getHeight();

            if (this.derecha != null)
                alturaDer = 1 + this.derecha.getHeight();

            int mayor = Math.max(alturaIzq, alturaDer);

            return mayor;
        }
    }

    public boolean isEmpty() {
        return this.valor == null;
    }

}