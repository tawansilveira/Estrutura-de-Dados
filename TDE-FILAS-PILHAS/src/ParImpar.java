import java.util.Scanner;
import java.util.Stack;

public class ParImpar {
    public static void main(String[] args) {
        Stack<Integer> par = new Stack<>();
        Stack<Integer> impar = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite um número: ");
            int numero = scanner.nextInt();

            if (numero == 0) {
                if (!par.isEmpty()) {
                    System.out.println("Desempilhando da pilha par: " + par.pop());
                } else {
                    System.out.println("Erro: pilha par está vazia!");
                }

                if (!impar.isEmpty()) {
                    System.out.println("Desempilhando da pilha ímpar: " + impar.pop());
                } else {
                    System.out.println("Erro: pilha ímpar está vazia!");
                }
            } else if (numero % 2 == 0) {
                System.out.println("Empilhando " + numero + " na pilha par.");
                par.push(numero);
            } else {
                System.out.println("Empilhando " + numero + " na pilha ímpar.");
                impar.push(numero);
            }
        }

        System.out.println("Desempilhando todos os elementos da pilha par:");
        if (par.isEmpty()) {
            System.out.println("Pilha par está vazia!");
        } else {
            while (!par.isEmpty()) {
                System.out.println(par.pop());
            }
        }

        System.out.println("Desempilhando todos os elementos da pilha ímpar:");
        if (impar.isEmpty()) {
            System.out.println("Pilha ímpar está vazia!");
        } else {
            while (!impar.isEmpty()) {
                System.out.println(impar.pop());
            }
        }
    }
}
