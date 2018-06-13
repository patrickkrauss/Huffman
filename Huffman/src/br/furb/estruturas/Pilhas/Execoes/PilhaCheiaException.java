package br.furb.estruturas.Pilhas.Execoes;

public class PilhaCheiaException extends RuntimeException {

    public PilhaCheiaException(){
        super("A pilha esta cheia");
    }
}
