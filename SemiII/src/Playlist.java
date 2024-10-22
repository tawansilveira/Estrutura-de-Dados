import java.util.Comparator;
import java.util.Scanner;

public class Playlist {
    private No primeiro;
    private No ultimo;
    private No atual;

    public Playlist() {
        this.primeiro = null;
        this.ultimo = null;
        this.atual = null;
    }

    
    public void adicionarNoFim(Musica musica) {
        No novo = new No(musica);
        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
            atual = novo;
        } else {
            ultimo.setProximo(novo);
            novo.setAnterior(ultimo);
            ultimo = novo;
        }
    }

    
    public void adicionarNaPosicao(Musica musica, int posicao) {
        No novo = new No(musica);
        if (posicao == 1) {
            adicionarNoInicio(musica);
        } else {
            No temp = primeiro;
            int contador = 1;
            while (contador < posicao - 1 && temp.getProximo() != null) {
                temp = temp.getProximo();
                contador++;
            }
            novo.setProximo(temp.getProximo());
            if (temp.getProximo() != null) {
                temp.getProximo().setAnterior(novo);
            }
            temp.setProximo(novo);
            novo.setAnterior(temp);
        }
    }

    public void adicionarNoInicio(Musica musica) {
        No novo = new No(musica);
        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
            atual = novo;
        } else {
            novo.setProximo(primeiro);
            primeiro.setAnterior(novo);
            primeiro = novo;
        }
    }

    
    public void removerPorTitulo(String titulo) {
        No temp = primeiro;
        while (temp != null) {
            if (temp.getMusica().getTitulo().equalsIgnoreCase(titulo)) {
                if (temp == primeiro) {
                    primeiro = temp.getProximo();
                    if (primeiro != null) primeiro.setAnterior(null);
                } else if (temp == ultimo) {
                    ultimo = temp.getAnterior();
                    ultimo.setProximo(null);
                } else {
                    temp.getAnterior().setProximo(temp.getProximo());
                    temp.getProximo().setAnterior(temp.getAnterior());
                }
                System.out.println("Música '" + titulo + "' removida.");
                return;
            }
            temp = temp.getProximo();
        }
        System.out.println("Música não encontrada.");
    }


    public void proximaMusica() {
        if (atual != null && atual.getProximo() != null) {
            atual = atual.getProximo();
            tocarMusica();
        } else {
            System.out.println("Fim da playlist.");
        }
    }

    
    public void musicaAnterior() {
        if (atual != null && atual.getAnterior() != null) {
            atual = atual.getAnterior();
            tocarMusica();
        } else {
            System.out.println("Início da playlist.");
        }
    }

    
    public void tocarMusica() {
        if (atual != null) {
            System.out.println("Tocando agora: " + atual.getMusica());
        } else {
            System.out.println("Nenhuma música na playlist.");
        }
    }

    
    public void listarMusicas() {
        No temp = primeiro;
        while (temp != null) {
            System.out.println(temp.getMusica());
            temp = temp.getProximo();
        }
    }

    
    public void ordenarPorTitulo() {
        if (primeiro == null || primeiro.getProximo() == null) return;

        for (No i = primeiro; i != null; i = i.getProximo()) {
            for (No j = i.getProximo(); j != null; j = j.getProximo()) {
                if (i.getMusica().getTitulo().compareToIgnoreCase(j.getMusica().getTitulo()) > 0) {
                    Musica temp = i.getMusica();
                    i.setMusica(j.getMusica());
                    j.setMusica(temp);
                }
            }
        }
        System.out.println("Playlist ordenada por título.");
    }

    
    public void ordenarPorArtista() {
        if (primeiro == null || primeiro.getProximo() == null) return;

        for (No i = primeiro; i != null; i = i.getProximo()) {
            for (No j = i.getProximo(); j != null; j = j.getProximo()) {
                if (i.getMusica().getArtista().compareToIgnoreCase(j.getMusica().getArtista()) > 0) {
                    Musica temp = i.getMusica();
                    i.setMusica(j.getMusica());
                    j.setMusica(temp);
                }
            }
        }
        System.out.println("Playlist ordenada por artista.");
    }
}
