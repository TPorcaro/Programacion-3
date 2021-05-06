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

    // El costo computacional es en el peor de los casos O(n),
    // siendo n la altura del arbol,
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
    
    // Tiene costo computacional de O(n) siendo n la cantidad de arboles,
    // necesita recorrer todas las posibilidades para saber cual es la mas larga
    public ArrayList<Integer> getLongestBranch() {
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

    // Tiene costo computacional O(n) siendo n la altura del arbol,
    // en este no hay peor ni mejor caso, siempre depende de la altura, ya que devuelve los del ultimo "nivel"
    public ArrayList<Integer> getFrontera() {
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


    public ArrayList<Integer> getElemAtLevel(int level) {
        return this.getElemAtLevel(level, 0);
    }

    // En el peor de los casos es de O(n) siendo n la altura del arbol,
    // puede que nos pidan el ultimo nivel
    private ArrayList<Integer> getElemAtLevel(int level, int actualLevel) { 
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

    // El costo computacional es de 0(n) siendo n la altura del arbol
    // no hay mejor ni peor caso ya que siempre va al arbol mas a la derecha
    public Integer getMaxElement() { 
        if (this.getRoot() == null) {
            return null;
        }
        if(this.derecha == null){
            return this.getRoot();
        }
        return this.derecha.getMaxElement();
    }

    // En el peor de los casos es O(n) siendo n la cantidad de arboles,
    // puede ser que este valor sea el mayor valor y se haya ingresado al ultimo
    public boolean hasElem(Integer value) {
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
    // Tiene como costo computacional O(n + n) n siendo la altura del arbol
    // en el peor de los casos debe de recorrer 2 veces, en el mejor de los casos solo recorre una vez la altura
    public boolean delete(Integer deleteValue) {
        if (this.getRoot() == deleteValue) { // Caso que la raiz sea el valor a borrar
            if (this.izquierda == null & this.derecha == null) { // arbol a borrar es hoja
                this.valor = null;
                return true;
            } else { // mi arbol a borrar no es hoja
                Integer nmi = null;
                if (this.izquierda != null) {
                    nmi = this.izquierda.getMaxElement();
                } else {
                    nmi = this.derecha.getNMI();
                }
                this.delete(nmi);
                this.valor = nmi;
                return true;
            }
        } else if (this.izquierda != null && this.izquierda.getRoot() == deleteValue) { // mi arbol a borrar sea el izquierdo y no es nulo
            if (this.izquierda.izquierda == null && this.izquierda.derecha == null) { // caso que mi arbol a borrar sea hoja
                this.izquierda = null;
                return true;
            } else { // Caso que mi valor a borrar tenga hijos
                if (this.izquierda.izquierda != null && this.izquierda.derecha == null) { // caso que mi valor a borrar solo tenga izquierda
                    this.izquierda = this.izquierda.izquierda;
                    this.izquierda.izquierda = null;
                    return true;
                } else if (this.izquierda.izquierda == null && this.izquierda.derecha != null) { // caso que mi valor a borrar solo tenga derecha
                    this.izquierda = this.izquierda.derecha;
                    this.izquierda.derecha = null;
                    return true;
                } else { // caso de que mi valor a borrar tenga 2 hijos
                    Integer nmi = this.izquierda.derecha.getNMI();
                    this.delete(nmi);
                    this.izquierda.valor = nmi;
                    return true;
                }
            }
        } else if (this.derecha != null && this.derecha.getRoot() == deleteValue) {
            if (this.derecha.izquierda == null && this.derecha.derecha == null) {
                this.derecha = null;
                return true;
            } else { // Caso que mi valor a borrar tenga hijos
                if (this.derecha.izquierda != null && this.derecha.derecha == null) { // caso que mi valor a borrar solo tenga izquierda
                    this.derecha = this.derecha.izquierda;
                    this.derecha.izquierda = null;
                    return true;
                } else if (this.derecha.izquierda == null && this.derecha.derecha != null) { // caso que mi valor a  borrar solo tenga derecha
                    this.derecha = this.derecha.derecha;
                    this.derecha.derecha = null;
                    return true;
                } else { // caso de que mi valor a borrar tenga 2 hijos
                    Integer nmi = this.derecha.derecha.getNMI();
                    this.delete(nmi);
                    this.derecha.valor = nmi;
                    return true;
                }
            }
        } else { // recursion para encontrar un paso antes a mi valor a borrar
            boolean isDeleted = false;
            if (this.getRoot() > deleteValue && this.izquierda != null) {
                isDeleted = this.izquierda.delete(deleteValue);
            } else if (this.getRoot() < deleteValue && this.derecha != null) {
                isDeleted = this.derecha.delete(deleteValue);
            }
            return isDeleted; // en el caso que no exista retorna false
        }
    }

    // El costo computacional es la altura del arbol,
    // voy siempre a la izquierda hasta encontrar un arbol frontera
    private Integer getNMI() {
        if (this.izquierda == null) {
            return this.getRoot();
        } else {
            return this.izquierda.getNMI();
        }
    }
    
    //Costo computacional O(n) siendo n la cantidad de valores de mi arbol,
    // en mi caso cantidad de arboles.
    public void printPreOrder() {
        if (this.getRoot() == null) {
            return;
        }
        if (this.izquierda == null) {
            System.out.print('-');
        }
        System.out.print(this.getRoot());
        if (this.derecha == null) {
            System.out.print('-');
        }
        System.out.print(' ');
        if(this.izquierda != null)
            this.izquierda.printPreOrder();
        if(this.derecha != null)
            this.derecha.printPreOrder();
    }
    
    // Costo computacional O(n) siendo n la cantidad de valores de mi arbol,
    // en mi caso cantidad de arboles.
    public void printInOrder() { 
        if (this.getRoot() == null) {
            return;
        }
        if (this.izquierda != null)
        this.izquierda.printPreOrder();
        System.out.print(this.getRoot() + " ");
        if (this.derecha != null)
        this.derecha.printPreOrder();
    }
    //Costo computacional O(n) siendo n la cantidad de valores de mi arbol,
    // en mi caso cantidad de arboles.
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

    // El costo computacional O(1) es constante en todos los casos
    public boolean isEmpty() {
        return this.valor == null;
    }

}