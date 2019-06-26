package br.com.sistemabancario.ui.console;

import br.com.sistemabancario.dominio.Cliente;
import br.com.sistemabancario.dominio.ContaCorrente;
import br.com.sistemabancario.rn.ClienteRN;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class ListagemCliente implements Runnable {

    private ClienteRN clienteRN = new ClienteRN();

    @Override
    public void run() {
        List<Cliente> clientes;
        try {
            clientes = clienteRN.listAll();
        } catch (Exception e) {
            System.out.println("Erro ao listar clientes:" + e.getMessage());
            return;
        }
        System.out.println("____________________________________________________________________________________");
        System.out.println("|     ID|Nome               |CPF           |Tipo Conta     |   Ch. esp.|      Saldo|");
        for (Cliente cliente : clientes) {
            System.out.print("|");
            String id = Long.toString(cliente.getId());
            System.out.print(StringUtils.leftPad(id, 7));
            System.out.print("|");
            String nome = StringUtils.truncate(cliente.getNome(), 19);
            System.out.print(StringUtils.rightPad(nome, 19));
            System.out.print("|");
            String cpf = StringUtils.truncate(cliente.getCpf(), 14);
            System.out.print(StringUtils.rightPad(cpf, 14));
            System.out.print("|");
            System.out.print(StringUtils.rightPad(cliente.getConta().getClass().getSimpleName(), 15));
            String valorChequeEspecial = getValorChequeEspecial(cliente);
            System.out.print("|");
            System.out.print(valorChequeEspecial);
            System.out.print("|");
            System.out.print(StringUtils.leftPad(Double.toString(cliente.getConta().getSaldo()), 11));
            System.out.println("|");
        }
        System.out.println("-----------------------------------------------------------------------------------");
    }

    private String getValorChequeEspecial(Cliente cliente) {
        String limite;
        if (cliente.getConta() instanceof ContaCorrente) {
            ContaCorrente contaCorrente = (ContaCorrente) cliente.getConta();
            limite = StringUtils.leftPad(Double.toString(contaCorrente.getLimiteChequeEspecial()), 11);
        } else {
            limite = StringUtils.leftPad("--", 11);
        }
        return limite;
    }
}
