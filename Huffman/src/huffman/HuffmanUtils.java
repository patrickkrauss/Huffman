package huffman;

import huffman.estruturas.ListaEncadeada.Generica.ListaEncadeada;
import huffman.estruturas.ListaEncadeada.Generica.NoLista;

import java.io.*;
import java.nio.charset.*;
import java.util.*;

public class HuffmanUtils {

    public static <T> void sort(ListaEncadeada<T> caracteres, Comparator<T> comparator) {
        int size = caracteres.obterComprimento();
        if (size > 1) {
            for (int i = 0; i < size; i++) {
                NoLista<T> currentNode = caracteres.getPrimeiro();
                NoLista<T> next = currentNode.getProximo();
                for (int j = 0; j < size - 1; j++) {
                    if (comparator.compare(currentNode.getInfo(), next.getInfo()) < 0) {
                        T currentValue = currentNode.getInfo();
                        currentNode.setInfo(next.getInfo());
                        next.setInfo(currentValue);
                    }
                    currentNode = next;
                    next = next.getProximo();
                }
            }
        }
    }

    public static String readFile(String filePath){
        String texto;
        String linha;
        BufferedReader br;

        try {
            texto = "";
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), Charset.defaultCharset()));
            while ((linha = br.readLine()) != null) {
                texto += linha;
                texto += "\n";
            }
        } catch (Exception e) {
            texto = "";
        }
        return texto;
    }

    public static void writeFile(String text, File f) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((new FileOutputStream(f)), Charset.defaultCharset()));
        for (char c : text.toCharArray()) {
            if (c == '\n')
                bw.newLine();
            else
                bw.write(c);
        }
        bw.close();
    }

}
