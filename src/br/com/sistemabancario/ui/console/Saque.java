package br.com.sistemabancario.ui.console;

import br.com.sistemabancario.rn.TransacaoRN;

public class Saque {

    private TransacaoRN transacaoRN = new TransacaoRN();

    public void sacar() {

        ConsoleUtil.clearScreen();
        try {
            long id = ConsoleUtil.leiaIdCliente();
            double valor = ConsoleUtil.leiaValor();
            transacaoRN.sacar(id, valor);
        } catch (Exception e) {
            System.out.println("Não foi possivel sacar o valor: " + e.getMessage());
            ConsoleUtil.aguardeUsuario();
        }
    }
}
