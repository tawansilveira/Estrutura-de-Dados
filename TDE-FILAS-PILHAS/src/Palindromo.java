import java.util.Scanner;
import java.util.Stack;

public class Palindromo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma sequência de caracteres: ");
        String palavra = scanner.nextLine();

        Stack<Character> pilha = new Stack<>();
        for (int i = 0; i < palavra.length() / 2; i++) {
            pilha.push(palavra.charAt(i));
        }

        boolean ehPalindromo = true;
        for (int i = (palavra.length() + 1) / 2; i < palavra.length(); i++) {
            if (pilha.isEmpty() || pilha.pop() != palavra.charAt(i)) {
                ehPalindromo = false;
                break;
            }
        }

        if (ehPalindromo) {
            System.out.println("É um palíndromo.");
        } else {
            System.out.println("Não é um palíndromo.");
        }
    }
}
