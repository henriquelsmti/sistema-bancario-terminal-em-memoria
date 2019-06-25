package br.com.sistemabancario.ui.console;

import java.util.Scanner;

public class CadastroCliente implements Runnable {


    @Override
    public void run() {
        boolean sair = false;
        Scanner scanner = new Scanner(System.in);
        do {
            ConsoleUtil.clearScreen();
            ListagemCliente listagemCliente = new ListagemCliente();
            listagemCliente.run();
            System.out.println("| V para voltar | N para novo | E {id} para editar | R {id} para remover");
            System.out.print("Digite a opção desejada:");

            String opcaoDigitada = scanner.nextLine();


            if (opcaoDigitada.equalsIgnoreCase("V")) {
                sair = true;
            } else if (opcaoDigitada.equalsIgnoreCase("N")) {

            } else if (opcaoDigitada.toUpperCase().startsWith("E ")) {

            } else if (opcaoDigitada.toUpperCase().startsWith("R")) {

            } else {
                ConsoleUtil.clearScreen();
                System.out.println("Opção invalida!");
                System.out.println("Presione qualquer tecla para continuar...");
                scanner.nextLine();
            }

        } while (!sair);
    }

}
