public class ListaEncadeada<T> {
    private Node<T> inicio;
    private int tamanho;


    public ListaEncadeada() {
        this.inicio = null;
        this.tamanho = 0;
    }

    // Verifica se a lista está vazia
    public boolean estaVazia() {
        return inicio == null;
    }

    // Retorna o tamanho da lista
    public int tamanho() {
        return tamanho;
    }

    // Adiciona um elemento no início da lista
    public void adicionarNoInicio(T valor) {
        Node<T> novoNode = new Node<>(valor);
        novoNode.setProximo(inicio);
        inicio = novoNode;
        tamanho++;
    }

    // Adiciona um elemento no final da lista
    public void adicionarNoFim(T valor) {
        Node<T> novoNode = new Node<>(valor);
        if (estaVazia()) {
            inicio = novoNode;
        } else {
            Node<T> atual = inicio;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novoNode);
        }
        tamanho++;
    }

    // Adiciona um elemento em uma posição específica
    public void adicionarNaPosicao(int posicao, T valor) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }

        if (posicao == 0) {
            adicionarNoInicio(valor);
        } else {
            Node<T> novoNode = new Node<>(valor);
            Node<T> atual = inicio;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.getProximo();
            }
            novoNode.setProximo(atual.getProximo());
            atual.setProximo(novoNode);
            tamanho++;
        }
    }

    // Remove e retorna o elemento do início da lista
    public T removerDoInicio() {
        if (estaVazia()) {
            throw new IllegalStateException("A lista está vazia");
        }
        T valorRemovido = inicio.getValor();
        inicio = inicio.getProximo();
        tamanho--;
        return valorRemovido;
    }

    // Remove e retorna o elemento do final da lista
    public T removerDoFim() {
        if (estaVazia()) {
            throw new IllegalStateException("A lista está vazia");
        }

        if (tamanho == 1) {
            T valorRemovido = inicio.getValor();
            inicio = null;
            tamanho--;
            return valorRemovido;
        }

        Node<T> atual = inicio;
        Node<T> anterior = null;
        while (atual.getProximo() != null) {
            anterior = atual;
            atual = atual.getProximo();
        }
        T valorRemovido = atual.getValor();
        anterior.setProximo(null);
        tamanho--;
        return valorRemovido;
    }

    // Remove e retorna o elemento de uma posição específica
    public T removerDaPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }

        if (posicao == 0) {
            return removerDoInicio();
        }

        Node<T> atual = inicio;
        Node<T> anterior = null;
        for (int i = 0; i < posicao; i++) {
            anterior = atual;
            atual = atual.getProximo();
        }
        T valorRemovido = atual.getValor();
        anterior.setProximo(atual.getProximo());
        tamanho--;
        return valorRemovido;
    }

    // Remove o primeiro elemento que contém o valor especificado
    public T removerPorValor(T elemento) {
        if (estaVazia()) {
            throw new IllegalStateException("A lista está vazia");
        }

        if (inicio.getValor().equals(elemento)) {
            return removerDoInicio();
        }

        Node<T> atual = inicio;
        Node<T> anterior = null;
        while (atual != null && !atual.getValor().equals(elemento)) {
            anterior = atual;
            atual = atual.getProximo();
        }

        if (atual == null) {
            throw new IllegalArgumentException("Elemento não encontrado na lista");
        }

        anterior.setProximo(atual.getProximo());
        tamanho--;
        return atual.getValor();
    }

    // Retorna o valor do elemento em uma determinada posição
    public T buscar(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }

        Node<T> atual = inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual.getValor();
    }

    // Retorna a posição do elemento com o valor especificado, ou -1 se não encontrado
    public int buscarPosicao(T valor) {
        Node<T> atual = inicio;
        int posicao = 0;
        while (atual != null) {
            if (atual.getValor().equals(valor)) {
                return posicao;
            }
            atual = atual.getProximo();
            posicao++;
        }
        return -1;
    }

    // Atualiza o valor de um nó em uma posição específica
    public void atualizar(int posicao, T novoValor) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }

        Node<T> atual = inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        atual.setValor(novoValor);
    }

    // Remove todos os elementos da lista
    public void limpar() {
        inicio = null;
        tamanho = 0;
    }

    // Retorna a lista
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> atual = inicio;
        sb.append("[");
        while (atual != null) {
            sb.append(atual.getValor());
            if (atual.getProximo() != null) {
                sb.append(" -> ");
            }
            atual = atual.getProximo();
        }
        sb.append("]");
        return sb.toString();
    }
}

