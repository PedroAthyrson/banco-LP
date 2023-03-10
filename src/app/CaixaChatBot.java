package app;

import banco.entidades.ContaSimples;
import banco.entidades.util.Data;

import java.util.*;

public class CaixaChatBot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        int firstChoice = 0;
        List<ContaSimples> listaContas = new ArrayList<>();

        do {
            System.out.println("Qual opção você deseja? \n1- Criar uma nova conta" +
                    "\n2- Entrar numa conta já existente");
            firstChoice = sc.nextInt();

            if (firstChoice == 1) {
                System.out.print("Nome: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("CPF: ");
                String cpf = sc.nextLine();
                ContaSimples conta = new ContaSimples(name, cpf);
                System.out.println(conta);
                listaContas.add(conta);

            }
        }
        while (firstChoice != 2);

        System.out.print("Qual o número da conta? ");
        int accountNumber = sc.nextInt();
        for (ContaSimples conta: listaContas) {
            if (accountNumber == conta.getNúmero()) {
                int secondChoice = 0;
                while (secondChoice != 6){
                    System.out.println("""
                            Escolha a opção desejada:
                            1- Depositar
                            2- Sacar
                            3- Extrato
                            4- Transferir
                            5- Saldo
                            6- Sair""");
                    secondChoice = sc.nextInt();

                    switch (secondChoice){
                        case 1:
                            System.out.print("Valor do depósito: ");
                            double deposito = sc.nextDouble();
                            conta.depositar(deposito);
                            break;
                        case 2:
                            System.out.print("Valor do saque: ");
                            double saque = sc.nextDouble();
                            conta.sacar(saque);
                            break;
                        case 3:
                            System.out.print("Data inicial: ");

                            System.out.print(conta.criarExtrato());
                    }
                }
            }
        }


    }
}