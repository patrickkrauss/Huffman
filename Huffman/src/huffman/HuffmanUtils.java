package huffman;


import huffman.estruturas.ListaEncadeada.Generica.ListaEncadeada;
import huffman.estruturas.ListaEncadeada.Generica.NoLista;

import java.util.Comparator;

public class HuffmanUtils {

    public static  <T> void sort(ListaEncadeada<T> caracteres, Comparator<T> comparator) {
        int size = caracteres.obterComprimento();
        if (size > 1) {
            for (int i = 0; i < size; i++ ) {
                NoLista<T> currentNode = caracteres.getPrimeiro();
                NoLista<T> next = currentNode.getProximo();
                for (int j = 0; j < size - 1; j++) {
                    if (comparator.compare(currentNode.getInfo(), next.getInfo()) < 0) {
                        T currentValue = currentNode.getInfo();
                        currentNode.setInfo(next.getInfo());
                        next.setInfo(currentValue);
                    }
                    currentNode = next;
                    next = next.getProximo();
                }
            }
        }
    }

}
