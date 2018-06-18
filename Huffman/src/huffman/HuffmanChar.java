package huffman;

import huffman.interfaces.IHuffmanChar;

public class HuffmanChar implements IHuffmanChar {

    private Character c;
    private int i;
    private String code;

    @Override
    public Character getChar() {
        return c;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public int getQtChar() {
        return i;
    }

    @Override
    public void setQtChar(int qtChar) {
        i = qtChar;
    }

    @Override
    public void incQtChar() {
        i++;
    }

    @Override
    public String toString() {
        return "(" + String.valueOf(c) + ", " + String.valueOf(code)+ ", " + String.valueOf(i) + ")";
    }

    @Override
    public void setCode(String encoded) {
        this.code = encoded;
    }

    public HuffmanChar(Character c, String code){
        this.c = c;
        this.code = code;
    }

    public HuffmanChar(Character c, int i){
        this.c = c;
        this.i = i;
    }

    public HuffmanChar(int i){
        this.i = i;
    }

}
