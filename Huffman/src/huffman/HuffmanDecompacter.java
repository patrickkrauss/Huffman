package br.furb;

import br.furb.estruturas.ListaEncadeada.Generica.ListaEncadeada;
import br.furb.estruturas.ListaEncadeada.Generica.NoLista;
import br.furb.estruturas.arvores.ArvoreBinaria.ArvoreBinaria;
import br.furb.estruturas.arvores.ArvoreBinaria.NoArvoreBinaria;
import br.furb.interfaces.IHuffmanChar;
import br.furb.interfaces.TextFile;

public class HuffmanDecompacter {

    private ArvoreBinaria<IHuffmanChar> arvore;
    private StringBuilder sb = new StringBuilder();

    private HuffmanDecompacter(String text) {
        if (text != null && !text.equals("")) {
            creatTree(extractTable(text));
            decompact(extractBool(text));
        }
    }

    private void decompact(String bool) {
        char[] charVerctor = bool.toCharArray();
        NoArvoreBinaria<IHuffmanChar> atual = arvore.getRaiz();
        for (int i = 0; i < charVerctor.length; i++) {
           char ch = charVerctor[i];
           if (ch == '0') {
               atual = atual.getEsquerda();
           } else {
               atual = atual.getDireita();
           }
           if (atual.getInfo() != null) {
               sb.append(atual.getInfo().getChar());
               atual = arvore.getRaiz();
           }
        }
    }

    private String extractBool(String text) {
        String[] lines = text.split("\n");
        return lines[lines.length-1];
    }


    private void creatTree(ListaEncadeada<IHuffmanChar> tabela) {
        arvore = new ArvoreBinaria<IHuffmanChar>();
        arvore.setRaiz(new NoArvoreBinaria<>(null));
        NoLista<IHuffmanChar> atual = tabela.getPrimeiro();
        while (atual != null) {
            NoArvoreBinaria<IHuffmanChar> noAtual = arvore.getRaiz();
            char[] codigo = atual.getInfo().getCode().toCharArray();

            for (int i = 0; i < codigo.length; i++) {
               if (codigo[i] == '0') {
                  if (noAtual.getEsquerda() == null)
                      noAtual.setEsquerda(new NoArvoreBinaria<IHuffmanChar>(null));
                  noAtual = noAtual.getEsquerda();
               } else {
                   if (noAtual.getDireita() == null)
                       noAtual.setDireita(new NoArvoreBinaria<>(null));
                   noAtual = noAtual.getDireita();
               }
            }
            noAtual.setInfo(atual.getInfo());
            atual = atual.getProximo();
        }
    }

    private static ListaEncadeada<IHuffmanChar> extractTable(String text) {
        String[] lines = text.split("\n");
        int qt = Integer.valueOf(lines[0]);
        ListaEncadeada<IHuffmanChar> tabela = new ListaEncadeada<>();

        for (int i = 1; i <= qt; i++) {
            String[] split = lines[i].split("=");
            Character ch = ((char) Integer.valueOf(split[0]).intValue());
            String code = split[1];
            tabela.inserir(new HuffmanChar(ch, code));
        }

        return tabela;
    }

    public static HuffmanDecompacter getInstance(String text) {
        return new HuffmanDecompacter(text);
    }

    public static HuffmanDecompacter getInstance(TextFile file) {
        return new HuffmanDecompacter(file.getText());
    }

    private void sort(ListaEncadeada<IHuffmanChar> caracteres) {
        NoLista<IHuffmanChar> atual = caracteres.getPrimeiro();
        while (atual.getProximo() != null) {
            NoLista<IHuffmanChar> proximo = atual.getProximo();
            if (proximo.getInfo().getQtChar() > atual.getInfo().getQtChar()) {
                atual.setProximo(proximo.getProximo());
                proximo.setProximo(caracteres.getPrimeiro());
                caracteres.setPrimeiro(proximo);
            }
            atual = proximo;
        }
    }

    public ArvoreBinaria<IHuffmanChar> getArvore() {
        return arvore;
    }

    public String getDecompactedText() {
        return sb.toString();
    }
}
