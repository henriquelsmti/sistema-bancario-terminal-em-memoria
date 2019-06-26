package br.com.sistemabancario.ui.console;

import java.util.Scanner;

public class ConsoleUtil {

    public static void clearScreen() {

        if (System.console() == null) {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        } else {
            try {
                final String os = System.getProperty("os.name");

                if (os.contains("Windows")) {
                    Runtime.getRuntime().exec("cls");
                } else {
                    Runtime.getRuntime().exec("clear");
                }
            } catch (final Exception e) {
                System.out.println("ops");
            }
        }
    }

    public static void printOpcaoInvalida() {
        System.out.println("Opção invalida!");
        aguardeUsuario();
    }

    public static void printValorInvalido() {
        System.out.println("Valor invalido!");
    }

    public static void aguardeUsuario(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Presione qualquer tecla para continuar...");
        scanner.nextLine();
    }

    public static long leiaIdCliente() {
        return leiaIdCliente("Digite o id do cliente:");
    }

    public static long leiaIdCliente(String msg) {
        boolean sair = false;
        Scanner scanner = new Scanner(System.in);
        long id = 0;
        do {
            try {
                System.out.println(msg);
                id = scanner.nextLong();
                sair = true;
            } catch (Exception e) {
                printValorInvalido();
            }
        } while (!sair);
        return id;
    }

    public static double leiaValor() {
        boolean sair = false;
        Scanner scanner = new Scanner(System.in);
        double valor = 0;
        do {
            try {
                System.out.println("Digite o valor:");
                valor = scanner.nextDouble();
                sair = true;
            } catch (Exception e) {
                printValorInvalido();
            }
        } while (!sair);
        return valor;
    }
}
