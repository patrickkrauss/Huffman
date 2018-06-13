package br.furb.estruturas.Filas.FilaLista;


import trabalho.estruturas_de_dados.Filas.Execoes.FilaVaziaException;
import trabalho.estruturas_de_dados.Filas.Fila;
import trabalho.estruturas_de_dados.Filas.FilaLista.ListaEncadeadaAdptadaParaFila.ListaEncadeada;

public class FilaLista<T> implements Fila<T> {

    private ListaEncadeada<T> lista;

    public FilaLista() {
        lista = new ListaEncadeada<>();
    }

    @Override
    public void inserir(T valor) {
        lista.inserirNoFinal(valor);
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public T peek() {
        if(estaVazia())
            throw new FilaVaziaException();
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public T retirar() {
        T removedItem = peek();
        lista.retirar(removedItem);
        return removedItem;
    }

    @Override
    public void liberar() {
        lista.liberar();
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}
