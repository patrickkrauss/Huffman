package huffman.testes.huffman;

import huffman.HuffmanCompacter;
import huffman.HuffmanDecompacter;
import huffman.estruturas.ListaEncadeada.Generica.NoLista;
import huffman.interfaces.IHuffmanChar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HuffmanTest {

    private static final String CODED1 =
            "6" +
            "\n98=111" +
            "\n111=00" +
            "\n109=01" +
            "\n115=110" +
            "\n101=101" +
            "\n95=100" +
            "\n111000110010111011010110011100011110001";

    private static final String LOREM = "Tem que colocar um dilmes ipsum aqui pra testes futuros\nnovalinha\ttab";

    @BeforeEach
    void setUp() {

    }


    @Test
    void tree() {
        HuffmanCompacter h = HuffmanCompacter.getInstance("bom_esse_bombom");
        System.out.println(h.getCaracteres());
        System.out.println(h.getArvore());
        System.out.println(h.getCompactedText());
    }

    @Test
    void recreateTable() {
        HuffmanDecompacter h = HuffmanDecompacter.getInstance(CODED1);
        System.out.println(h.getArvore());
        System.out.println(h.getDecompactedText());
    }

    @Test
    void integrationTest() {
        HuffmanCompacter compacter = HuffmanCompacter.getInstance(LOREM);
        System.out.println(LOREM);
        String compacted = compacter.getCompactedText();
        System.out.println(compacted);
        HuffmanDecompacter decompacter = HuffmanDecompacter.getInstance(compacted);
        String decompacted = decompacter.getDecompactedText();
        System.out.println(decompacted);
        assertEquals(LOREM, decompacted);
    }

    @Test
    void order() {
        HuffmanCompacter h = HuffmanCompacter.getInstance("aabafaaafadaaaafacasdfasdfa");
        System.out.println(h.getCaracteres());
        NoLista<IHuffmanChar> atual = h.getCaracteres().getPrimeiro();

        assertEquals(Character.valueOf('a'), atual.getInfo().getChar());
        assertEquals(15, atual.getInfo().getQtChar());
        atual = atual.getProximo();

        assertEquals(Character.valueOf('f'), atual.getInfo().getChar());
        assertEquals(5, atual.getInfo().getQtChar());
        atual = atual.getProximo();

        assertEquals(Character.valueOf('d'), atual.getInfo().getChar());
        assertEquals(3, atual.getInfo().getQtChar());
        atual = atual.getProximo();

        assertEquals(Character.valueOf('s'), atual.getInfo().getChar());
        assertEquals(2, atual.getInfo().getQtChar());
        atual = atual.getProximo();

        assertEquals(Character.valueOf('c'), atual.getInfo().getChar());
        assertEquals(1, atual.getInfo().getQtChar());
        atual = atual.getProximo();

        assertEquals(Character.valueOf('b'), atual.getInfo().getChar());
        assertEquals(1, atual.getInfo().getQtChar());
        atual = atual.getProximo();

    }

}
