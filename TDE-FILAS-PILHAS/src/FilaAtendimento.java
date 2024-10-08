import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Cliente {
    String nome;
    int tempo;

    Cliente(String nome, int tempo) {
        this.nome = nome;
        this.tempo = tempo;
    }
}

public class FilaAtendimento {
    public static void main(String[] args) {
        Queue<Cliente> fila = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int totalClientes = 0;
        int tempoTotal = 0;

        for (int i = 0; i < 3; i++) {
            System.out.print("Digite o nome do cliente: ");
            String nome = scanner.nextLine();
            System.out.print("Digite o tempo de atendimento (minutos): ");
            int tempo = scanner.nextInt();
            scanner.nextLine();
            fila.add(new Cliente(nome, tempo));
        }

        while (!fila.isEmpty()) {
            Cliente cliente = fila.poll();
            System.out.println("Atendendo " + cliente.nome + " (Tempo: " + cliente.tempo + " minutos)");
            totalClientes++;
            tempoTotal += cliente.tempo;
        }

        System.out.println("Total de clientes atendidos: " + totalClientes);
        System.out.println("Tempo total de atendimento: " + tempoTotal + " minutos");
    }
}
