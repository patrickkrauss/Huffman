package br.furb.estruturas.arvores.ArvoreN_Aria;

public class Arvore<T> {

    private NoArvore<T> raiz;

    public Arvore() {
        raiz = null;
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }


    public boolean pertence(T info) {
        return buscar(info) != null;
    }

    @Override
    public String toString() {
        if (estaVazia())
            return "<>";
        return obterRepresentacaoTextual(raiz);
    }

    private String obterRepresentacaoTextual(NoArvore<T> no) {
        String conteudo = "<" + no.getInfo();
        NoArvore<T> p = no.getPrimeiro();

        while(p != null) {
            conteudo += obterRepresentacaoTextual(p);
            p = p.getProximo();
        }
        conteudo += ">";
        return conteudo;
    }


    public NoArvore<T> buscar(T info) {
        return buscar(raiz, info);
    }

    private NoArvore<T> buscar(NoArvore<T> no, T info) {
        if (no == null || no.getInfo().equals(info))
            return no;
        NoArvore<T> t = buscar(no.getPrimeiro(), info);
        if (t != null)
            return t;
        return buscar(no.getProximo(), info);
    }

    public int contarNos() {
        if (estaVazia())
            return 0;
        return contarNos(raiz);
    }

    private int contarNos(NoArvore<T> no) {
        if (no == null)
            return 0;
        else
            return 1 + contarNos(no.getPrimeiro()) + contarNos(no.getProximo());
    }

    public int contarNosFolhas() {
        return contarNos(raiz);
    }

    public boolean estaVazia() {
        return raiz == null;
    }


    private int contarNosFolhas(NoArvore<T> no) {
        if (no == null)
            return 0;
        else if (no.getPrimeiro() == null)
            return 1 + contarNosFolhas(no.getPrimeiro()) + contarNosFolhas(no.getProximo());
        return contarNosFolhas(no.getPrimeiro()) + contarNosFolhas(no.getProximo());
    }

}


