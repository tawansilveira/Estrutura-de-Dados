import java.util.Scanner;
import java.util.Stack;

public class ParentesesBalanceados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma expressão: ");
        String expressao = scanner.nextLine();

        Stack<Character> pilha = new Stack<>();
        boolean balanceado = true;

        for (char ch : expressao.toCharArray()) {
            if (ch == '(') {
                pilha.push(ch);
            } else if (ch == ')') {
                if (pilha.isEmpty()) {
                    balanceado = false;
                    break;
                } else {
                    pilha.pop();
                }
            }
        }

        if (balanceado && pilha.isEmpty()) {
            System.out.println("Balanceado.");
        } else {
            System.out.println("Não balanceado.");
        }
    }
}
