package huffman;


import huffman.estruturas.ListaEncadeada.Generica.ListaEncadeada;
import huffman.estruturas.ListaEncadeada.Generica.NoLista;
import huffman.estruturas.arvores.ArvoreBinaria.NoArvoreBinaria;
import huffman.interfaces.IHuffmanChar;

import java.util.Comparator;

public class HuffmanUtils {

    public static <T> void sort(ListaEncadeada<T> caracteres, Comparator<T> comparator) {
        NoLista<T> atual = caracteres.getPrimeiro();
        while (atual.getProximo() != null) {
            NoLista<T> proximo = atual.getProximo();
            if (comparator.compare(proximo.getInfo(), atual.getInfo()) > 0) {
                atual.setProximo(proximo.getProximo());
                proximo.setProximo(caracteres.getPrimeiro());
                caracteres.setPrimeiro(proximo);
            }
            atual = proximo;
        }
    }

}
