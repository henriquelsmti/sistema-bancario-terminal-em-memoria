package br.com.sistemabancario.ui.console;

import br.com.sistemabancario.rn.TransacaoRN;

public class Deposito {

    private TransacaoRN transacaoRN = new TransacaoRN();

    public void deposite() {

        ConsoleUtil.clearScreen();
        try {
            long id = ConsoleUtil.leiaIdCliente();
            double valor = ConsoleUtil.leiaValor();
            transacaoRN.depositar(id, valor);
        } catch (Exception e) {
            System.out.println("Não foi possivel depositar o valor: " + e.getMessage());
            ConsoleUtil.aguardeUsuario();
        }
    }

}
