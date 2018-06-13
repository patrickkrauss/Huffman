package br.furb.estruturas.Filas.Execoes;

public class FilaVaziaException extends RuntimeException {

    public FilaVaziaException() {
        super("A fila esta vazia");
    }
}
