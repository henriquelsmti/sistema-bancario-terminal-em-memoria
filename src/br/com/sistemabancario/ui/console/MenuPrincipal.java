package br.com.sistemabancario.ui.console;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuPrincipal implements Runnable {

    private Map<String, Runnable> opcoes = new HashMap<>();

    private boolean sair = false;

    public MenuPrincipal() {
        opcoes.put("1", new CadastroCliente());

        opcoes.put("0", new Runnable() {
            @Override
            public void run() {
                sair = true;
            }
        });
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        do {
            ConsoleUtil.clearScreen();
            System.out.println("1 - Cadastro de clientes");
            System.out.println("0 - Sair");
            System.out.println();
            System.out.print("Digite a opção desejada:");

            String opcaoDigitada = scanner.nextLine();
            Runnable opcaoSelecionada = opcoes.get(opcaoDigitada);

            if (opcaoSelecionada == null) {
                ConsoleUtil.clearScreen();
                System.out.println("Opção invalida!");
                System.out.println("Presione qualquer tecla para continuar...");
                scanner.nextLine();
            } else {
                opcaoSelecionada.run();
            }

        } while (!sair);
    }

}
