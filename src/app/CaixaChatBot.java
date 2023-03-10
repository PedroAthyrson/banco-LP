package app;

import java.util.Locale;
import java.util.Scanner;

public class CaixaChatBot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        int firstChoice = 0;

        do {
            System.out.println("Qual opção você deseja? \n1- Criar uma nova conta" +
                    "\n2- Entrar numa conta já existente");
            firstChoice = sc.nextInt();
        }
        while (firstChoice != 1 && firstChoice != 2);

        if (firstChoice == 1) {
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("CPF: ");
            int cpf = sc.nextInt();
        }

    }
}