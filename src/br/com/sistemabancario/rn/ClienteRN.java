package br.com.sistemabancario.rn;

import br.com.sistemabancario.acessoadados.Clientes;
import br.com.sistemabancario.acessoadados.emmemoria.ClientesEmMemoria;
import br.com.sistemabancario.dominio.Cliente;

import java.util.List;

public class ClienteRN {

    private Clientes clientes = new ClientesEmMemoria();

    List<Cliente> listAll() throws Exception {
        return clientes.listAll();
    }

    void save(Cliente cliente) throws Exception {
        if(cliente.getNome() == null || cliente.getNome().isBlank()){
            throw new Exception("Nome invalido!");
        }

        if(cliente.getCpf() == null || cliente.getCpf().isBlank()){
            throw new Exception("CPF invalido!");
        }

        if(cliente.getConta() == null){
            throw new Exception("A conta deve ser definida!");
        }

        clientes.save(cliente);
    }

    void remover(long id) throws Exception {
        Cliente cliente = clientes.getClientePorId(id);
        if (cliente.getConta().getSaldo() != 0) {
            throw new Exception("Não é possivel remover um cliente que contenha saldo!");
        }
        clientes.remover(id);
    }

    Cliente getClientePorId(long id) throws Exception {
        return clientes.getClientePorId(id);
    }
}
