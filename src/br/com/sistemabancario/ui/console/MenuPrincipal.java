package br.com.sistemabancario.ui.console;

import java.util.Scanner;

public class MenuPrincipal implements Runnable {

    private Scanner scanner = new Scanner(System.in);
    private CadastroCliente cadastroCliente = new CadastroCliente();

    @Override
    public void run() {
        boolean sair = false;

        do {
            ConsoleUtil.clearScreen();
            System.out.println("1 - Cadastro de clientes");
            System.out.println("0 - Sair");
            System.out.println();
            System.out.print("Digite a opção desejada:");

            String opcaoDigitada = scanner.nextLine();

            if(opcaoDigitada.equals("1")){
                cadastroCliente.run();
            }else if(opcaoDigitada.equals("0")){
                sair = false;
            }else {
                ConsoleUtil.clearScreen();
                System.out.println("Opção invalida!");
                System.out.println("Presione qualquer tecla para continuar...");
                scanner.nextLine();
            }
        } while (!sair);
    }

}
