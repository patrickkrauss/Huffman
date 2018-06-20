package huffman;

import huffman.estruturas.ListaEncadeada.Generica.ListaEncadeada;
import huffman.estruturas.ListaEncadeada.Generica.NoLista;
import huffman.estruturas.arvores.ArvoreBinaria.ArvoreBinaria;
import huffman.estruturas.arvores.ArvoreBinaria.NoArvoreBinaria;
import huffman.interfaces.IHuffmanChar;
import huffman.interfaces.TextFile;

import java.util.Comparator;

public class HuffmanCompacter {

    private ListaEncadeada<IHuffmanChar> caracteres;
    private ArvoreBinaria<IHuffmanChar> arvore;

    private StringBuilder compactedSB = new StringBuilder();

    private HuffmanCompacter(String text) {
        if (text != null && !text.equals("")){
            qtChar = text.length();
            startCaracteres(text);
            sort(caracteres);
            startTree();
            encode();
            startHeader();
            compact(text);
        }
    }

    public static HuffmanCompacter getInstance(String text) {
        return new HuffmanCompacter(text);
    }

    public static HuffmanCompacter getInstance(TextFile file) {
        return new HuffmanCompacter(file.getText());
    }

    private void startHeader() {
        Comparator<IHuffmanChar> comparator;
        comparator = Comparator.comparingDouble(iHuffmanChar -> Double.valueOf(iHuffmanChar.getCode()));
        HuffmanUtils.sort(caracteres, comparator);
        compactedSB.append(caracteres.obterComprimento()).append("\n");
        NoLista<IHuffmanChar> atual = caracteres.getPrimeiro();
        while (atual != null){
            String asc = String.valueOf((int) atual.getInfo().getChar().charValue());
            compactedSB.append(asc).append("=").append(atual.getInfo().getCode()).append("\n");
            atual = atual.getProximo();
        }
    }

    private void compact(String text) {
        char[] charVector = text.toCharArray();
        for (int i = 0; i < charVector.length; i++) {
            char c = charVector[i];
            NoLista<IHuffmanChar> atual = caracteres.getPrimeiro();
            while (atual.getInfo().getChar() != c){
                atual = atual.getProximo();
            }
            compactedSB.append(atual.getInfo().getCode());
        }
    }

    private void encode() {

        if (caracteres.getPrimeiro().getProximo() == null){
            enconde(arvore.getRaiz(), "0");
        } else {
            enconde(arvore.getRaiz(), "");
        }
    }

    private static void enconde(NoArvoreBinaria<IHuffmanChar> no, String code) {
        if (no.getInfo().getChar() != null) {
            no.getInfo().setCode(code);
        }
        if (no.getEsquerda() != null)
            enconde(no.getEsquerda(), code + "0");
        if (no.getDireita() != null)
            enconde(no.getDireita(), code + "1");
    }

    private void startTree() {

        arvore = new ArvoreBinaria<IHuffmanChar>();
        arvore.setRaiz(new NoArvoreBinaria<IHuffmanChar>(null));

        ListaEncadeada<NoArvoreBinaria<IHuffmanChar>> pull = new ListaEncadeada<>();
        for (int i = 0; i < caracteres.obterComprimento(); i++) {
            pull.inserir(new NoArvoreBinaria<IHuffmanChar>(caracteres.obterNo(i).getInfo()));
        }

        sortTree(pull);
        while (pull.obterComprimento() > 1) {
            NoArvoreBinaria<IHuffmanChar> primeiro = pull.getPrimeiro().getInfo();
            pull.retirar(primeiro);
            NoArvoreBinaria<IHuffmanChar> segundo = pull.getPrimeiro().getInfo();
            pull.retirar(segundo);
            IHuffmanChar fantasmaChar = new HuffmanChar(primeiro.getInfo().getQtChar() + segundo.getInfo().getQtChar());
            NoArvoreBinaria<IHuffmanChar> fantasmaNo = new NoArvoreBinaria<>(fantasmaChar, primeiro, segundo);
            pull.inserir(fantasmaNo);
            sortTree(pull);
        }

        arvore.setRaiz(pull.getPrimeiro().getInfo());
    }

    private void startCaracteres(String text) {
        this.caracteres = new ListaEncadeada<IHuffmanChar>();
        char[] charVector = text.toCharArray();
        for (int i = 0; i < charVector.length; i++) {
            char inner = charVector[i];
            NoLista<IHuffmanChar> iHuffmanCharNoLista = caracteres.getPrimeiro();
            while (iHuffmanCharNoLista != null && iHuffmanCharNoLista.getInfo().getChar() != inner)
                iHuffmanCharNoLista = iHuffmanCharNoLista.getProximo();

            if (iHuffmanCharNoLista == null) {
                caracteres.inserir(new HuffmanChar(inner,1));
            } else {
                iHuffmanCharNoLista.getInfo().incQtChar();
            }
        }
    }

    private void sortTree(ListaEncadeada<NoArvoreBinaria<IHuffmanChar>> caracteres) {
        Comparator<NoArvoreBinaria<IHuffmanChar>> comparator;
        comparator = Comparator.comparingInt(iHuffmanChar -> iHuffmanChar.getInfo().getQtChar());
        HuffmanUtils.sort(caracteres, comparator.reversed());
    }

    private void sort(ListaEncadeada<IHuffmanChar> caracteres) {
        Comparator<IHuffmanChar> comparator;
        comparator = Comparator.comparingInt(huffman -> huffman.getQtChar());
        HuffmanUtils.sort(caracteres, comparator);
    }

    public ListaEncadeada<IHuffmanChar> getCaracteres() {
        return caracteres;
    }

    public ArvoreBinaria<IHuffmanChar> getArvore() {
        return arvore;
    }

    public String getCompactedText() {
        return compactedSB.toString();
    }
}
