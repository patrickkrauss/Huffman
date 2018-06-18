package huffman.estruturas.ListaEncadeada.Generica;

public class NoLista<T> {

    private T info;
    private NoLista proximo;

    public NoLista(T info) {
        setInfo(info);
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoLista<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoLista proximo) {
        this.proximo = proximo;
    }

    @Override                                    //TODO   pq precisa de override?          //iremos usar wildcard?
    public String toString() {
        return info.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        // Invoke the finalizer of our superclass
        // We haven't discussed superclasses or this syntax yet
        System.out.println("dead: " + toString());
        super.finalize();
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoLista<?> noLista = (NoLista<?>) o;
        return Objects.equals(getInfo(), noLista.getInfo());
    }*/


}
