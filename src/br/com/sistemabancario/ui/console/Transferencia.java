package br.com.sistemabancario.ui.console;

import br.com.sistemabancario.rn.TransacaoRN;

public class Transferencia {

    private TransacaoRN transacaoRN = new TransacaoRN();

    public void transferir() {
        ConsoleUtil.clearScreen();
        try {
            long id = ConsoleUtil.leiaIdCliente();
            double valor = ConsoleUtil.leiaValor();
            long idDestino = ConsoleUtil.leiaIdCliente("Digite o id do favorecido:");
            transacaoRN.transferir(id, idDestino, valor);
        } catch (Exception e) {
            System.out.println("Não foi possivel sacar o valor: " + e.getMessage());
            ConsoleUtil.aguardeUsuario();
        }
    }
}
