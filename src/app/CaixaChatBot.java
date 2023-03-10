package app;

import banco.entidades.ContaSimples;
import banco.entidades.util.Data;

import java.util.*;

public class CaixaChatBot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        int firstChoice;
        List<ContaSimples> listaContas = new ArrayList<>();

        do {
            System.out.println("""
                    Qual opção você deseja?\s
                    1- Criar uma nova conta
                    2- Entrar numa conta já existente""");
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
        long accountNumberValidation = 0;
        for (ContaSimples conta: listaContas) {
            if (accountNumber == conta.getNúmero()) {
                accountNumberValidation = conta.getNúmero();
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
                            System.out.print("Digite a data inicial (DD/MM/YYYY): ");
                            sc.useDelimiter("/|\\s+");

                            int initialDay = sc.nextInt();
                            int initialMonth = sc.nextInt();
                            int initialYear = sc.nextInt();

                            System.out.print("Digite a data final (DD/MM/YYYY): ");
                            int finalDay = sc.nextInt();
                            int finalMonth = sc.nextInt();
                            int finalYear = sc.nextInt();

                            System.out.println(conta.criarExtrato(new Data(initialDay, initialMonth, initialYear),
                                    new Data(finalDay, finalMonth, finalYear)).formatar());
                            break;
                        case 4:
                            System.out.print("Digite o número da conta destino: ");
                            int account = sc.nextInt();
                            System.out.print("Digite o valor da trasferência: R$");
                            double transferAmount = sc.nextDouble();
                            conta.transferir(listaContas.get((account - 1)), transferAmount);
                            break;
                        case 5:
                            System.out.printf("Saldo: R$ %.2f\n", conta.getSaldo());
                            break;
                        case 6:
                            System.out.printf("Saldo final da conta: R$ %.2f", conta.getSaldo());
                            break;
                    }
                }
            }
        }
        if (accountNumberValidation == 0) {
            System.out.println("A conta informada não existe!");
        }
    }
}