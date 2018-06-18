package huffman.interfaces;

public interface IHuffmanChar {
    Character getChar();
    String getCode();
    int getQtChar();
    void setQtChar(int qtChar);
    void incQtChar();
    void setCode(String encoded);
}
