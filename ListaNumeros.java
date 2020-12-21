import java.util.Arrays;
/**
 * La clase representa a una lista de 
 * números enteros
 * 
 * @author - David Sena 
 * 
 */

public class ListaNumeros 
{
    private int[] lista;
    private int pos;

    /**
     * Constructor de la clase ListaNumeros 
     * Crea e inicializa adecuadamente los
     * atributos
     * 
     * @param n el tamaño máximo de la lista
     */
    public ListaNumeros(int n) {
        lista = new int[n];
        pos = 0;
    }

    /**
     * Añade un valor siempre al principio de la lista
     * 
     * @param numero el valor que se añade. No se hace nada si la lista está
     *               completa
     * @return true si se ha podido añadir, false en otro caso
     */
    public boolean addElemento(int numero) {
        boolean añadido = false;

        if(!estaCompleta()){
            System.arraycopy(lista, 0, lista, 1, pos );
            lista[0] = numero;
            pos++;
            añadido = true;
        }

        return añadido;
    }

    /**
     * devuelve true si la lista está completa, false en otro caso
     * Hacer sin if
     */
    public boolean estaCompleta() {
        return pos == lista.length;

    }

    /**
     * devuelve true si la lista está vacía, false en otro caso. 
     * Hacer sin if
     */
    public boolean estaVacia() {
        return pos == 0;
    }

    /**
     * devuelve el nº de elementos realmente guardados en la lista
     */
    public int getTotalNumeros() {
        return pos;

    }

    /**
     * Vacía la lista
     */
    public void vaciarLista() {
        pos = 0;
    }

    /**
     * Representación textual de la lista de la forma indicada 
     * (leer enunciado)
     * 
     * Si la lista está vacía devuelve ""
     */
    public String toString() {
        String texto = "";
        if(!estaVacia()){
            for(int i = 0; i < pos; i++){
                texto += String.format("%8d",lista[i]);               
            }
            texto += "\n";
            for(int i = 0; i < pos; i++){
                texto += String.format("%8d",i);
            }
        }
        return texto;
    }

    /**
     * Mostrar en pantalla la lista
     */
    public void escribirLista() {
        System.out.println(this.toString());
    }

    /**
     * Búsqueda lineal de numero en la lista
     * @param numero el nº a buscar
     * @return un array con las posiciones en las que se ha encontrado
     *  
     */
    public int[] buscarPosicionesDe(int numero) {
        int[] posiciones = new int[pos];
        int posPosicion = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == numero) {
                posiciones[posPosicion]=i;
                posPosicion++;
            }
        }
        return posiciones;

    }

    /**
     * Hace una búsqueda binaria del numero indicado devolviendo -1 si no se
     * encuentra o la posición en la que aparece
     * 
     * El array original lista no se modifica 
     * Para ello crea previamente una copia
     * de lista y trabaja con la copia
     * 
     * Usa exclusivamente métodos de la clase Arrays
     * 
     */
    public int buscarBinario(int numero) {
        int[] copia = new int[lista.length];
        System.arraycopy(lista, 0,copia, 0, pos);
        Arrays.sort(copia);
        int index = Arrays.binarySearch(copia, numero);
        if(index < 0){
            return -1;
        }   
        return index;
    }

    /**
     * borra el primer elemento de la lista
     */
    public void borrarPrimero() {        
        if(pos != 0 ){
            System.arraycopy(lista, 1,lista, 0, pos - 1);
            pos--;
        }
    }

    /**
     *  Invierte cada uno de los grupos de n elementos que hay en lista
     *  
     *  Si el nº de elementos en lista no es divisible entre n los elementos restantes 
     *  quedan igual
     *  
     *  (leer enunciado)
     *  
     */
    public void invertir(int n) {
        int[] inversion = new int[pos];
        int posinver = 0;
        for (int i = n; i <= pos; i++) {
            for (int j=i; j>=i ;j--) {
                inversion[posinver]=i;
                posinver++;
            }
        }
        System.arraycopy(inversion, 0, lista, 0, posinver);

    }

    /**
     * devuelve un ragged array de 2 dimensiones con tantas filas como valores
     * tenga el atributo lista y rellena el array de la forma indicada
     * (leer enunciado)
     * 
     */
    public int[][] toArray2D() {
        //for (int fila = 0; fila < lista.length; fila++) {
        //    for (int columna = 0; columna >= lista[fila].length; columna++) {
        //        lista[fila][columna] = 1;
         //   }
        //}
        return null;
    }

    /**
     * Punto de entrada a la aplicación 
     * Contiene código para probar los métodos de ListaNumeros
     */
    public static void main(String[] args) {
        ListaNumeros lista = new ListaNumeros(20);

        System.out.println("--- addElemento() y toString() -------");
        int[] valores = {21, -5, 6, -7, 21, -17, 21, 15, 22, 21, 77};
        for (int i = 0; i < valores.length; i++) {
            lista.addElemento(valores[i]);
        }
        System.out.println(lista.toString());

        System.out.println("--- buscarPosiciones() -------");
        int numero = 21;
        System.out.println(lista.toString());
        System.out.println("\t" + numero + " aparece en posiciones ");
        // seguir completando

    }
}
