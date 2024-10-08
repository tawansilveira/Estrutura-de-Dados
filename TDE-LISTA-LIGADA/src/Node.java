public class Node<T> {
    private T valor;
    private Node<T> proximo;

    // Construtor
    public Node(T valor) {
        this.valor = valor;
        this.proximo = null;
    }

    // Getter para valor
    public T getValor() {
        return valor;
    }

    // Setter para valor
    public void setValor(T valor) {
        this.valor = valor;
    }

    // Getter para próximo
    public Node<T> getProximo() {
        return proximo;
    }

    // Setter para próximo
    public void setProximo(Node<T> proximo) {
        this.proximo = proximo;
    }
}
