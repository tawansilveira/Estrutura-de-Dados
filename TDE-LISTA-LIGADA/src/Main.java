public class Main {
    public static void main(String[] args) {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        // Adicionando elementos
        lista.adicionarNoInicio(3);
        lista.adicionarNoInicio(2);
        lista.adicionarNoFim(4);
        lista.adicionarNaPosicao(1, 5);

        System.out.println("Lista após inserções: " + lista);

        // Removendo elementos
        int removidoInicio = lista.removerDoInicio();
        System.out.println("Removido do início: " + removidoInicio);
        System.out.println("Lista: " + lista);

        int removidoFim = lista.removerDoFim();
        System.out.println("Removido do fim: " + removidoFim);
        System.out.println("Lista: " + lista);

        int removidoPos = lista.removerDaPosicao(0);
        System.out.println("Removido da posição 0: " + removidoPos);
        System.out.println("Lista: " + lista);

        // Adicionando novamente para testes
        lista.adicionarNoFim(6);

        // Remover por valor
        lista.removerPorValor(6);
        System.out.println("Removido por valor 6");
        System.out.println("Lista: " + lista);

        // Buscar elementos
        lista.adicionarNoFim(7);
        lista.adicionarNoFim(8);
        System.out.println("Lista: " + lista);
        System.out.println("O elemento na posição 1: " + lista.buscar(1));
        System.out.println("A posição do elemento d igitado: " + lista.buscarPosicao(7));

        // Atualizar elemento
        lista.atualizar(1, 9);
        System.out.println("Lista após atualização: " + lista);

        // Tamanho e verificação se está vazia
        System.out.println("Tamanho da lista: " + lista.tamanho());
        System.out.println("A lista está vazia? " + lista.estaVazia());

        // Limpar a lista
        lista.limpar();
        System.out.println("Lista após limpar: " + lista);
        System.out.println("Tamanho da lista: " + lista.tamanho());
    }
}
