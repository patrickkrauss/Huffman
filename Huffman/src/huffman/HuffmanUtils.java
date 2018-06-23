package huffman;


import huffman.estruturas.ListaEncadeada.Generica.ListaEncadeada;
import huffman.estruturas.ListaEncadeada.Generica.NoLista;
import huffman.interfaces.TextFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

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

    /*public static String readFile(String filePath) {

        String line = "";
        String result = "";
        try {

            FileReader fileReader = new FileReader(filePath);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                result += line + "\n";
            }

            bufferedReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }*/

    public static TextFile readFile(String filePath)  {
        List<String> LINES = null;
        try {
            LINES = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> finalLINES = LINES;
        return new TextFile() {
            @Override
            public String getText() {
                StringBuilder sb = new StringBuilder();
                finalLINES.forEach(l->sb.append(l));
                return  sb.toString();
            }
        };
    }

    public static void writeFile(String text, File f) throws IOException {
        Files.write(Paths.get(f.toURI()), new Iterable<CharSequence>() {
            @Override
            public Iterator<CharSequence> iterator() {
                return new Iterator<CharSequence>() {
                    boolean b = true;

                    @Override
                    public boolean hasNext() {
                        return b;
                    }

                    @Override
                    public CharSequence next() {
                        b = false;
                        return text;
                    }
                };
            }
        });
    }

    public static void main(String[] args) throws IOException {
        String s = Paths.get("").toAbsolutePath() + "/teste";

        try {
            writeFile("blabla \nasd", new File(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------");
        System.out.println(readFile(s).getText());
        /*try {
            System.out.println(readFile(Paths.get("/").toFile()).getText());
            writeFile("asdfasdf", Paths.get("temp.txt").toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

}
