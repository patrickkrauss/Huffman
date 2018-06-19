package br.furb;


import br.furb.estruturas.ListaEncadeada.Generica.ListaEncadeada;
import br.furb.estruturas.ListaEncadeada.Generica.NoLista;
import br.furb.estruturas.arvores.ArvoreBinaria.NoArvoreBinaria;
import br.furb.interfaces.IHuffmanChar;

import java.util.Comparator;

public class HuffmanUtils {

    public static  <T> void sort(ListaEncadeada<T> caracteres, Comparator<T> comparator) {
        /*NoLista<T> atual = caracteres.getPrimeiro();
        while (atual.getProximo() != null) {
            NoLista<T> proximo = atual.getProximo();
            if (comparator.compare(proximo.getInfo(), atual.getInfo()) > 0) {
                atual.setProximo(proximo.getProximo());
                proximo.setProximo(caracteres.getPrimeiro());
                caracteres.setPrimeiro(proximo);
            }
            atual = proximo;
        }*/

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
