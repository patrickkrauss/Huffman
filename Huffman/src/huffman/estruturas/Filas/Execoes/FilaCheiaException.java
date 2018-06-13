package br.furb.estruturas.Filas.Execoes;

public class FilaCheiaException extends RuntimeException {

    public FilaCheiaException(){
        super("A fila esta cheia");
    }
}
