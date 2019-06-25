package br.com.sistemabancario.acessoadados;

import br.com.sistemabancario.dominio.Cliente;

import java.util.List;

public interface Clientes {

    List<Cliente> listAll() throws Exception ;

    void salve(Cliente cliente) throws Exception ;

    void remover(long id) throws Exception;

    Cliente getClientePorId(long id) throws Exception;
}
