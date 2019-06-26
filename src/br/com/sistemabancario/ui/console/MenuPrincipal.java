package br.com.sistemabancario.ui.console;

import java.util.Scanner;

public class MenuPrincipal implements Runnable {

    private Scanner scanner = new Scanner(System.in);
    private CadastroCliente cadastroCliente = new CadastroCliente();
    private Deposito deposito = new Deposito();
    private Saque saque = new Saque();
    private Transferencia transferencia = new Transferencia();

    @Override
    public void run() {
        boolean sair = false;

        do {
            ConsoleUtil.clearScreen();
            System.out.println("1 - Cadastro de clientes");
            System.out.println("2 - Deposito");
            System.out.println("3 - Saque");
            System.out.println("4 - Transferencia");
            System.out.println("0 - Sair");
            System.out.println();
            System.out.print("Digite a opção desejada:");

            String opcaoDigitada = scanner.nextLine();

            if (opcaoDigitada.equals("1")) {
                cadastroCliente.run();
            } else if (opcaoDigitada.equals("2")) {
                deposito.deposite();
            } else if (opcaoDigitada.equals("3")) {
                saque.sacar();
            } else if (opcaoDigitada.equals("4")) {
                transferencia.transferir();
            } else if (opcaoDigitada.equals("0")) {
                sair = true;
            } else {
                ConsoleUtil.clearScreen();
                ConsoleUtil.printOpcaoInvalida();
            }
        } while (!sair);
    }

}
