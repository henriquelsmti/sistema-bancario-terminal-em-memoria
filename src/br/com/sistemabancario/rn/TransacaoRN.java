package br.com.sistemabancario.rn;

import br.com.sistemabancario.dominio.Cliente;

public class TransacaoRN {

    private ClienteRN clienteRN = new ClienteRN();

    public void depositar(long clienteId, double valor) throws Exception{
        Cliente cliente = clienteRN.getClientePorId(clienteId);
        cliente.getConta().depositar(valor);
    }


    public void sacar(long clienteId, double valor) throws Exception{
        Cliente cliente = clienteRN.getClientePorId(clienteId);
        cliente.getConta().retirar(valor);
    }

    public void transferir(long idOrigem, long idDestino, double valor) throws Exception{
        Cliente clienteOrigem = clienteRN.getClientePorId(idOrigem);
        Cliente clienteDestino = clienteRN.getClientePorId(idDestino);
        clienteOrigem.getConta().retirar(valor);
        clienteDestino.getConta().depositar(valor);
    }
}
