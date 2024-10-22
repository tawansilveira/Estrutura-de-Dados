import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
        
            System.out.println("\nBem-vindo ao seu Gerenciador de Músicas!");
            System.out.println("1. Próxima música");
            System.out.println("2. Música anterior");
            System.out.println("3. Ordenar playlist");
            System.out.println("4. Tocar música");
            System.out.println("5. Adicionar música");
            System.out.println("6. Remover música");
            System.out.println("7. Listar músicas");
            System.out.println("8. Sair");
            System.out.print("Digite a opção desejada: ");

            
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    playlist.proximaMusica();
                    break;
                case 2:
                    playlist.musicaAnterior();
                    break;
                case 3:
                    System.out.println("Escolha o critério de ordenação: ");
                    System.out.println("1. Título");
                    System.out.println("2. Artista");
                    int criterio = scanner.nextInt();
                    if (criterio == 1) {
                        playlist.ordenarPorTitulo();
                    } else if (criterio == 2) {
                        playlist.ordenarPorArtista();
                    } else {
                        System.out.println("Critério inválido.");
                    }
                    break;
                case 4:
                    playlist.tocarMusica();
                    break;
                case 5:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Artista: ");
                    String artista = scanner.nextLine();
                    System.out.print("Álbum: ");
                    String album = scanner.nextLine();
                    System.out.print("Duração (em segundos): ");
                    int duracao = scanner.nextInt();
                    scanner.nextLine();

                    Musica musica = new Musica(titulo, artista, album, duracao);

                    System.out.println("Escolha onde adicionar a música:");
                    System.out.println("1. Início");
                    System.out.println("2. Fim");
                    int escolha = scanner.nextInt();
                    scanner.nextLine();

                    if (escolha == 1) {
                        playlist.adicionarNoInicio(musica);
                    } else if (escolha == 2) {
                        playlist.adicionarNoFim(musica);
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 6:
                    System.out.print("Digite o título da música a ser removida: ");
                    String tituloRemover = scanner.nextLine();
                    playlist.removerPorTitulo(tituloRemover);
                    break;
                case 7:
                    playlist.listarMusicas();
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }

        } while (opcao != 8);

        scanner.close();  
    }
}
