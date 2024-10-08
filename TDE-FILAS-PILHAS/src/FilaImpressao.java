import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Documento {
    String nome;
    int paginas;

    Documento(String nome, int paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }
}

public class FilaImpressao {
    public static void main(String[] args) {
        Queue<Documento> fila = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int totalPaginas = 0;
        Documento maiorDoc = null;

        for (int i = 0; i < 3; i++) {
            System.out.print("Digite o nome do documento: ");
            String nome = scanner.nextLine();
            System.out.print("Digite o número de páginas: ");
            int paginas = scanner.nextInt();
            scanner.nextLine();
            Documento doc = new Documento(nome, paginas);
            fila.add(doc);
            if (maiorDoc == null || doc.paginas > maiorDoc.paginas) {
                maiorDoc = doc;
            }
        }

        int contador = 0;
        while (!fila.isEmpty()) {
            Documento doc = fila.poll();
            System.out.println("Imprimindo: " + doc.nome + " (" + doc.paginas + " páginas)");
            totalPaginas += doc.paginas;
            contador++;

            if (contador % 2 == 0 && !fila.isEmpty()) {
                Documento prox = fila.peek();
                System.out.println("Próximo documento: " + prox.nome + " (" + prox.paginas + " páginas)");
            }
        }

        System.out.println("Documento com mais páginas: " + maiorDoc.nome + " (" + maiorDoc.paginas + " páginas)");
        System.out.println("Total de páginas impressas: " + totalPaginas);
    }
}
