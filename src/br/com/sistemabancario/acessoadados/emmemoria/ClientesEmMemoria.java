package br.com.sistemabancario.acessoadados.emmemoria;

import br.com.sistemabancario.acessoadados.Clientes;
import br.com.sistemabancario.dominio.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClientesEmMemoria implements Clientes {

    private static List<Cliente> clientes = new ArrayList<>();

    @Override
    public List<Cliente> listAll() throws Exception {
        return new ArrayList<>(clientes);
    }

    @Override
    public void salve(Cliente cliente) throws Exception {
        if (cliente.getId() > 0) {
            remover(cliente.getId());
            clientes.add(cliente);
        } else {
            cliente.setId(getProximoId());
            clientes.add(cliente);
        }
    }

    @Override
    public void remover(long id) throws Exception {
        Cliente cliente = getClientePorId(id);
        clientes.remove(cliente);
    }

    @Override
    public Cliente getClientePorId(long id) throws Exception {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        throw new Exception("Cliente com id " + id + " não foi encontrado");
    }

    private long getProximoId() {
        long maiorId = 0;
        for (Cliente cliente : clientes) {
            if (cliente.getId() > maiorId) {
                maiorId = cliente.getId();
            }
        }
        return maiorId + 1;
    }
}
